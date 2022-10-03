package sait.bms.problemdomain;

import sait.bms.manager.Book;

public class Paperbacks extends Book {

    private String author;
    private String year;
    private String genre;

    public Paperbacks(String isbn, String call_num, String available, String total, String title, String author,
            String year, String genre) {
    	super(isbn, call_num, available, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
		

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * returns the saved_books
     * 
     * @return the saved_books
     */
	 public  String saved_books() {
		 return getISBN() + ";" + getCall_num() + ";" + getAvailable() + ";" + getTotal() + ";" + 
	 getTitle() + ";"  + getAuthor() + ";"+ getYear() + ";" + getGenre();
	 }

}
