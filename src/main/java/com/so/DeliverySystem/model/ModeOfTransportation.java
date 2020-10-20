package com.so.DeliverySystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn (name = "Transport_Type")
public abstract class ModeOfTransportation {


    @Id
    @GeneratedValue
    private Long id;

    @Column (name = "Departure_Date")
    private String departureDate;

    @Column (name = "Arrival_Date")
    private String arrivalDate;

    @Column (name = "Company_Name")
    private String companyName;

    @ManyToMany (mappedBy = "transportId")
    @JsonIgnore
    private List<Package> listOfPackages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Package> getListOfPackages() {
        return listOfPackages;
    }

    public void setListOfPackages(List<Package> listOfPackages) {
        this.listOfPackages = listOfPackages;
    }
}
