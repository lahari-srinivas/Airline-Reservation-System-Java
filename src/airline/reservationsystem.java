package airline;

import java.util.ArrayList;

public class reservationsystem {

    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<String> bookings = new ArrayList<>();

    public void addFlight(Flight f) {
        flights.add(f);
    }

    public ArrayList<Flight> searchFlights(String from, String to) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDeparture().equalsIgnoreCase(from) && f.getArrival().equalsIgnoreCase(to)) {
                results.add(f);
            }
        }
        return results;
    }

    // Method expected by BookingUI / AirlineSwing
    public void bookFlight(Flight f, String passengerName) {
        String record = "Passenger: " + passengerName + " booked flight " + f.getFlightNo()
                      + " on " + f.getDate() + " at " + f.getDeparture();
        bookings.add(record);
    }

    public ArrayList<String> getBookings() {
        return bookings;
    }
}
