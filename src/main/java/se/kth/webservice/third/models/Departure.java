package se.kth.webservice.third.models;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class Departure {
    int id;
    int routeId;
    String lifts;
    String lands;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getLifts() {
        return lifts;
    }

    public void setLifts(String lifts) {
        this.lifts = lifts;
    }

    public String getLands() {
        return lands;
    }

    public void setLands(String lands) {
        this.lands = lands;
    }
}
