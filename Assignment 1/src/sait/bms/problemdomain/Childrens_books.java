package sait.bms.problemdomain;

public class Childrens_books extends Book {

	private String authors;
	private String format;

	public Childrens_books(String isbn, String callNumber, int available, int total, String title, String authors,
			String format) {
        super(isbn, callNumber, available, total, title);
        this.authors = authors;
        this.format = format;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuths(String auths) {
		this.authors = auths;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

    @Override
    public String toString() {
//        return "Childrens_books [getAuthors()=" + getAuthors() + ", getFormat()=" + getFormat() + ", getIsbn()=" + getIsbn()
//                + ", getCallNumber()=" + getCallNumber() + ", getAvailable()=" + getAvailable() + ", getTotal()="
//                + getTotal() + ", getTitle()=" + getTitle() + "]";
          return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() + "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
          + "\r\n" + "Title: " + getTitle() + "\r\n" + "Authors: " + getAuthors() + "\r\n" + "Format: " + getFormat();
    }
	
	
}
