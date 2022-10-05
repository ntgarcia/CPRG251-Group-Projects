package sait.frms.manager;

import java.util.ArrayList;
import sait.frms.problemdomain.Flight;

public class FlightManager {
    public String WEEKDAY_ANY;
    public String WEEKDAY_SUNDAY;
    public String WEEKDAY_MONDAY;
    public String WEEKDAY_TUESDAY;
    public String WEEKDAY_WEDNESDAY;
    public String WEEKDAY_THURSDAY;
    public String WEEKDAY_FRIDAY;
    public String WEEKDAY_SATURDAY;

    private ArrayList<Flight> flights;
    private ArrayList<String> airports;

    public FlightManager() {
    }

    /**
     * 
     * @return
     */
    public ArrayList<String> getAirports() {
        return airports;

    }

    /**
     * 
     * @return
     */
    public ArrayList<Flight> getFlights() {
        return flights;

    }

    /**
     * 
     * @param code
     * @return
     */
    public String findAirportByCode(String code) {
        return code;

    }

    /**
     * 
     * @param code
     * @return
     */
    public Flight findFlightByCode(String code) {
        return null;

    }

    /**
     * 
     * @param from
     * @param to
     * @param weekday
     * @return
     */
    public ArrayList<Flight> findFlights(String from, String to, String weekday) {
        return flights;

    }

    private void populateFlights() {

    }

    private void populateAirports() {

    }

}
