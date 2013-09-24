package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
	
	private int id;
	@JsonProperty("name")
	private String name;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id = id;
	}

}
