package sait.frms.gui;

import java.awt.*;
import javax.swing.*;
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
     * PK PK - Instantiate a GridBagConstraint object for the GridBagLayout object
     * to call
     */
    GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Creates the components for flights tab.
     * 
     * @param flightManager      Instance of FlightManager.
     * @param reservationManager Instance of ReservationManager
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
     */
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        flightsModel = new DefaultListModel<>();
        flightsList = new JList<>(flightsModel);

        // User can only select one item at a time.
        flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Wrap JList in JScrollPane so it is scrollable.
        JScrollPane scrollPane = new JScrollPane(this.flightsList);

        flightsList.addListSelectionListener(new MyListSelectionListener());

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
        panel.add(titleEastPanelNorth, gbc);

// EastPanelCentre

        // Flight label
        JLabel labelFLight = new JLabel("Flight:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelFLight, gbc);

        // Flight message field
        JTextField field1 = new JTextField(20);
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
        JTextField field2 = new JTextField(20);
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
        JTextField field3 = new JTextField(20);
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
        JTextField field4 = new JTextField(20);
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
        JTextField field5 = new JTextField(20);
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
        JTextField field6 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(field6, gbc);

        // Citizenship label
        JLabel labelCitiz = new JLabel("Citizenship:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(labelCitiz, gbc);

        // Citizenship message field
        JTextField field7 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(field7, gbc);

// EastPanelSouth
        JButton eastPanelSouthButton = new JButton("Reserve");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        String[] cb1Content = { "YYC", "Destination2" };

        // Combo-box1
        JComboBox cb1 = new JComboBox(cb1Content);
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
        String[] cb2Content = { "YYC", "Destination2" };

        // Combo-box2
        JComboBox cb2 = new JComboBox(cb2Content);
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
        String[] cb3Content = { "Any", "Date" };

        // Combo-box3
        JComboBox cb3 = new JComboBox(cb3Content);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cb3, gbc);

// SouthPanelSouth
        JButton southPanelSouthButton = new JButton("Find Flights");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(southPanelSouthButton, gbc);

        return panel;
    }

    private class MyListSelectionListener implements ListSelectionListener {
        /**
         * Called when user selects an item in the JList.
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {

        }

    }
}