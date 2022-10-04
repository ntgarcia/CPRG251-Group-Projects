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

	public void setAuthors(String auths) {
		this.authors = auths;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public String printChild() {
	    return String.format(
	                "ISBN:%25s%nCall Number:%16s%nAvailable:%7d%nTotal:%20d%nTitle:%20s%nAuthors:%20s%nFormat%20s%n",
	                getIsbn(), getCallNumber(), getAvailable(), getTotal(), getTitle(), getAuthors(), getFormat());

	}

	@Override
	public String toString() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";" + getAuthors() + ";" + getFormat();
	}
	
	

}
