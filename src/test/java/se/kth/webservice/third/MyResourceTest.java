package se.kth.webservice.third;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.internal.HttpUrlConnector;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.webservice.third.models.Airport;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.testStart();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Some stuff", responseMsg);
    }

    @Test
    public void login() {
        Response response =
                target.path("auth/login").request().post(Entity.json("{username:\"victor@victor.com\",password:\"abc123\"}"));
        String responeEntity = response.readEntity(String.class);
        assertTrue(responeEntity.contains("\"token\":"));
    }

    @Test
    public void itineraries() {
        Response response =
                target.path("itinerary/from/1/to/2").request().get();
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"from\":\"ARL\",\"label\":\"Path label\",\"routeId\":\"Route id\",\"to\":\"SVO\"}",
                responeEntity);
    }

    @Test
    public void route() {
        Response response =
                target.path("itinerary/departure/1").request().get();
        String responeEntity = response.readEntity(String.class);
        assertEquals("[{\"routeId\":1,\"lands\":\"land me down\",\"id\":1,\"lifts\":\"lift me up\"},{\"routeId\":1,\"lands\":\"land me down\",\"id\":2,\"lifts\":\"lift me up\"}]",
                responeEntity);
    }

    @Test
    public void booking() {
        Response response =
                target.path("booking/availability/1").request().get();
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"available\":true,\"departure\":{\"id\":1,\"lands\":\"land me down\",\"lifts\":" +
                        "\"lift me up\",\"routeId\":1},\"label\":\"The departure is at: lift me up and lands at land me down\",\"price\":2000.0}",
                responeEntity);
    }

    @Test
    public void book() {
        Response response =
                target.path("booking/book").request().post(Entity.json("{creditcard:\"00000000000000\",departureId:\"1\"}"));
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"cardNumber\":\"00000000000000\",\"departureId\":1,\"id\":0,\"issued\":false}",
                responeEntity);
    }

    @Test
    public void issue() {
        Response response =
                target.path("ticket/issue").request().post(Entity.json("{bookingId:\"1\"}"));
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"airline\":{\"active\":\"nocturnally\",\"alias\":\"Alias\",\"callsign\":\"call me maybe" +
                        "\",\"country\":\"Fiji\",\"iata\":\"iata-ta-ta\",\"icao\":\"cacao\",\"id\":1,\"name\":\"Fiji " +
                        "Incorporated Ltd Corp\"},\"booking\":{\"cardNumber\":\"00000000000000\",\"departureId\":1," +
                        "\"id\":1,\"issued\":false},\"departure\":{\"id\":1,\"lands\":\"land me down\",\"lifts\":\"lift" +
                        " me up\",\"routeId\":1},\"id\":0,\"price\":2000.0,\"route\":{\"airline\":\"airline1\"," +
                        "\"airlineId\":1,\"codeshare\":\"codeshare\",\"destinationAirport\":\"ARL\"," +
                        "\"destinationAirportId\":1,\"equipment\":\"big one\",\"id\":1,\"sourceAirport\":\"SVO\"," +
                        "\"sourceAirportId\":2,\"stops\":0}}",
                responeEntity);
    }

    @Test
    public void airportGet() {
        Response response =
                target.path("airport").request().get();
        String responeEntity = response.readEntity(String.class);
        assertEquals("[{\"country\":\"Swe\",\"iata\":\"wherever\",\"lng\":1,\"dst\":\"Dst\",\"city\":" +
                        "\"Stockholm\",\"name\":\"Arlanda\",\"icao\":\"whatever\",\"altitudeFeet\":560,\"id\":1,\"lat\"" +
                        ":1},{\"country\":\"Swe2\",\"iata\":\"wherever2\",\"lng\":2,\"dst\":\"Dst2\",\"city\":" +
                        "\"Stockholm2\",\"name\":\"Arlanda2\",\"icao\":\"whatever2\",\"altitudeFeet\":5601,\"id\":2," +
                        "\"lat\":2}]",
                responeEntity);
    }

    @Test
    public void airportPost() {
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
        Response response =
                target.path("airport").request().post(Entity.json(a1));
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"type\":\"airport\",\"altitudeFeet\":560,\"city\":\"Stockholm\",\"country\":\"Swe\"," +
                        "\"dst\":\"Dst\",\"iata\":\"wherever\",\"icao\":\"whatever\",\"id\":1,\"lat\":1.0,\"lng\":1.0," +
                        "\"name\":\"Arlanda\",\"type\":\"airport\"}",
                responeEntity);
    }

    @Test
    public void airportPut() {
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
        Response response =
                target.path("airport").request().post(Entity.json(a1));
        String responeEntity = response.readEntity(String.class);
        assertEquals("{\"type\":\"airport\",\"altitudeFeet\":560,\"city\":\"Stockholm\",\"country\":\"Swe\"," +
                        "\"dst\":\"Dst\",\"iata\":\"wherever\",\"icao\":\"whatever\",\"id\":1,\"lat\":1.0,\"lng\":1.0," +
                        "\"name\":\"Arlanda\",\"type\":\"airport\"}",
                responeEntity);
    }

    @Test
    public void airportDelete() {
        Response response =
                target.path("airport/1").request().delete();
        String responeEntity = response.readEntity(String.class);
        assertEquals("Success",
                responeEntity);
    }
}
