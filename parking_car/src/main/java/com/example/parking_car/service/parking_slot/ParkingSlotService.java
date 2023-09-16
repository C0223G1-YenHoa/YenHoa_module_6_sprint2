package com.example.parking_car.service.parking_slot;

import com.example.parking_car.model.ParkingSlot;
import com.example.parking_car.repository.IParkingSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotService implements IParkingSlotService{
    @Autowired
    private IParkingSlotRepo parkingSlotRepo;

    @Override
    public List<ParkingSlot> findByFloor(Long id) {
        return parkingSlotRepo.findByFloorParking_Id(id);
    }

    @Override
    public void update(Long idSlot) {
        parkingSlotRepo.findParkingSlotByIdAndVersionIsFalse(idSlot)
                .ifPresent(parkingSlot -> {parkingSlot.setAvailability(true);parkingSlot.setVersion(true);});
    }

    @Override
    public Optional<ParkingSlot> findById(Long id) {
        return parkingSlotRepo.findById(id);
    }

    @Override
    public Optional<ParkingSlot> findByIdAndVersion(Long id) {
        return parkingSlotRepo.findParkingSlotByIdAndVersionIsFalse(id);
    }
}
