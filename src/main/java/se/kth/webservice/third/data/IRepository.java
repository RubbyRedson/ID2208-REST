package se.kth.webservice.third.data;

import se.kth.webservice.third.models.*;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public interface IRepository {
    List<Airport> getAllAirports(int start, int size);
    Airport getAirportById(int id);
    Airport insertAirport(Airport airport);
    Airport updateAirport(Airport airport);
    String deleteAirport(int id);
    TravelPath getItineraries(int from, int to);
    List<Departure>  getDepartures(int routeId);
    Departure getDepartureById(int id);
    int getBookingCount(int id);
    Booking saveBooking(Booking booking);

    void issueTicket(int bookingId);

    Booking getBookingById(int bookingId);

    Route getRouteById(int routeId);

    Airline getAirlineById(int airlineId);
}
