package sait.bms.problemdomain;

public class Periodicals extends Book {

    private String frequency;

    public Periodicals(String isbn, String callNumber, int available, int total, String title, String frequency) {
        super(isbn, callNumber, available, total, title);
        this.frequency = frequency;
    }

    @Override
    public String toString() {
//        return "Periodicals [getFrequency()=" + getFrequency() + ", getIsbn()=" + getIsbn() + ", getCallNumber()="
//                + getCallNumber() + ", getAvailable()=" + getAvailable() + ", getTotal()=" + getTotal()
//                + ", getTitle()=" + getTitle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
//                + ", toString()=" + super.toString() + "]";
          return "ISBN: " + getIsbn() + "\r\n" + "Call Number: " + getCallNumber() + "\r\n" + "Available: " + getAvailable() + "\r\n" + "Total: " + getTotal()
                  + "\r\n" + "Title: " + getTitle() + "\r\n" + "Frequency: " + getFrequency(); 
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
