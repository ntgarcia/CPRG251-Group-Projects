package sait.bms.problemdomain;

public class Cook_books extends Book {
     
	//attributes
    private String publisher;
    private String diet;
    
    /**
	 * @param isbn
	 * @param call_num
	 * @param available
	 * @param total
	 * @param title
	 * @param author
	 * @param format
	 */

    public Cook_books (long isbn, String call_num, int available, int total,
			String title, String publisher, String diet) {
    	
    	super(isbn, call_num, available, total, title);
		this.publisher = publisher;
		this.diet = diet;

    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }
    /**
     * returns the saved_books
     * 
     * @return the saved_books
     */
	 public String saved_books() {
		 return getIsbn() + ";" + getCall_num() + ";" + getAvailable() + ";" + getTotal() + ";" + 
	 getTitle() + ";" + getPublisher() + ";" + getDiet();
	 }
     
	 
}
