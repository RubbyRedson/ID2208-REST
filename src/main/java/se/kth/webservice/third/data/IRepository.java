package se.kth.webservice.third.data;

import se.kth.webservice.third.models.Airport;
import se.kth.webservice.third.models.TravelPath;

import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public interface IRepository {
    List<Airport> getAllAirports(int start, int size);
    Airport getAirportById(int id);
    Airport insertAirport(Airport airport);
    Airport updateAirport(Airport airport);
    String deleteAirport(int id);
    TravelPath getItineraries(int from, int to);
}
