
package sait.bms.problemdomain;

public class Cookbooks extends Book {

    private String publisher;
    private String diet;

    public Cookbooks(String isbn, String callNumber, int available, int total, String title, String publisher,
            String diet) {
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

    public String printCook() {
        // return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() +
        // "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
        // + "\r\n" + "Title: " + getTitle() + "\r\n" + "Publisher: " + getPublisher() +
        // "\r\n" + "Diet: " + getDiet() + "\r\n";
        return String.format(
                "ISBN:%25s%nCall Number:%16s%nAvailable:%7d%nTotal:%20d%nTitle:%20s%nPublisher:%20s%nDiet%20s%n",
                getIsbn(), getCallNumber(), getAvailable(), getTotal(), getTitle(), getPublisher(), getDiet());
    }

    @Override
    public String toString() {
        return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";" + getPublisher() + ";" + getDiet();
    }

}
