package sait.frms.problemdomain;

public abstract class Flight {
    private String code;
    private String airlineName;
    private String from;
    private String to;
    private String weekday;
    private String time;
    private int seats;
    private double costPerSeat;

    public Flight() {
    }

    public Flight(String code, String airlineName, String from, String to, String weekday, String time, int seats,
            double costPerSeat) {
        this.code = code;
        this.airlineName = airlineName;
        this.from = from;
        this.to = to;
        this.weekday = weekday;
        this.time = time;
        this.seats = seats;
        this.costPerSeat = costPerSeat;
    }

    public String getCode() {
        return this.code;
    }

    public String getAirlineName() {
        return this.airlineName;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getWeekday() {
        return this.weekday;
    }

    public String getTime() {
        return this.time;
    }

    public int getSeats() {
        return this.seats;
    }

    public double getCostPerSeat() {
        return this.costPerSeat;
    }

    public boolean isDomestic() {
        return false;
    }

    private void parseCode(String code) {

    }

    public String toString() {
        return airlineName;
    }
}