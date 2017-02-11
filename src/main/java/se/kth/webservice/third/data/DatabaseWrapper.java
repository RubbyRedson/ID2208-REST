package se.kth.webservice.third.data;

import se.kth.webservice.third.models.Airport;

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
}
