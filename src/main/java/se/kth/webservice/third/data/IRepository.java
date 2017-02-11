package se.kth.webservice.third.data;

import se.kth.webservice.third.models.Airport;

import java.util.List;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public interface IRepository {
    List<Airport> getAllAirports(int start, int size);
}
