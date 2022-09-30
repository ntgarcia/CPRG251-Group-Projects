package sait.bms.problemdomain;

public class Periodicals extends Book {

    private String frequency;

    public Periodicals(String isbn, String callNumber, String available, String total, String title, String frequency) {

    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
