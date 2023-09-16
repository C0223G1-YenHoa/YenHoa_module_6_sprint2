package com.example.parking_car.service.floor_parking;

import com.example.parking_car.model.FloorParking;
import com.example.parking_car.repository.IFloorParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorParkingService implements IFloorParkingService{
    @Autowired
    private IFloorParkingRepo floorParkingRepo;
    @Override
    public List<FloorParking> findAll() {
        return floorParkingRepo.findAll();
    }
}
