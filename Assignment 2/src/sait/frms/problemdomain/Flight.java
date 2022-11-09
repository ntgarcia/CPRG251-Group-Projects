package sait.frms.problemdomain;

public class Flight {
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

    /**
     * 
     * @param code
     * @param airlineName
     * @param from
     * @param to
     * @param weekday
     * @param time
     * @param seats
     * @param costPerSeat
     */
    public Flight(String code, String airlineName, String from, String to, String weekday, String time, int seats, double costPerSeat) {
        this.code = code;
        this.airlineName = airlineName;
        this.from = from;
        this.to = to;
        this.weekday = weekday;
        this.time = time;
        this.seats = seats;
        this.costPerSeat = costPerSeat;
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
    public String getAirlineName() {
        return this.airlineName;
    }

    /**
     * 
     * @return
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * 
     * @return
     */
    public String getTo() {
        return this.to;
    }

    /**
     * 
     * @return
     */

    public String getWeekday() {
        return this.weekday;
    }

    /**
     * 
     * @return
     */

    public String getTime() {
        return this.time;
    }

    /**
     * 
     * @return
     */

    public int getSeats() {
        return this.seats;
    }

    /**
     * 
     * @return
     */

    public double getCostPerSeat() {
        return this.costPerSeat;
    }

    /**
     * 
     * @return
     */

    public boolean isDomestic() {
        if (getTo().substring(0,1) == "Y" && getFrom().substring(0,1) == "Y") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param code
     */
    private void parseCode(String code) {
        if (code.substring(0, 1).equals("OA")) {
            this.airlineName = "Otto Airlines";
        }



       else if (code.substring(0, 1).equals("CA")) {
            this.airlineName = "Conned Air";
        }



       else if (code.substring(0, 1).equals("TB")) {
            this.airlineName = "Try a Bus Airways";
        }



       else if (code.substring(0, 1).equals("VW")) {
            this.airlineName = "Vertical Airways";
        }
    }

    @Override
    public String toString() {
        return getCode() + ", From: " + getFrom()
                + ", To: " + getTo() + ", Day: " + getWeekday() + ", Time: " + getTime() + ", Cost: " + getCostPerSeat();
    }

    
    
    
    

//    public String toString() {
//        return getAirlineName();
//    }
    
      
}