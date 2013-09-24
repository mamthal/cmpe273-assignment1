package edu.sjsu.cmpe.library.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.dto.AuthorDto;
import edu.sjsu.cmpe.library.dto.LinkDto;
import edu.sjsu.cmpe.library.domain.Library;
import java.util.List;

@Path("/v1/books/{isbn}/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AuthorResource {
	private Library library;
	public AuthorResource(Library library) {
		this.library = library; 
	}
	
	@GET
    @Path("/{id}")
    @Timed(name = "view-author")
    public Response getAuthorByID(@PathParam("isbn") int isbn, @PathParam("id") int id) {
		Author author = library.getAuthorByID(isbn, id);
		if(author == null)
		{
			String message = "Not a valid Author ID/ ISBN.";
			return Response.status(404).entity(message).build();
		}
		AuthorDto authorResponse = new AuthorDto(author);
		authorResponse.addLink(new LinkDto("view-author", "/books/" + isbn + "/authors/" + id,"GET"));
		return Response.status(200).entity(authorResponse).build();
	}
	
	@GET
	@Path("/")
	@Timed(name = "view-all-authors")
	public Response getAllAuthors(@PathParam("isbn") int isbn) {
		List<Author> authors = library.getAllAuthors(isbn);
		if(authors == null)
		{
			String message = "No Authors found. Check ISBN number for book";
			return Response.status(400).entity(message).build();
		}
		return Response.status(200).entity(authors).build();
	}
}
