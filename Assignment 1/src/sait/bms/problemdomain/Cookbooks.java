
package sait.bms.problemdomain;

public class Cookbooks extends Book {

    private String publisher;
    private String diet;

    public Cookbooks(String isbn, String callNumber, int available, int total, String title, String publisher, String diet) {
        super(isbn, callNumber, available, total, title);
        this.publisher = publisher;
        this.diet = diet;

    }

    
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }
    @Override
    public String toString() {
        return "Cookbooks [getPublisher()=" + getPublisher() + ", getDiet()=" + getDiet() + ", getIsbn()=" + getIsbn()
                + ", getCallNumber()=" + getCallNumber() + ", getAvailable()=" + getAvailable() + ", getTotal()="
                + getTotal() + ", getTitle()=" + getTitle() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
