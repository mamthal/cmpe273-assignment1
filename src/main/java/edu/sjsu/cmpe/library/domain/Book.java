package edu.sjsu.cmpe.library.domain;

public class Book {
    private int isbn;
    private String title;
    private String publicationdate;
    private String language;
    private int numpages;
    private String status; 
    
    public Book()
    {
    	this.status = "available";
    }
    /**
     * @return the isbn
     */
    public int getIsbn() {
	return isbn;
    }

    /**
     * @param isbn
     *            the isbn to set
     */
    public void setIsbn(int isbn) {
	this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }
    
    public String getDate()
    {
    	return publicationdate;
    }
    public void setDate(String date)
    {
    	this.publicationdate=date;	
    }
    public String getlanguage()
    {
    	return language;
    }
    public void setLanguage(String language)
    {
    	this.language= language;
    }
    public int getPages()
    {
    	return numpages;
    }
    public void setPages(int pages)
    {
    	this.numpages=pages;
    }
    public String getStatus()
    {
    	return status;
  
    }
    public void setStatus(String status)
    {
    	this.status=status;
    }
}



