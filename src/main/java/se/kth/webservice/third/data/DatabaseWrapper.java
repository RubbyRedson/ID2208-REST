package se.kth.webservice.third.data;

import se.kth.webservice.third.models.Airport;
import se.kth.webservice.third.models.TravelPath;

import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public class DatabaseWrapper implements IRepository{

    private NeoDB neoDB;
    private FlightDatabase flightDatabase;

    public DatabaseWrapper(){
        neoDB = new NeoDB();
        flightDatabase = new FlightDatabase();
    }

    @Override
    public List<Airport> getAllAirports(int start, int from) {
        return flightDatabase.getAllAirports(start, from);
    }

    @Override
    public Airport getAirportById(int id) {
        return flightDatabase.getAirportById(id);
    }

    @Override
    public Airport insertAirport(Airport airport) {
        return flightDatabase.insertAirport(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return flightDatabase.updateAirport(airport);
    }

    @Override
    public String deleteAirport(int id) {
        return flightDatabase.deleteAirport(id);
    }

    @Override
    public TravelPath getItineraries(int from, int to) {
        List<TravelPath> paths = neoDB.getRoutes(from + "", to + "");
        return paths != null && paths.size() > 0 ? paths.get(0) : null;
    }
}
