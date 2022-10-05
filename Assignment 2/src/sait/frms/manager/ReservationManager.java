package sait.frms.manager;

import java.util.ArrayList;

import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class ReservationManager {
    private ArrayList<Reservation> reservations;

    public ReservationManager() {
    }

    public Reservation makeReservation(Flight flight, String name, String citizenship) {
        return null;

    }

    public ArrayList<Reservation> findReservations(String code, String airline, String name) {
        return reservations;

    }

    public Reservation findReservationByCode(String code) {
        return null;

    }

    public void persist() {

    }

    private int getAvailableSeats(Flight flights) {
        return 0;

    }

    private String generateReservationCode(Flight flight) {
        return null;

    }

    private void populateFromBinary() {

    }
}
