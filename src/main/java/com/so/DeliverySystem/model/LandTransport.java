package com.so.DeliverySystem.model;
import javax.persistence.Column;
import javax.persistence.Entity;
@Entity(name = "Land_Transport")
public class LandTransport extends ModeOfTransportation {
    @Column (name = "Departure_Place")
    private String departurePlace;
    @Column (name = "Arrival_Place")
    private String arrivalPlace;
    public String getDeparturePlace() {
        return departurePlace;
    }
    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }
    public String getArrivalPlace() {
        return arrivalPlace;
    }
    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }
}
