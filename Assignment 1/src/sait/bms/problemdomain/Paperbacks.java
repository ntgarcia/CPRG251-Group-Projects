package sait.bms.problemdomain;

public class Paperbacks extends Book {

    private String authors;
    private int year;
    private String genre;

    public Paperbacks(String isbn, String callNumber, int available, int total, String title, String authors,
            int year, String genre) {
        super(isbn, callNumber, available, total, title);
        this.authors = authors;
        this.year = year;
        this.genre = genre;
    }

    public String printPaper() {
        String sIsbn = String.format("%-15s%-15s%n", "ISBN:", getIsbn());
        String sCN = String.format("%-15s%-15s%n", "Call Number:", getCallNumber());
        String sAv = String.format("%-15s%-15d%n", "Available:", getAvailable());
        String sTo = String.format("%-15s%-15d%n", "Total:", getTotal());
        String sTi = String.format("%-15s%-15s%n", "Title:", getTitle());
        String sYe = String.format("%-15s%-15d%n", "Authors:", getYear());
        String sGe = String.format("%-15s%-15s%n", "Format:", getGenre());

        return sIsbn + sCN + sAv + sTo + sTi + sYe + sGe;
    }

    @Override
    public String toString() {
        return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
                + getAuthors() + ";" + getYear() + ";" +
                getGenre();

    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
