package se.kth.webservice.third.controllers;

import org.neo4j.cypher.internal.compiler.v2_3.planner.logical.plans.LegacyIndexSeek;
import se.kth.webservice.third.models.Airport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
@Path("airport")
public class AirportController extends Controller{

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Airport> getAllAirports(@QueryParam(value="start") int start, @QueryParam(value="size") int size){

        start = start == 0 ? DEFAULT_PAGE_START : start;
        size = size == 0 ? DEFAULT_PAGE_SIZE : size;

        return repo.getAllAirports(start, size);
    }
}
