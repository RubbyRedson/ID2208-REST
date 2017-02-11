package se.kth.webservice.third.controllers;

import org.json.JSONObject;

import javax.json.Json;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Nick on 2/10/2017.
 */
@Path("auth")
public class AuthenticationController {

    private SecureRandom random;

    public AuthenticationController(){
        random = new SecureRandom();
    }

    private String createToken() {
        return new BigInteger(130, random).toString(32);
    }

    @POST
    @Consumes("application/json")
    @Path("login")
    public Response login(String payload) {

        JSONObject req = new JSONObject(payload);
        if(req.has("username") && req.has("password")) {

            if (req.getString("username").equals("victor@victor.com") && req.getString("password").equals("abc123")) {
                JSONObject res = new JSONObject();
                res.put("token", createToken());
                return Response.status(200).entity(res.toString()).build();
            }
        }

        return Response.status(400).entity("Bad request").build();

    }
}
