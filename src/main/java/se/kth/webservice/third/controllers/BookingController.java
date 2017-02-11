package se.kth.webservice.third.controllers;

import org.json.JSONObject;
import se.kth.webservice.third.models.Availability;
import se.kth.webservice.third.models.Booking;
import se.kth.webservice.third.models.Departure;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.print.Book;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
@Path("booking")
public class BookingController extends Controller {

    @GET
    @Path("availability/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Availability checkAvailability(@PathParam(value="id") int id){
        Departure departure = repo.getDepartureById(id);
        int bookingCount = repo.getBookingCount(id);

        Availability availability = new Availability();
        availability.setDeparture(departure);
        availability.setLabel("The departure is at: " + departure.getLifts() + " and lands at " + departure.getLands());

        if(bookingCount < 30){
            availability.setPrice(bookingCount * 1000);
            availability.setAvailable(true);
        }else{
            availability.setPrice(-1);
            availability.setAvailable(false);
        }

        return availability;
    }

    @POST
    @Consumes("application/json")
    @Path("book")
    public Response login(String payload) {

        JSONObject req = new JSONObject(payload);
        if(req.has("creditcard") && req.has("departureId")) {
            int departureId = Integer.parseInt(req.getString("departureId"));
            String creditCard = req.getString("creditcard");

            Availability availability = checkAvailability(departureId);

            if(availability.isAvailable()){
                Booking booking = new  Booking();
                booking.setCardNumber(creditCard);
                booking.setDepartureId(departureId);
                booking.setIssued(false);

                Booking b = repo.saveBooking(booking);

                return  Response.status(200).entity(b).build();
            }
        }

        return Response.status(400).entity("Bad request").build();

    }
}
