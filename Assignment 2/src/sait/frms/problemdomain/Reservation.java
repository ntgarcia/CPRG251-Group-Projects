package sait.frms.problemdomain;

// import java.math.RoundingMode;
// import java.text.DecimalFormat;

public class Reservation {
    private String code;
    private String flightCode;
    private String airline;
    private String name;
    private String citizenship;
    private double cost;
    private boolean active;
    // private static final DecimalFormat df = new DecimalFormat("0.00");

    public Reservation() {
    }

    /**
     * 
     * @param code
     * @param flightCode
     * @param airline
     * @param name
     * @param citizenship
     * @param cost
     * @param active
     */
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

    /**
     * 
     * @return
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 
     * @return
     */

    public String getFlightCode() {
        return this.flightCode;
    }

    /**
     * 
     * @return
     */

    public String getAirline() {
        return this.airline;
    }

    /**
     * 
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return
     */

    public String getCitizenship() {
        return this.citizenship;
    }

    /**
     * 
     * @return
     */

    public double getCost() {
        return this.cost;
    }

    /**
     * 
     * @return
     */

    public boolean isActive() {
        return this.active;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param citizenship
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return getCode() + "," + getFlightCode() + "," + getAirline() + ",$"
                + getCost() + "," + getName() + "," + getCitizenship();
    }

}
