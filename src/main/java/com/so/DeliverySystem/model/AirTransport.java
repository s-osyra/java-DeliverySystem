package com.so.DeliverySystem.model;
import javax.persistence.Column;
import javax.persistence.Entity;
@Entity(name = "Air_Transport")
public class AirTransport  extends ModeOfTransportation {
    @Column (name = "Departure_Airport")
    private String departureAirport;
    @Column (name = "Arrival_Airport")
    private String arrivalAirport;
    @Column (name = "Flight_Number")
    private String flightNumber;
    public String getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
