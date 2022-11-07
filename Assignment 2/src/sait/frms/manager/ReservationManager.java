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
    private static final int RESERVE_SIZE = 0; // 6 + 102 + 102 + 102 + 102 + 8 + 1
    private ArrayList<Reservation> reservations;

    /**
     * Stores the singleton instance.
     */
    private static ReservationManager instance;

    /**
     * The instance of the Random Access File.
     */
    private RandomAccessFile raf;

    public ReservationManager() {
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
     */
    public Reservation makeReservation(Flight flight, String name, String citizenship) {
        return null;

    }

    /**
     * 
     * @param code
     * @param airline
     * @param name
     * @return
     */
    public ArrayList<Reservation> findReservations(String code, String airline, String name) {
        return reservations;

    }

    /**
     * 
     * @param code
     * @return
     */
    public Reservation findReservationByCode(String code) {
        return null;

    }

    public void persist() { // save reservation arraylist into the bin file

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
        double rng = Math.random() * (9999 - 1000 + 1) + 1000;

        // combine A and B to form code
        String resCode = resCodeA + rng;

        return null;

    }

    private void populateFromBinary() throws IOException {
    }
}
