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

    @Override
    public String toString() {
//        return "Paperbacks [getAuthors()=" + getAuthors() + ", getYear()=" + getYear() + ", getGenre()=" + getGenre()
//                + ", getIsbn()=" + getIsbn() + ", getCallNumber()=" + getCallNumber() + ", getAvailable()="
//                + getAvailable() + ", getTotal()=" + getTotal() + ", getTitle()=" + getTitle() + ", getClass()="
//                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
          return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() + "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
          + "\r\n" + "Title: " + getTitle() + "\r\n" + "Authors: " + getAuthors() + "\r\n" + "Year: " + getYear() + "\r\n" + "Genre: " + getGenre();
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
