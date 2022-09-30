package sait.bms.problemdomain;

public class Childrens_books extends Book {

	private String authors;
	private String format;

	public Childrens_books(String isbn, String callNumber, String available, String total, String title, String authors,
			String format) {

	}

	public String getAuths() {
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
}
