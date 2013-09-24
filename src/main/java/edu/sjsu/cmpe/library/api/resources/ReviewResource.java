package edu.sjsu.cmpe.library.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.library.domain.Review;
import edu.sjsu.cmpe.library.dto.ReviewDto;
import edu.sjsu.cmpe.library.dto.LinkDto;
import edu.sjsu.cmpe.library.dto.LinksDto;
import edu.sjsu.cmpe.library.domain.Library;

import java.util.List;

@Path("/v1/books/{isbn}/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ReviewResource {
	private Library library;
	public ReviewResource(Library library) {
		this.library = library; 
	}

	@GET
    @Path("/{id}")
    @Timed(name = "view-review")
	public Response getReviewByID(@PathParam("isbn") int isbn, @PathParam("id") int id) {
		Review review = library.getReviewByID(isbn, id);
		if(review == null)
		{
			String message = "Not a valid review ID";
			return Response.status(400).entity(message).build();
		}
		ReviewDto reviewResponse = new ReviewDto(review);
		reviewResponse.addLink(new LinkDto("view-review", "/books/" + isbn + "/reviews/" + id,"GET"));
		return Response.status(200).entity(reviewResponse).build();
	}
	
	@GET
	@Path("/")
	@Timed(name = "view-all-review")
	public Response getAllReviews(@PathParam("isbn") int isbn) {
		List<Review> reviews = library.getAllReviews(isbn);
		if(reviews == null)
		{
			String message = "No Reviews found. Check ISBN number for book";
			return Response.status(400).entity(message).build();
		}
		return Response.status(200).entity(reviews).build();
	}
	
	@POST
	@Path("/")
	@Timed(name = "create-review")
	public Response createReview(@PathParam("isbn") int isbn, Review review){
		if(review.getRating() < 1 || review.getRating() > 5)
			return Response.status(400).entity("Invalid rating provided. Please provide a value between 1 and 5.").build();
		if(!library.addReview(isbn, review))
		{
			String message = "Unable to add review. Check if the ISBN is valid.";
			return Response.status(400).entity(message).build();
		}
		LinksDto reviewResponse = new LinksDto();
		int id = library.getNumReviews(isbn);
		if(id <= 0)
			return Response.status(500).entity("Problem retrieving review id").build();
		reviewResponse.addLink(new LinkDto("view-review", "/books/" + isbn + "/reviews/" + id,"GET"));
		return Response.status(200).entity(reviewResponse).build();
	}
}
