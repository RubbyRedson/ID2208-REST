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

            return Response.status(200).entity(ticket).build();
        }

        return Response.status(400).entity("Bad request").build();
    }
}
