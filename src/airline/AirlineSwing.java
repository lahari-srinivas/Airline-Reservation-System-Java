package airline;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AirlineSwing extends JFrame {

    private JTextField fromField, toField;
    private JButton searchBtn, bookBtn;
    private JTable table;
    private DefaultTableModel model;

    public AirlineSwing() {
        setTitle("Airline Flight Search");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ---------------- TOP PANEL ----------------
        JPanel top = new JPanel(new GridLayout(3, 2, 10, 10));
        top.add(new JLabel("From (IATA):"));
        fromField = new JTextField();
        top.add(fromField);

        top.add(new JLabel("To (IATA):"));
        toField = new JTextField();
        top.add(toField);

        searchBtn = new JButton("Search Flights");
        top.add(searchBtn);

        add(top, BorderLayout.NORTH);

        // ---------------- TABLE ----------------
        String[] columns = {"Flight No", "Airline", "Departure", "Arrival", "Date"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---------------- BOOK BUTTON ----------------
        bookBtn = new JButton("BOOK SELECTED FLIGHT");
        add(bookBtn, BorderLayout.SOUTH);

        // Action Listeners
        searchBtn.addActionListener(e -> searchFlights());
        bookBtn.addActionListener(e -> bookSelectedFlight());

        setVisible(true);
    }

    private void searchFlights() {
        String from = fromField.getText().trim();
        String to = toField.getText().trim();

        if (from.isEmpty() || to.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both From and To");
            return;
        }

        try {
            List<Flight> flights = APIClient.fetchFlights(from, to);

            model.setRowCount(0); // clear old results

            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No flights found.");
                return;
            }

            for (Flight f : flights) {
                model.addRow(new Object[]{
                        f.getFlightNo(),
                        f.getAirline(),
                        f.getDeparture(),
                        f.getArrival(),
                        f.getDate()
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void bookSelectedFlight() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a flight first.");
            return;
        }

        // Get selected flight details
        String flightNo = model.getValueAt(row, 0).toString();
        String airline = model.getValueAt(row, 1).toString();
        String dep = model.getValueAt(row, 2).toString();
        String arr = model.getValueAt(row, 3).toString();
        String date = model.getValueAt(row, 4).toString();

        // Create flight object
        Flight selected = new Flight(flightNo, airline, dep, arr, date);

        // Open booking window
        new BookingWindow(selected);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AirlineSwing());
    }
}
