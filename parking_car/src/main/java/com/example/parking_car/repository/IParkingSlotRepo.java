package com.example.parking_car.repository;

import com.example.parking_car.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IParkingSlotRepo extends JpaRepository<ParkingSlot,Long> {
    List<ParkingSlot> findByFloorParking_Id(Long id);

    Optional<ParkingSlot> findParkingSlotByIdAndVersionIsFalse(Long id);

    Optional<ParkingSlot> findById(Long id);
}
