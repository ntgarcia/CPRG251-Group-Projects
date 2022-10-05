package sait.frms.problemdomain;

public abstract class Reservation {
    private String code;
    private String flightCode;
    private String airline;
    private String name;
    private String citizenship;
    private double cost;
    private boolean active;

    public Reservation() {
    }

    public Reservation(String code, String flightCode, String airline, String name, String citizenship, double cost,
            boolean active) {
        this.code = code;
        this.flightCode = flightCode;
        this.airline = airline;
        this.name = name;
        this.citizenship = citizenship;
        this.cost = cost;
        this.active = active;
    }

    public String getCode() {
        return this.code;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public String getAirline() {
        return this.airline;
    }

    public String getName() {
        return this.name;
    }

    public String getCitizenship() {
        return this.citizenship;
    }

    public double getCost() {
        return this.cost;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {

    }

}
