package sait.bms.problemdomain;

public class Paperbacks extends Book {

    private String authors;
    private String year;
    private String genre;

    public Paperbacks(String isbn, String callNumber, String available, String total, String title, String authors,
            String year, String genre) {

    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
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

}
