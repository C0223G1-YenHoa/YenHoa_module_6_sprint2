package com.example.parking_car.controller;

import com.example.parking_car.service.floor_parking.IFloorParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/floor")
public class FloorParkingController {
    @Autowired
    private IFloorParkingService floorParkingService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(floorParkingService.findAll(), HttpStatus.OK);
    }
}
