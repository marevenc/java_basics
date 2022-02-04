package main.java;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> allFlights = new ArrayList<>();
        long currentMSeconds = new Date().getTime();
        Date currentTime = new Date(currentMSeconds);
        long allowedDepartureMSeconds = currentMSeconds + 7200000;
        Date allowedDepartureTime = new Date(allowedDepartureMSeconds);

        for(Terminal terminal : airport.getTerminals()){
            allFlights.addAll(terminal.getFlights());
        }
        return allFlights.stream()
                .filter(flight -> flight.getType().equals(DEPARTURE))
                .filter(flight -> flight.getDate().before(allowedDepartureTime))
                .filter(flight -> flight.getDate().after(currentTime))
                .collect(Collectors.toList());
    }

}