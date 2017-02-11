package se.kth.webservice.third.controllers;

import se.kth.webservice.third.models.Airport;
import se.kth.webservice.third.models.TravelPath;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
@Path("itinerary")
public class ItineraryController extends Controller {

    @GET
    @Path("from/{from}/to/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public TravelPath getAllAirports(@PathParam(value="from") int from, @PathParam(value="to") int to){
        return repo.getItineraries(from, to);
    }
}
