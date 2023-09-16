package com.example.parking_car.repository;

import com.example.parking_car.model.FloorParking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFloorParkingRepo extends JpaRepository<FloorParking,Long> {
}
