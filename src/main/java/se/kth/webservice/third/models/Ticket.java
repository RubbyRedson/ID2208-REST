package se.kth.webservice.third.models;

/**
 * Created by Nick on 2/6/2017.
 */
public class Ticket {
    private int id;
    Booking booking;
    Departure departure;
    Route route;
    Airline airline;
    float price;

    public Ticket() {
    }

    /*
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookingId;
        return result;
    }
    */

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
