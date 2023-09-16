package com.example.parking_car.model;

import javax.persistence.*;

@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean availability;
    private boolean version;
    private float priceSlot;
    @ManyToOne
    private FloorParking floorParking;

    public ParkingSlot() {
    }

    public ParkingSlot(Long id, Boolean availability, boolean version, float priceSlot, FloorParking floorParking) {
        this.id = id;
        this.availability = availability;
        this.version = version;
        this.priceSlot = priceSlot;
        this.floorParking = floorParking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isVersion() {
        return version;
    }

    public void setVersion(boolean version) {
        this.version = version;
    }

    public float getPriceSlot() {
        return priceSlot;
    }

    public void setPriceSlot(float priceSlot) {
        this.priceSlot = priceSlot;
    }

    public FloorParking getFloorParking() {
        return floorParking;
    }

    public void setFloorParking(FloorParking floorParking) {
        this.floorParking = floorParking;
    }
}
