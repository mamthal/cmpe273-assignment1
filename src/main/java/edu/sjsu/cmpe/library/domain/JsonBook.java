package edu.sjsu.cmpe.library.domain;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonBook {
	@JsonProperty("title")
	private String title;
	@JsonProperty("publication-date")
	private String publicationdate;
	@JsonProperty("language")
	private String language;
	@JsonProperty("num-pages")
	private int numpages;
	@JsonProperty("status")
	private String status;
	@JsonProperty("authors")
	private List<Author> authors;
	
	public JsonBook ()
	{
		authors = new ArrayList<Author>();
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	@JsonProperty("publication-date")
	public String getPublicationDate()
	{
		return this.publicationdate;
	}
	public String getLanguage()
	{
		return this.language;
	}
	
	@JsonProperty("num-pages")
	public int getPages()
	{
		return this.numpages;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public List<Author> getAuthors()
	{
		return this.authors;
	}
}
