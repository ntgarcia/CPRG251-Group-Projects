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
		String sIsbn = String.format("%-15s%-15s%n", "ISBN:", getIsbn());
		String sCN = String.format("%-15s%-15s%n", "Call Number:", getCallNumber());
		String sAv = String.format("%-15s%-15d%n", "Available:", getAvailable());
		String sTo = String.format("%-15s%-15d%n", "Total:", getTotal());
		String sTi = String.format("%-15s%-15s%n", "Title:", getTitle());
		String sAu = String.format("%-15s%-15s%n", "Authors:", getAuthors());
		String sFo = String.format("%-15s%-15s%n", "Format:", getFormat());

		return sIsbn + sCN + sAv + sTo + sTi + sAu + sFo;
	}

	@Override
	public String toString() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
				+ getAuthors() + ";" + getFormat();
	}

}
