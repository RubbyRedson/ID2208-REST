package se.kth.webservice.third.data;

import se.kth.webservice.third.models.*;

import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public class DatabaseWrapper implements IRepository{

    private NeoDB neoDB;
    private FlightDatabase flightDatabase;

    public DatabaseWrapper(){
        neoDB = new NeoDB();
        flightDatabase = new FlightDatabase();
    }

    @Override
    public List<Airport> getAllAirports(int start, int from) {
        return flightDatabase.getAllAirports(start, from);
    }

    @Override
    public Airport getAirportById(int id) {
        return flightDatabase.getAirportById(id);
    }

    @Override
    public Airport insertAirport(Airport airport) {
        return flightDatabase.insertAirport(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return flightDatabase.updateAirport(airport);
    }

    @Override
    public String deleteAirport(int id) {
        return flightDatabase.deleteAirport(id);
    }

    @Override
    public TravelPath getItineraries(int from, int to) {
        List<TravelPath> paths = neoDB.getRoutes(from + "", to + "");
        return paths != null && paths.size() > 0 ? paths.get(0) : null;
    }

    @Override
    public List<Departure> getDepartures(int routeId) {
        return flightDatabase.getDeparturesFromRouteId(routeId);
    }

    @Override
    public Departure getDepartureById(int id) {
        return flightDatabase.getDepartureById(id);
    }

    @Override
    public int getBookingCount(int id) {
        return flightDatabase.getBookingCount(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return flightDatabase.saveBooking(booking);
    }

    @Override
    public void issueTicket(int bookingId) {
        flightDatabase.issueTicket(bookingId);
    }

    @Override
    public Booking getBookingById(int bookingId) {
        return flightDatabase.getBookingById(bookingId);
    }

    @Override
    public Route getRouteById(int routeId) {
        return flightDatabase.getRouteById(routeId);
    }

    @Override
    public Airline getAirlineById(int airlineId) {
        return flightDatabase.getAirlineById(airlineId);
    }
}
