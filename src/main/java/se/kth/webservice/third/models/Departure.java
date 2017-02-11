package se.kth.webservice.third.models;

import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class Departure extends Model{
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

    @Override
    public String toString() {
        return "Departure{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", lifts='" + lifts + '\'' +
                ", lands='" + lands + '\'' +
                '}';
    }

    @Override
    public JSONObject toJson() {

        JSONObject o = new JSONObject();
        o.put("id", id);
        o.put("routeId", routeId);
        o.put("lifts", lifts);
        o.put("lands", lands);

        return o;
    }

    @Override
    protected Class getModelClass() {
        return Departure.class;
    }

    @Override
    protected Object getChildInstance() {
        return this;
    }

    @Override
    public String toPlain() {
        return toString();
    }
}
