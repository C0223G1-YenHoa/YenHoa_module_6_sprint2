package com.example.parking_car.service.parking_slot;


import com.example.parking_car.model.ParkingSlot;

import java.util.List;
import java.util.Optional;

public interface IParkingSlotService {
    List<ParkingSlot> findByFloor(Long id);
    void update(Long idSlot);

    Optional<ParkingSlot> findById(Long id);
    Optional<ParkingSlot> findByIdAndVersion(Long id);
}
