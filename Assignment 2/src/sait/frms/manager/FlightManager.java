package sait.frms.manager;

import java.util.ArrayList;
import java.util.Scanner;
import sait.frms.problemdomain.Flight; //import the Flight class because these two classes are from different packages
import java.io.*;

public class FlightManager extends Flight { //extends Flight added by PK
    public String WEEKDAY_ANY;
    public String WEEKDAY_SUNDAY;
    public String WEEKDAY_MONDAY;
    public String WEEKDAY_TUESDAY;
    public String WEEKDAY_WEDNESDAY;
    public String WEEKDAY_THURSDAY;
    public String WEEKDAY_FRIDAY;
    public String WEEKDAY_SATURDAY;

    public ArrayList<Flight> flights;
    private ArrayList<String> airports;
    
    public FlightManager() {
        flights = new ArrayList<>();
        populateFlights();
        
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
    
    //populate the arraylist of flights with this method
    private void populateFlights() {
        try(Scanner in = new Scanner(new File("res/flights.csv"))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] fields = line.split(",");
                flights.add(new Flight(fields[0], fields[1],fields[2], fields[3], fields[4], fields[5], Integer.parseInt(fields[6]), Double.parseDouble(fields[7])));
            }
        
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void populateAirports() {

    }

}
