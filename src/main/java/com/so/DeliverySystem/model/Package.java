package com.so.DeliverySystem.model;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name="package")
public class Package {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToMany
    @JoinTable(name = "packages_transports",
            uniqueConstraints = @UniqueConstraint(columnNames = {"package_id", "transport_id"}),
            joinColumns = @JoinColumn(name = "package_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id",
                    referencedColumnName = "id"))
    private List<ModeOfTransportation> transportId = new LinkedList<ModeOfTransportation>();
    @Column(name = "Current_Localization")
    private String currentLocalization;
    private String dimensions;
    private int mass;
    @Column(name = "Ship_Date")
    private Date shipDate;
    @Column(name = "Internation_Shipping")
    private boolean internationalShipping;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<ModeOfTransportation> getTransportId() {
        return transportId;
    }
    public void setTransportId(List<ModeOfTransportation> transportId) {
        this.transportId = transportId;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    public int getMass() {
        return mass;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }
    public Date getShipDate() {
        return shipDate;
    }
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }
    public boolean isInternationalShipping() {
        return internationalShipping;
    }
    public void setInternationalShipping(boolean internationalShipping) {
        this.internationalShipping = internationalShipping;
    }
    public String getCurrentLocalization() {
        return currentLocalization;
    }
    public void setCurrentLocalization(String currentLocalization) {
        this.currentLocalization = currentLocalization;
    }
    public void addTransportId (ModeOfTransportation s) {
        this.transportId.add(s);
    }
}



