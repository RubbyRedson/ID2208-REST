package se.kth.webservice.third.models;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class Route {
    /*
        #### http://openflights.org/data.html#route ####

    Airline	2-letter (IATA) or 3-letter (ICAO) code of the airline.
    Airline ID	Unique OpenFlights identifier for airline (see Airline).
    Source airport	3-letter (IATA) or 4-letter (ICAO) code of the source airport.
    Source airport ID	Unique OpenFlights identifier for source airport (see Airport)
    Destination airport	3-letter (IATA) or 4-letter (ICAO) code of the destination airport.
    Destination airport ID	Unique OpenFlights identifier for destination airport (see Airport)
    Codeshare	"Y" if this flight is a codeshare (that is, not operated by Airline, but another carrier), empty otherwise.
    Stops	Number of stops on this flight ("0" for direct)
    Equipment	3-letter codes for plane type(s) generally used on this flight, separated by spaces
    * */


    private int id;
    private String airline;
    private int airlineId;
    private String sourceAirport;
    private int sourceAirportId;
    private String destinationAirport;
    private int destinationAirportId;
    private String codeshare;
    private int stops;
    private String equipment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public int getSourceAirportId() {
        return sourceAirportId;
    }

    public void setSourceAirportId(int sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public int getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(int destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public String getCodeshare() {
        return codeshare;
    }

    public void setCodeshare(String codeshare) {
        this.codeshare = codeshare;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
