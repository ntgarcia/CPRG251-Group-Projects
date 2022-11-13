package sait.frms.manager;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class ReservationManager extends Reservation {
    private static final String BINARY_FILE = "res/reserve.bin";
    private static final String TEXT_FILE = "res/reserve.txt";
    private static final String MODE = "rw";
    private static final int RESERVE_SIZE = 331;
    private ArrayList<Reservation> reservations;
    public ArrayList<Reservation> matchReservation;

    /**
     * Stores the singleton instance.
     */
    private static ReservationManager instance;

    /**
     * The instance of the Random Access File.
     */
    private RandomAccessFile raf;

    public ReservationManager() throws FileNotFoundException {
        super();
        this.raf = new RandomAccessFile(BINARY_FILE, MODE);
        
     // If length is 0, load from text file
//        if (this.raf.length() == 0) {
//            this.loadFromText(); // either populatefrombinary or from a text file
//        }
        
        reservations = new ArrayList<>();
        try {
            populateFromBinary();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param flight
     * @param name
     * @param citizenship
     * @return
     * @throws IOException 
     */
    public Reservation makeReservation(Flight flight, String name, String citizenship) throws IOException {
        //save reservation to Binary file and return value
        //use an if-statement to check for available seats and if name/citizenship is not null
        String resCode = generateReservationCode(flight);
        String flightCode = flight.getCode();
        String airline = flight.getAirlineName();
        String passName = name;
        String citi = citizenship;
        double cost = flight.getCostPerSeat();
        boolean active = true;
        
        //have to also deduct the available seat from the flight
        
        reservations.add(new Reservation(resCode, flightCode, airline, passName, citi, cost, active));
        System.out.println("The reservations in the list are " + reservations);
        return new Reservation(resCode, flightCode, airline, passName, citi, cost, active);
        
    }

    /**
     * 
     * @param code
     * @param airline
     * @param name
     * @return
     * @throws IOException 
     */
    public ArrayList<Reservation> findReservations(String code, String airline, String name) throws IOException {
        matchReservation = new ArrayList<>();
        System.out.println("This is from findReservation" + reservations.size());
        
        for (int i = 0; i<reservations.size(); i++) {
//            for (Reservation r : reservations) {
                if ((reservations.get(i).getCode().toUpperCase()).equals(code.toUpperCase()) || (reservations.get(i).getAirline().toUpperCase()).equals(airline.toUpperCase())
                        || (reservations.get(i).getName().toUpperCase()).equals(name.toUpperCase())) {
                    matchReservation.add(reservations.get(i));
//                }
            }
//            System.out.println(matchReservation + " findReservations method completed");
            
        }
        System.out.println("the matched reservation found is " + matchReservation);
        return matchReservation;
    }

    /**
     * Find reservation using the reservation code
     * 
     * @param code reservation code
     * @return found reservation object
     */
    public Reservation findReservationByCode(String code) {
        for (Reservation r : reservations) {
            if (r.getCode().equals(code)) {
                return r;
            }
        }
        return null;
    }

    public void persist() throws IOException { // save reservation arraylist into the bin file
        
        for (int i = 0; i < reservations.size(); i++) {
//            for (Reservation r : reservations) {
            raf = new RandomAccessFile(BINARY_FILE, MODE);
            
            String resCode = reservations.get(i).getCode();
            raf.writeUTF(resCode);
            
            String flightCode = reservations.get(i).getFlightCode();
            raf.writeUTF(flightCode);

            String airline = reservations.get(i).getAirline();
            raf.writeUTF(airline);

            String passName = reservations.get(i).getName();
            raf.writeUTF(passName);

            String citi = reservations.get(i).getCitizenship();
            raf.writeUTF(citi);
            
            double cost = reservations.get(i).getCost();
            raf.writeDouble(cost);
            
            boolean active = reservations.get(i).isActive();
            raf.writeBoolean(active);

        }
//      }
        System.out.println("Binary file has been overwritten");
        raf.close();
    }

    /**
     * 
     * @param flights
     * @return
     */
    private int getAvailableSeats(Flight flights) {
        return 0;

    }

    /**
     * Generates Reservation Code.
     * 
     * @param flight
     * @return
     */
    public String generateReservationCode(Flight flight) {
        // check if flight is international or domestic
        // get first letter of From and To

        int n = (flight.getFrom()).length();
        char firstFrom = (flight.getFrom()).charAt(0);
        char firstTo = (flight.getTo()).charAt(0);

        String resCodeA;

        if ((firstFrom == 'Y') && (firstTo == 'Y')) {
            resCodeA = "D";
        } else {
            resCodeA = "I";
        }

        // generate random number for flightcode
        int rng = (int)(Math.random() * (9999 - 1000 + 1) + 1000);

        // combine A and B to form code
        String resCode = resCodeA + rng;
//        System.out.println(resCode);

        return resCode;

    }

    private void populateFromBinary() throws IOException {
        raf = new RandomAccessFile(BINARY_FILE, "r");
        while(raf.getFilePointer() < raf.length()) {
            raf.seek(0); //tells the program to read from the start
            String resCode = raf.readUTF().trim();
            String flightCode = raf.readUTF().trim();
            String airline = raf.readUTF().trim();
            String passName = raf.readUTF().trim();
            String citi = raf.readUTF().trim();
            double cost = raf.readDouble();
            boolean active = raf.readBoolean();
            reservations.add(new Reservation(resCode, flightCode, airline, passName, citi, cost, active));
        }
        System.out.println("The reservations loaded from the binary file are " + reservations);
    }

}
