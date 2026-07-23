package airline;

import javax.swing.*;
import java.awt.*;

public class BookingUI extends JFrame {

    private reservationsystem rs;
    private Flight selectedFlight;

    private JTextField passengerField;
    private JButton confirmBtn;

    public BookingUI(reservationsystem rs, Flight selectedFlight) {

        this.rs = rs;
        this.selectedFlight = selectedFlight;

        setTitle("Book Flight");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        panel.add(new JLabel("Flight: " + selectedFlight.getFlightNo()));
        panel.add(new JLabel("Date: " + selectedFlight.getDate()));
        panel.add(new JLabel("Time: " + selectedFlight.getArrival()));

        passengerField = new JTextField();
        panel.add(new JLabel("Enter Passenger Name:"));
        panel.add(passengerField);

        confirmBtn = new JButton("Confirm Booking");
        confirmBtn.addActionListener(e -> bookFlight());

        add(panel, BorderLayout.CENTER);
        add(confirmBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void bookFlight() {
        String passenger = passengerField.getText().trim();

        if (passenger.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter passenger name!");
            return;
        }

        rs.bookFlight(selectedFlight, passenger);

        JOptionPane.showMessageDialog(this,
                "Booking Successful!\n\n" +
                "Passenger: " + passenger + "\n" +
                "Flight: " + selectedFlight.getFlightNo() + "\n" +
                "Date: " + selectedFlight.getDate() + "\n" +
                "Time: " + selectedFlight.getDeparture()
        );

        dispose();
    }
}