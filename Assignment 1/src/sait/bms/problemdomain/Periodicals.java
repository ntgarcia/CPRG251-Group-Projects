package sait.bms.problemdomain;

public class Periodicals extends Book {

    private static String frequency;

    public Periodicals(String isbn, String callNumber, int available, int total, String title, String frequency) {
        super(isbn, callNumber, available, total, title);
        Periodicals.frequency = frequency;
    }

    @Override
    public String toString() {
//      return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() + "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
//              + "\r\n" + "Title: " + getTitle() + "\r\n" + "Frequency: " + getFrequency() + "\r\n"; 
        return String.format("ISBN:%25s%nCall Number:%16s%nAvailable:%7d%nTotal:%20d%nTitle:%20s%nFrequency:%20s%n", 
                getIsbn(), getCallNumber(),getAvailable(),getTotal(),getTitle(),getFrequency());
    }

    public static String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        Periodicals.frequency = frequency;
    }
}
