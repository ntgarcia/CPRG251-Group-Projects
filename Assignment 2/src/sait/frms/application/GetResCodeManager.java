package sait.frms.application;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class GetResCodeManager {
    public static void main(String[] args) {
        generateReservationCode(
                new Flight("SL-4367","Scare Airlines","YYC","YEG","Thursday","21:30",50,270.00));
    }

    public static String generateReservationCode(Flight flight) {
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
        int resCodeB = (int) Math.round(rng);
        // combine A and B to form code
        String resCode = resCodeA + resCodeB;

        System.out.println(resCode);
        return resCode;

    }
}
