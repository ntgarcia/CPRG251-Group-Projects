package sait.bms.manager;


public class Book
{
	private  long isbn;
	private String call_num;
	private int available;
	private int total;
	private String title;
	private String saved_books;
	
	/**
	 * returns the saved_books
	 * 
	 * @return saved_books
	 */
	public String getSaved_books() {
		return saved_books;
	}
	/**
	 * sets the saved_books
	 * 
	 * @param saved_books the saved_books to set
	 */
	public void setSaved_books(String saved_books) {
		this.saved_books = saved_books;
	}
	
	/** 
	 * @param isbn
	 * @param call_num
	 * @param available
	 * @param total
	 * @param title
	 */
	
	public Book(long isbn, String call_num, int available, int total, String title) {
        this.isbn = isbn;
        this.call_num = call_num;
        this.available = available;
        this.total = total;
        this.title = title;
    }

	/**
	 * returns the isbn
	 * 
	 * @return the isbn
	 */
    public long getIsbn() {
        return isbn;
    }
    /**
    * set the isbn
    * 
    * @param isbn the isbn to set
    */

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    /**
	 * returns the call_num
	 * 
	 * @return the call_num
	 */

    public String getCall_num() {
        return call_num;
    }
    /**
     * set the call_num
     * 
     * @param isbn the call_num to set
     */

    public void setCall_num(String call_num ) {
        this.call_num = call_num;
    }
    
    /**
   	 * returns the available
   	 * 
   	 * @return the available
   	 */
    
    public int getAvailable() {
        return available;
    }
     
    /**
     * set the available
     * 
     * @param isbn the available to set
     */
    
    public void setAvailable(int available) {
        this.available = available;
    }
    /**
   	 * returns the total
   	 * 
   	 * @return the total
   	 */
    public int getTotal() {
        return total;
    }
     
    /**
     * set the total
     * 
     * @param isbn the total to set
     */
    
    public void setTotal(int total) {
        this.total = total;
    }

    /**
   	 * returns the title
   	 * 
   	 * @return the title
   	 */
    
    public String getTitle() {
        return title;
    }
     
    /**
     * set the title
     * 
     * @param isbn the title to set
     */
    
    public void setTitle(String title) {
        this.title = title;
    }
}
	
