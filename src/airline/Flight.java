package airline;

public class Flight {
    private String flightNo;
    private String airline;
    private String departure; // datetime or time string
    private String arrival;   // datetime or time string
    private String date;

    // Constructor used by AirlineSwing
    public Flight(String flightNo, String airline, String departure, String arrival, String date) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
    }

    // getters expected by AirlineSwing
    public String getFlightNo() { return flightNo; }
    public String getAirline()  { return airline; }
    public String getDeparture(){ return departure; }
    public String getArrival()  { return arrival; }
    public String getDate()     { return date; }

    // optional setters
    public void setFlightNo(String flightNo) { this.flightNo = flightNo; }
    public void setAirline(String airline)   { this.airline = airline; }
    public void setDeparture(String departure){ this.departure = departure; }
    public void setArrival(String arrival)   { this.arrival = arrival; }
    public void setDate(String date)         { this.date = date;}
}
