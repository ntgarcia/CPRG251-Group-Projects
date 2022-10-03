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
//          return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() + "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
//          + "\r\n" + "Title: " + getTitle() + "\r\n" + "Authors: " + getAuthors() + "\r\n" + "Year: " + getYear() + "\r\n" + "Genre: " + getGenre() + "\r\n";
        return String.format("ISBN:%25s%nCall Number:%16s%nAvailable:%7d%nTotal:%20d%nTitle:%20s%nAuthors:%20s%nYear%20d%nGenre%20s%n", 
                getIsbn(), getCallNumber(),getAvailable(),getTotal(),getTitle(),getAuthors(),getYear(),getGenre());
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
