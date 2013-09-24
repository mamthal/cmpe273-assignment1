package edu.sjsu.cmpe.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {

	private int id;
	@JsonProperty("rating")
	private int rating;
	@JsonProperty("comment")
	private String comment;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getRating()
	{
		return rating;
	}
	public void setRating(int rating)
	{
		this.rating=rating;
		
	}
	public String getComment()
	{
		return comment;
	}
	public void setComment(String comment)
	{
		this.comment=comment;
	}
}

