package sait.frms.gui;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase {
    /**
     * Instance of flight manager.
     */
    private FlightManager flightManager;

    /**
     * Instance of reservation manager.
     */
    private ReservationManager reservationManager;

    /**
     * List of flights.
     */
    private JList<Flight> flightsList;

    private DefaultListModel<Flight> flightsModel;

    /*
     * PK - instance of flight
     * 
     */
    private Flight flight;

    /*
     * PK - instance of flight
     * 
     */

    /*
     * PK PK - Instantiate a GridBagConstraint object for the GridBagLayout object
     * to call
     */
    GridBagConstraints gbc = new GridBagConstraints();

    /*
     * Instantiate the combo-boxes at the global-level to be used in the
     * event-listener method
     */
    JComboBox<String> cb1;
    JComboBox<String> cb2;
    JComboBox<String> cb3;

    /*
     * Instantiate JTextField used in the east panel
     * 
     */
    JTextField field1;
    JTextField field2;
    JTextField field3;
    JTextField field4;
    JTextField field5;
    JTextField field6;
    JTextField field7;

    /**
     * Creates the components for flights tab.
     * 
     * @param flightManager      Instance of FlightManager.
     * @param reservationManager Instance of ReservationManager
     * @throws FileNotFoundException
     */
    public FlightsTab(FlightManager flightManager, ReservationManager reservationManager) {
        this.flightManager = flightManager;
        this.reservationManager = reservationManager;

        panel.setLayout(new BorderLayout(10, 20));

        JPanel northPanel = createNorthPanel();
        panel.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = createCenterPanel();
        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel eastPanel = createEastPanel();
        panel.add(eastPanel, BorderLayout.EAST);

        JPanel westPanel = createWestPanel();
        panel.add(westPanel, BorderLayout.WEST);

        JPanel southPanel = createSouthPanel();
        panel.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates the north panel.
     * 
     * @return JPanel that goes in north.
     */
    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();

        JLabel title = new JLabel("Flights", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 29));
        panel.add(title);
        return panel;
    }

    /*
     * Creates the west panel.
     * 
     */
    private JPanel createWestPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    /**
     * Creates the center panel.
     * 
     * @return JPanel that goes in center.
     * @throws FileNotFoundException
     */
    private JPanel createCenterPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        flightsModel = new DefaultListModel<>();

        flightsList = new JList<>(flightsModel);

        // PK - Set model for the FlightsList
        flightsList.setModel(flightsModel);
        // PK - Set model for the FlightsList

        // User can only select one item at a time.
        flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Wrap JList in JScrollPane so it is scrollable.
        JScrollPane scrollPane = new JScrollPane(this.flightsList);

        /*
         * selectionlistener that listens to the selection of flight from the centre
         * panel and populate the jtext
         * 
         * fields in the east panel
         */

        flightsList.addListSelectionListener(new MyListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                    if (flightsList.isSelectionEmpty()) {
                        
                        field1.setText("");
                        field2.setText("");
                        field3.setText("");
                        field4.setText("");
                        field5.setText("");
                        
                    } else {
                    
                    String selectedItem = String.valueOf(flightsList.getSelectedValue());
                    String[] splitItem = selectedItem.split(",");
    
                    field1.setText(splitItem[0]);
    
                    switch (splitItem[0].substring(0, 2)) {
                        case "OA":
                            field2.setText("Otto Airlines");
                            break;
                        case "CA":
                            field2.setText("Conned Air");
                            break;
                        case "TB":
                            field2.setText("Try a Bus Airways");
                            break;
                        case "VA":
                            field2.setText("Vertical Airways");
                            break;
                        case "SL":
                            field2.setText("Scare Airlines");
                            break;
                        case "AL":
                            field2.setText("Always Late Airlines");
                            break;
                        case "MA":
                            field2.setText("Mediocre Airlines");
                            break;
                        case "GA":
                            field2.setText("Gypped Air");
                            break;
                        case "EC":
                            field2.setText("Error Canada");
                            break;
                        case "AS":
                            field2.setText("AirShaker");
                            break;
                        case "ST":
                            field2.setText("ScareTransat");
                            break;
                        case "SW":
                            field2.setText("Sprawl Airways");
                            break;
    
                    }
    
                    field3.setText(splitItem[3].substring(6, splitItem[3].length()));
                    field4.setText(splitItem[4].substring(7, splitItem[4].length()));
                    field5.setText(splitItem[5].substring(7, splitItem[5].length()));
                    }
            }
        });

        panel.add(scrollPane);

        return panel;
    }

    /**
     * Creates the right panel.
     * 
     * @return JPanel that goes to the right.
     */
    private JPanel createEastPanel() {

        JPanel panel = new JPanel(); // Panel for the EastPanel

        /*
         * Use GridBagLayout to divide the EastPanel
         * into north, centre, south
         */
        panel.setLayout(new GridBagLayout());

        // EastPanelNorth
        JLabel titleEastPanelNorth = new JLabel("Reserve");
        gbc.gridx = 1;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        titleEastPanelNorth.setFont(new Font("Verdana", Font.PLAIN, 25));

        // add padding
        Border borderLabel = titleEastPanelNorth.getBorder();
        Border marginLabel = new EmptyBorder(0, 0, 20, 0);
        titleEastPanelNorth.setBorder(new CompoundBorder(borderLabel, marginLabel));

        panel.add(titleEastPanelNorth, gbc);

        // EastPanelCentre

        // Flight label
        JLabel labelFLight = new JLabel("Flight:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelFLight, gbc);

        // Flight message field
        field1 = new JTextField(20);
        field1.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(field1, gbc);

        // Airline label
        JLabel labelAirline = new JLabel("Airline:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelAirline, gbc);

        // Airline message field
        field2 = new JTextField(20);
        field2.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(field2, gbc);

        // Day label
        JLabel labelDay = new JLabel("Day:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelDay, gbc);

        // Day message field
        field3 = new JTextField(20);
        field3.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(field3, gbc);

        // Time label
        JLabel labelTime = new JLabel("Time:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(labelTime, gbc);

        // Time message field
        field4 = new JTextField(20);
        field4.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(field4, gbc);

        // Cost label
        JLabel labelCost = new JLabel("Cost:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(labelCost, gbc);

        // Cost message field
        field5 = new JTextField(20);
        field5.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(field5, gbc);

        // Name label
        JLabel labelName = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(labelName, gbc);

        // Name message field
        field6 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(field6, gbc);

        // Citizenship label
        JLabel labelCitiz = new JLabel("Citizenship:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(labelCitiz, gbc);

        // Citizenship message field
        field7 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(field7, gbc);

        // EastPanelSouth
        JButton eastPanelSouthButton = new JButton("Reserve");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // PK - add actionlisterner to JButton
        eastPanelSouthButton.addActionListener(new reserveButtonListener());
        // PK - add actionlisterner to JButton

        panel.add(eastPanelSouthButton, gbc);

        return panel;
    }

    /*
     * SouthPanel
     */

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        // SouthPanelNorth
        JLabel titleEastPanelSouth = new JLabel("Flight Finder");
        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        titleEastPanelSouth.setFont(new Font("Verdana", Font.PLAIN, 25));
        panel.add(titleEastPanelSouth, gbc);

        // SouthPanelCentre Label + Combo-Box

        // From label
        JLabel labelFrom = new JLabel("From:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelFrom, gbc);

        // Content for combo-box1
        String[] cb1Content = { "YYC", "YEG", "YUL", "YOW", "YYZ", "YVR", "YWG", "ATL", "PEK", "DXB", "HKG", "LHR",
                "HND", "ORD", "PVG", "CDG", "AMS", "DEL", "FRA", "DFW" };

        // Combo-box1
        cb1 = new JComboBox<>(cb1Content);
        cb1.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cb1, gbc);

        // To label
        JLabel labelTo = new JLabel("To:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelTo, gbc);

        // Content for combo-box2
        String[] cb2Content = { "YYC", "YEG", "YUL", "YOW", "YYZ", "YVR", "YWG", "ATL", "PEK", "DXB", "HKG", "LHR",
                "HND", "ORD", "PVG", "CDG", "AMS", "DEL", "FRA", "DFW" };

        // Combo-box2
        cb2 = new JComboBox<>(cb2Content);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cb2, gbc);

        // Day label
        JLabel labelDay = new JLabel("Day:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelDay, gbc);

        // Content for combo-box3
        String[] cb3Content = { "Any", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        // Combo-box3
        cb3 = new JComboBox<>(cb3Content);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cb3, gbc);

        // SouthPanelSouth
        JButton southPanelSouthButton = new JButton("Find Flights");

        // PK - add actionlisterner to JButton
        southPanelSouthButton.addActionListener(new FindFlightButtonListener());
        // PK - add actionlisterner to JButton
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(southPanelSouthButton, gbc);

        return panel;
    }

    /*
     * Action to perform for the Find Flight JButton
     */
    private class FindFlightButtonListener implements ActionListener {
        /**
         * The actionPerformed method executes when the user clicks on the "Find
         * Flights"
         * button.
         * 
         * @param e The event object.
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            flightsModel.clear();
            String from = (String) cb1.getSelectedItem();
            String to = (String) cb2.getSelectedItem();
            String weekday = (String) cb3.getSelectedItem();
            flightManager.findFlights(from, to, weekday);
            // PK - add flight arraylist from Flight class to flightsModel variable
            for (int i = 0; i < flightManager.resultFlights.size(); i++) {

                flightsModel.addElement(flightManager.resultFlights.get(i));

            }

        }

    }

    /*
     * Action to perform for the Find Flight JButton
     */
    private class reserveButtonListener implements ActionListener {
        /**
         * The actionPerformed method executes when the user clicks on the "Reserve"
         * button.
         * 
         * @param e The event object.
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            // throw exception if flight is fully booked or flight is null or the
            // name/citizenship is null.

            try {
                if (field6.getText().length() < 1 || field7.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null,"Name or Citizenship cannot be empty");
                } else if (field1.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null,"Please select a flight from the panel first");
                } else {
                    reservationManager.makeReservation(flightsList.getSelectedValue(), field6.getText(), field7.getText());
                    JOptionPane.showMessageDialog(null,"Your reservation code is " + reservationManager.reservations.get((reservationManager.reservations.size()-1)).getCode());
                    reservationManager.persist();
                }
//                JOptionPane.showMessageDialog(null,
//                        "Reservation created. Your code is " + reservationManager.reservations)

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }

    }
    /*
     * Action to perform for the Find Flight JButton
     */

    private class MyListSelectionListener implements ListSelectionListener {
        /**
         * Called when user selects an item in the JList.
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {

        }

    }
}