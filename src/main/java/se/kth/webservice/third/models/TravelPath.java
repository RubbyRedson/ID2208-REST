package se.kth.webservice.third.models;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class TravelPath {

    private String routeId;
    private String from;
    private String to;
    private String label;
    private TravelPath next;


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public TravelPath getNext() {
        return next;
    }

    public void setNext(TravelPath next) {
        this.next = next;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
