import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        int numberOfAircrafts = airport.getAllAircrafts().size();
        System.out.println("Total number of aircrafts is: " + numberOfAircrafts);
    }
}
