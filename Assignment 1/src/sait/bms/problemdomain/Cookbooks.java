
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
        String sIsbn = String.format("%-15s%-15s%n", "ISBN:", getIsbn());
        String sCN = String.format("%-15s%-15s%n", "Call Number:", getCallNumber());
        String sAv = String.format("%-15s%-15d%n", "Available:", getAvailable());
        String sTo = String.format("%-15s%-15d%n", "Total:", getTotal());
        String sTi = String.format("%-15s%-15s%n", "Title:", getTitle());
        String sPu = String.format("%-15s%-15s%n", "Authors:", getPublisher());
        String sDi = String.format("%-15s%-15s%n", "Format:", getDiet());

        return sIsbn + sCN + sAv + sTo + sTi + sPu + sDi;
    }

    @Override
    public String toString() {
        return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle() + ";"
                + getPublisher() + ";" + getDiet();
    }

}
