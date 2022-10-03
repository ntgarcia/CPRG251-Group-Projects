package sait.bms.problemdomain;

public class Periodicals extends Book {

    private String frequency;

    public Periodicals(String isbn, String call_num, String available, String total,
    		String title, String frequency) {
    	
    	super(isbn, call_num, available, total, title);
		this.frequency = frequency;
		


    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    /**
     * returns the saved_books
     * 
     * @return the saved_books
     */
	 public String saved_books() {
		 return getISBN() + ";" + getCall_num() + ";" + getAvailable() + ";" + getTotal() + ";" + 
	 getTitle() + ";"  + getFrequency();
	 }
}
