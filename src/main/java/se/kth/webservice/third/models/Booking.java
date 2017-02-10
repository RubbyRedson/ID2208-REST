package se.kth.webservice.third.models;

/**
 * Created by Nick on 2/6/2017.
 */
public class Booking {
    private int id;
    private int departureId;
    private String cardNumber;
    private boolean issued;

    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", departureId=" + departureId +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (departureId != booking.departureId) return false;
        return (cardNumber != null ? !cardNumber.equals(booking.cardNumber) : booking.cardNumber != null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + departureId;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        return result;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartureId() {
        return departureId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setDepartureId(int departureId) {
        this.departureId = departureId;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
