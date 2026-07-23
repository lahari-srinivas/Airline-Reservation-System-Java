package airline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIClient {

    public static List<Flight> fetchFlights(String from, String to) throws Exception {

        String apiKey = <your api key>; // <-- Add your API KEY here

        String apiUrl = "https://api.aviationstack.com/v1/flights?access_key="
                + apiKey + "&dep_iata=" + from + "&arr_iata=" + to + "&limit=10";

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();

        List<Flight> flights = new ArrayList<>();

        if (!json.has("data")) {
            return flights;
        }

        JsonArray data = json.getAsJsonArray("data");

        for (JsonElement element : data) {
            JsonObject obj = element.getAsJsonObject();

            // safe extraction with fallbacks
            String airlineName = safe(obj, "airline", "name");
            // flight number: try "number", then "iata"
            String flightNo = "N/A";
            if (obj.has("flight") && obj.get("flight").isJsonObject()) {
                JsonObject flightObj = obj.getAsJsonObject("flight");
                if (flightObj.has("number")) flightNo = flightObj.get("number").getAsString();
                else if (flightObj.has("iata")) flightNo = flightObj.get("iata").getAsString();
            }

            String departure = safe(obj, "departure", "scheduled");
            String arrival = safe(obj, "arrival", "scheduled");

            // IMPORTANT: use the 'from' and 'to' that were passed into the method
            flights.add(new Flight(flightNo, from, to, departure, arrival));
        }

        return flights;
    }

    // Helper method to avoid null errors
    private static String safe(JsonObject obj, String outer, String inner) {
        if (obj.has(outer)
            && obj.get(outer).isJsonObject()
            && obj.getAsJsonObject(outer).has(inner)
            && !obj.getAsJsonObject(outer).get(inner).isJsonNull()) {

            return obj.getAsJsonObject(outer).get(inner).getAsString();
        }
        return "N/A";
}
}
