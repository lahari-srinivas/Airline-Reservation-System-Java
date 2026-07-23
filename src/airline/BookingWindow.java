package airline;

import javax.swing.*;
import java.awt.*;

public class BookingWindow extends JFrame {

    private Flight flight;

    public BookingWindow(Flight flight) {
        this.flight = flight;
        initUI();
    }

    private void initUI() {

        setTitle("Book Flight - " + flight.getFlightNo());
        setSize(360, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ----------- FLIGHT INFO PANEL -----------
        JPanel info = new JPanel(new GridLayout(5, 1));
        info.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        info.add(new JLabel("Flight: " + flight.getFlightNo()));
        info.add(new JLabel("Airline: " + flight.getAirline()));
        info.add(new JLabel("Date: " + flight.getDate()));
        info.add(new JLabel("Time: " + flight.getDeparture()));
        info.add(new JLabel("Route: " + flight.getDeparture() + " → " + flight.getArrival()));

        add(info, BorderLayout.NORTH);

        // ----------- USER INPUT FORM -----------
        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        form.add(new JLabel("Passenger Name:"));
        JTextField nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        form.add(emailField);

        form.add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        form.add(phoneField);

        add(form, BorderLayout.CENTER);

        // ----------- CONFIRM BUTTON -----------BLR
        JButton confirm = new JButton("Confirm Booking");
        confirm.addActionListener(e -> {

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            // ----------- VALIDATIONS -----------
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter passenger name.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this,
                        "Enter a valid email (example@gmail.com).",
                        "Invalid Email", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidPhone(phone)) {
                JOptionPane.showMessageDialog(this,
                        "Phone number must be EXACTLY 10 digits.",
                        "Invalid Phone", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ----------- SUCCESS MESSAGE -----------
            String msg = "🎉 Booking Confirmed!\n\n"
                    + "Passenger: " + name + "\n"
                    + "Flight: " + flight.getFlightNo() + "\n"
                    + "Airline: " + flight.getAirline() + "\n"
                    + "Route: " + flight.getDeparture() + " → " + flight.getArrival() + "\n"
                    + "Date: " + flight.getDate() + "\n"
                    + "Time: " + flight.getDeparture() + "\n\n"
                    + "Email: " + email + "\n"
                    + "Phone: " + phone + "\n";

            JOptionPane.showMessageDialog(this, msg, "Booking Successful",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();
        });

        JPanel south = new JPanel();
        south.add(confirm);
        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ----------- VALIDATION METHODS -----------

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}"); // exactly 10 digits
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }
}
