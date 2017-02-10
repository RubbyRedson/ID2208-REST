package se.kth.webservice.third.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Nick on 2/10/2017.
 */
@Path("auth")
public class AuthenticationController {

    @GET
    public String login(@PathParam(value="out") String out) {
        return "token " + out;
    }
}
