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
    public ArrayList<Flight> resultFlights;
    private ArrayList<String> airports;
    
    public FlightManager() {
        super();
        flights = new ArrayList<>();
        airports = new ArrayList<>();
        populateFlights();
        populateAirports();
    }

    /**
     * 
     * @return gets airport information
     * @throws FileNotFoundException if the file doesn't exist, throws Exception
     */

    public ArrayList<String> getAirport() throws FileNotFoundException {
        return airports;
    }
    
    /**
     * 
     * @return gets Flight information
     * @throws FileNotFoundException if the file doesn't exist, throws Exception
     */
    
    public ArrayList<Flight> getFlights() throws FileNotFoundException {
        return flights;
    }

    /**
     * 
     * @param code
     * @return
     */
    public String findAirportByCode(String code) {
        for(int i=0; i< airports.size(); i++) {
            if(airports.get(i) == (code)) {
                return airports.get(i+1);
            }
        }
        return code;
    }

    /**
     * 
     * @param code
     * @return
     */
    public Flight findFlightByCode(String code) {
        for(int i =0; i<flights.size(); i++) {
            Flight flight =flights.get(i);
            if (flight.getCode().equals(code)) {
                return flight;
            }
        }
        throw new RuntimeException("The code is invalid!");
    }

    /**
     * 
     * @param from
     * @param to
     * @param weekday
     * @return
     */
    public ArrayList<Flight> findFlights(String from, String to, String weekday) {
        resultFlights = new ArrayList<>();
        
        for(int i =0; i<flights.size(); i++) {
            Flight flight =flights.get(i);
            if(weekday.equals("Any")) {
                if (flight.getFrom().equals(from) && flight.getTo().equals(to)) {
                    resultFlights.add(flight);
                }
            } else {
            if(flight.getFrom().equals(from) && flight.getTo().equals(to) && flight.getWeekday().equals(weekday)) {
                resultFlights.add(flight);
            }
            }
        }
        return resultFlights;
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
        try(Scanner in = new Scanner(new File("res/airports.csv"))) {
            while (in.hasNext()) {
                String[] Afield = in.nextLine().split(",");
                String code = Afield[0];
                airports.add(code);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
