package se.kth.webservice.third.data;

import se.kth.webservice.third.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 2/11/2017.
 */
public class TestRepo implements IRepository {
    @Override
    public List<Airport> getAllAirports(int start, int size) {
        Airport a1 = new Airport();
        a1.setId(1);
        a1.setName("Arlanda");
        a1.setCountry("Swe");
        a1.setAltitudeFeet(560);
        a1.setIcao("whatever");
        a1.setIata("wherever");
        a1.setCity("Stockholm");
        a1.setDst("Dst");
        a1.setLat(1);
        a1.setLng(1);

        Airport a2 = new Airport();
        a2.setId(2);
        a2.setName("Arlanda2");
        a2.setCountry("Swe2");
        a2.setAltitudeFeet(5601);
        a2.setIcao("whatever2");
        a2.setIata("wherever2");
        a2.setCity("Stockholm2");
        a2.setDst("Dst2");
        a2.setLat(2);
        a2.setLng(2);

        List<Airport> res = new ArrayList<>();
        res.add(a1);
        res.add(a2);
        return res;
    }

    @Override
    public Airport getAirportById(int id) {
        if (id == 1) {
            Airport a1 = new Airport();
            a1.setId(1);
            a1.setName("Arlanda");
            a1.setCountry("Swe");
            a1.setAltitudeFeet(560);
            a1.setIcao("whatever");
            a1.setIata("wherever");
            a1.setCity("Stockholm");
            a1.setDst("Dst");
            a1.setLat(1);
            a1.setLng(1);
            return a1;
        } else if (id == 2) {
            Airport a2 = new Airport();
            a2.setId(2);
            a2.setName("Arlanda2");
            a2.setCountry("Swe2");
            a2.setAltitudeFeet(5601);
            a2.setIcao("whatever2");
            a2.setIata("wherever2");
            a2.setCity("Stockholm2");
            a2.setDst("Dst2");
            a2.setLat(2);
            a2.setLng(2);
            return a2;
        }
        Airport a1 = new Airport();
        a1.setId(id);
        a1.setName("Arlanda");
        a1.setCountry("Swe");
        a1.setAltitudeFeet(560);
        a1.setIcao("whatever");
        a1.setIata("wherever");
        a1.setCity("Stockholm");
        a1.setDst("Dst");
        a1.setLat(1);
        a1.setLng(1);
        return a1;
    }

    @Override
    public Airport insertAirport(Airport airport) {
        return airport;
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return airport;
    }

    @Override
    public String deleteAirport(int id) {
        return "Success";
    }

    @Override
    public TravelPath getItineraries(int from, int to) {
        TravelPath path = new TravelPath();
        path.setFrom("ARL");
        path.setTo("SVO");
        path.setNext(null);
        path.setLabel("Path label");
        path.setRouteId("Route id");
        return path;
    }

    @Override
    public List<Departure> getDepartures(int routeId) {
        Departure departure1 = new Departure();
        departure1.setId(1);
        departure1.setRouteId(routeId);
        departure1.setLifts("lift me up");
        departure1.setLands("land me down");

        Departure departure2 = new Departure();
        departure2.setId(2);
        departure2.setRouteId(routeId);
        departure2.setLifts("lift me up");
        departure2.setLands("land me down");

        List<Departure> departures = new ArrayList<>();
        departures.add(departure1);
        departures.add(departure2);
        return departures;
    }

    @Override
    public Departure getDepartureById(int id) {
        Departure departure1 = new Departure();
        departure1.setId(id);
        departure1.setRouteId(1);
        departure1.setLifts("lift me up");
        departure1.setLands("land me down");
        return departure1;
    }

    @Override
    public int getBookingCount(int id) {
        return 2;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return booking;
    }

    @Override
    public void issueTicket(int bookingId) {

    }

    @Override
    public Booking getBookingById(int bookingId) {
        Booking booking = new Booking();
        booking.setId(bookingId);
        booking.setCardNumber("00000000000000");
        booking.setDepartureId(1);
        booking.setIssued(false);
        return booking;
    }

    @Override
    public Route getRouteById(int routeId) {
        Route route = new Route();
        route.setId(routeId);
        route.setAirline("airline1");
        route.setAirlineId(1);
        route.setCodeshare("codeshare");
        route.setDestinationAirport("ARL");
        route.setDestinationAirportId(1);
        route.setEquipment("big one");
        route.setSourceAirport("SVO");
        route.setSourceAirportId(2);
        route.setStops(0);
        return route;
    }

    @Override
    public Airline getAirlineById(int airlineId) {
        Airline airline = new Airline();
        airline.setId(1);
        airline.setAlias("Alias");
        airline.setActive("nocturnally");
        airline.setCallsign("call me maybe");
        airline.setCountry("Fiji");
        airline.setIata("iata-ta-ta");
        airline.setIcao("cacao");
        airline.setName("Fiji Incorporated Ltd Corp");
        return airline;
    }
}
