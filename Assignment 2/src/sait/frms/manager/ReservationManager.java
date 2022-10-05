package sait.frms.manager;

import java.util.ArrayList;

import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class ReservationManager {
    private ArrayList<Reservation> reservations;

    public ReservationManager() {
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

    public void persist() {

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
     * 
     * @param flight
     * @return
     */
    private String generateReservationCode(Flight flight) {
        return null;

    }

    private void populateFromBinary() {

    }
}
