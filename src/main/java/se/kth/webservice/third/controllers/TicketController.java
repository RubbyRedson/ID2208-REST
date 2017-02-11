package se.kth.webservice.third.controllers;

import org.json.JSONObject;
import se.kth.webservice.third.models.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by victoraxelsson on 2017-02-11.
 */

@Path("ticket")
public class TicketController extends Controller {

    @POST
    @Consumes("application/json")
    @Path("issue")
    public Response issueTicket(String payload){
        JSONObject req = new JSONObject(payload);
        if(req.has("bookingId")) {
            int bookingId = req.getInt("bookingId");

            repo.issueTicket(bookingId);

            Booking booking = repo.getBookingById(bookingId);
            Departure departure = repo.getDepartureById(booking.getDepartureId());
            Route route = repo.getRouteById(departure.getRouteId());
            int bookingCount = repo.getBookingCount(departure.getId());
            Airline airline = repo.getAirlineById(route.getAirlineId());

            Ticket ticket = new Ticket();
            ticket.setBooking(booking);
            ticket.setDeparture(departure);
            ticket.setRoute(route);
            ticket.setPrice(bookingCount * 1000);
            ticket.setAirline(airline);


            Ticket ticket1 = new Ticket();

            Booking booking1 = new Booking();
            booking1.setId(ticket.getBooking().getId());
            booking1.setCardNumber(ticket.getBooking().getCardNumber());
            booking1.setDepartureId(ticket.getBooking().getDepartureId());
            booking1.setIssued(true);

            Departure departure1 = new Departure();
            departure1.setId(departure.getId());
            departure1.setRouteId(departure.getRouteId());
            departure1.setLands(departure.getLands());
            departure1.setLifts(departure.getLifts());

            Route route1 = new Route();
            route1.setId(route.getId());
            route1.setAirline(route.getAirline());
            route1.setAirlineId(route.getAirlineId());
            route1.setDestinationAirport(route.getDestinationAirport());
            route1.setDestinationAirportId(route.getDestinationAirportId());
            route1.setCodeshare(route.getCodeshare());
            route1.setSourceAirport(route.getSourceAirport());
            route1.setSourceAirportId(route.getSourceAirportId());
            route1.setEquipment(route.getEquipment());
            route1.setStops(route.getStops());

            Airline airline1 = new Airline();
            airline1.setId(airline.getId());
            airline1.setActive(airline.getActive());
            airline1.setAlias(airline.getAlias());
            airline1.setCallsign(airline.getCallsign());
            airline1.setCountry(airline.getCountry());
            airline1.setIata(airline.getIata());
            airline1.setIcao(airline.getIcao());
            airline1.setName(airline.getName());

            ticket1.setId(ticket.getId());
            ticket1.setPrice(ticket.getPrice());
            ticket1.setRoute(route1);
            ticket1.setDeparture(departure1);
            ticket1.setBooking(booking1);
            ticket1.setAirline(airline1);

            return Response.status(200).entity(ticket1).build();
        }

        return Response.status(400).entity("Bad request").build();
    }
}
