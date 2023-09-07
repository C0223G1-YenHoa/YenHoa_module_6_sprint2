package com.example.parking_car.model;


import javax.persistence.*;

@Entity
public class FloorParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capacity;
    @ManyToOne
    private ParkingCar parkingCar;

    public FloorParking() {
    }

    public FloorParking(Long id, int capacity, ParkingCar parkingCar) {
        this.id = id;
        this.capacity = capacity;
        this.parkingCar = parkingCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingCar getParkingCar() {
        return parkingCar;
    }

    public void setParkingCar(ParkingCar parkingCar) {
        this.parkingCar = parkingCar;
    }
}
