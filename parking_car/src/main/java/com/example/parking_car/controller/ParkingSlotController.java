package com.example.parking_car.controller;

import com.example.parking_car.service.parking_slot.IParkingSlotService;
import com.example.parking_car.service.parking_slot.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking_slot")
@CrossOrigin("*")
public class ParkingSlotController {
    @Autowired
    private IParkingSlotService parkingSlotService;

    @GetMapping("/{floor}")
    public ResponseEntity<?> getParkingSlots(@PathVariable("floor") Long floor){
        return new ResponseEntity<>(parkingSlotService.findByFloor(floor), HttpStatus.OK);
    }
    @GetMapping("/slot/{id}")
    public ResponseEntity<?> getParkingSlot(@PathVariable("id") Long id){
        return new ResponseEntity<>(parkingSlotService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{idSlot}")
    public ResponseEntity<?> updateSlot(@PathVariable("idSlot") Long idSlot){
        parkingSlotService.update(idSlot);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
