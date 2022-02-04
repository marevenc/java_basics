import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();
        Line line1 = new Line(1, "Nord");
        Line line2 = new Line(2, "Central");
        Line line3 = new Line(3, "South");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        Station station = new Station("1Nord", line1);
        line1.addStation(station);
        stationIndex.addStation(station);

        station = new Station("2Nord", line1);
        line1.addStation(station);
        stationIndex.addStation(station);

        station = new Station("3Nord", line1);
        line1.addStation(station);
        stationIndex.addStation(station);

        station = new Station("1Central", line2);
        line2.addStation(station);
        stationIndex.addStation(station);

        station = new Station("2Central", line2);
        line2.addStation(station);
        stationIndex.addStation(station);

        station = new Station("3Central", line2);
        line2.addStation(station);
        stationIndex.addStation(station);

        station = new Station("1South", line3);
        line3.addStation(station);
        stationIndex.addStation(station);

        station = new Station("2South", line3);
        line3.addStation(station);
        stationIndex.addStation(station);

        List<Station> connectionStations = new ArrayList<>();
        connectionStations.add(stationIndex.getStation("2Nord"));
        connectionStations.add(stationIndex.getStation("2Central"));
        stationIndex.addConnection(connectionStations);
        connectionStations = new ArrayList<>();
        connectionStations.add(stationIndex.getStation("3Nord"));
        connectionStations.add(stationIndex.getStation("2South"));
        stationIndex.addConnection(connectionStations);
    }

    public void testCalculateDurationNoConnections(){
        double expected = 5;
        Station from = stationIndex.getStation("1Central");
        Station to = stationIndex.getStation("3Central");
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(from, to);

        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);
    }

    public void testCalculateDurationOneConnections(){
        double expected = 8.5;
        Station from = stationIndex.getStation("3Central");
        Station to = stationIndex.getStation("1Nord");
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(from, to);

        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);
    }

    public void testCalculateDurationTwoConnections(){
        double expected = 14.5;
        Station from = stationIndex.getStation("1Central");
        Station to = stationIndex.getStation("1South");
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(from, to);

        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);
    }

}
