package sait.bms.problemdomain;

public class Childrens_books extends Book {
	
	//attributes
	private String format;
	private String author;
	
	
	/**
	 * @param isbn
	 * @param call_num
	 * @param available
	 * @param total
	 * @param title
	 * @param author
	 * @param format
	 */
	
	public Childrens_books (long isbn, String call_num, int available, int total,
			String title, String author, String format)
	{
		
		
		super(isbn, call_num, available, total, title);
		this.author = author;
		this.format = format;

	}
	/**
	 * @return the author
	 */
	
	public String getAuthor()
	{
		return author;
	}
	/**
	 * @return the format
	 */
	 
	public String getFormat()
	{
		return format;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author)
	{
		this.author= author;
	}
	
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format)
	{
		this.format = format;
	}
	
    /**
     * returns the saved_books
     * 
     * @return the saved_books
     */
	 public String saved_books() {
		 return getISBN() + ";" + getCall_num() + ";" + getAvailable() + ";" + getTotal() + ";" + 
	 getTitle() + ";" + getAuthor() + ";" + getFormat();
	 }
	 
	public String toString() {
	 
		if( format.contains("P")) {
			format = "Picture book";
		}
		if( format.contains("E")) {
			format = "Early Readers";
		}
		if( format.contains("C")) {
			format = "Chapter book";
		}
		 return "ISBN:" getIsbn() + "Call Number: " + getCall_num() + "Available: " + getAvailable() +
				 "Total: " + getTotal() + "Title: " + getTitle() + "Author: " + getAuthor() + "format" +format ;
		
	}
	
    

}


