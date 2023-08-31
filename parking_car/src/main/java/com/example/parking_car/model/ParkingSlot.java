package com.example.parking_car.model;

import javax.persistence.*;

@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean availability;
    private float priceSlot;
    @ManyToOne
    private FloorParking floorParking;

    public ParkingSlot() {
    }

    public ParkingSlot(Long id, Boolean availability, float priceSlot, FloorParking floorParking) {
        this.id = id;
        this.availability = availability;
        this.priceSlot = priceSlot;
        this.floorParking = floorParking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
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
