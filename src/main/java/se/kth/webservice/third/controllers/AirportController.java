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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public List<Airport> getAllAirports(@QueryParam(value="start") int start, @QueryParam(value="size") int size){

        start = start == 0 ? DEFAULT_PAGE_START : start;
        size = size == 0 ? DEFAULT_PAGE_SIZE : size;

        return repo.getAllAirports(start, size);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Airport getAllAirports(@PathParam(value="id") int id){
        return repo.getAirportById(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Airport createAirport(Airport airport){
        return repo.insertAirport(airport);
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Airport updateAirport(Airport airport){
        return repo.updateAirport(airport);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public String updateAirport(@PathParam(value="id") int id){
        return repo.deleteAirport(id);
    }

}
