package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Book;

@JsonPropertyOrder(alphabetic = true)
public class BookDto extends LinksDto {
    private Book book;
    private LinksDto reviews;
    private LinksDto authors;

    /**
     * @param book
     */
    public BookDto(Book book) {
	super();
	this.book = book;
    }

    /**
     * @return the book
     */
    public Book getBook() {
	return book;
    }

    /**
     * @param book
     *            the book to set
     */
    public void setBook(Book book) {
	this.book = book;
    }
    
    public void setAuthors(LinksDto authors)
    {
    	this.authors = authors;
    }
    
    public LinksDto getAuthors()
    {
    	return this.authors;
    }
    
    public void setReviews(LinksDto reviews)
    {
    	this.reviews = reviews;
    }
    
    public LinksDto getReviews()
    {
    	return this.reviews;
    }
}
