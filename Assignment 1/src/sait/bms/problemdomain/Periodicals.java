package sait.bms.problemdomain;

public class Periodicals extends Book {

    private String frequency;

    public Periodicals(String isbn, String callNumber, int available, int total, String title, String frequency) {
        super(isbn, callNumber, available, total, title);
        this.frequency = frequency;
    }

    public String printPeriod() {
        String sIsbn = String.format("%-15s%-15s%n", "ISBN:", getIsbn());
        String sCN = String.format("%-15s%-15s%n", "Call Number:", getCallNumber());
        String sAv = String.format("%-15s%-15d%n", "Available:", getAvailable());
        String sTo = String.format("%-15s%-15d%n", "Total:", getTotal());
        String sTi = String.format("%-15s%-15s%n", "Title:", getTitle());
        String sFe = String.format("%-15s%-15d%n", "Authors:", getFrequency());

        return sIsbn + sCN + sAv + sTo + sTi + sFe;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%d;%s;%s",
                getIsbn(), getCallNumber(), getAvailable(), getTotal(), getTitle(), getFrequency());

    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
