package com.example.parking_car.controller;

import com.example.parking_car.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")
public class TypeController {
    @Autowired
    ITypeService typeService;

    @GetMapping()
    public ResponseEntity<?> getTypes(){
        return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getType(@PathVariable("id")Long id){
        return new ResponseEntity<>(typeService.findById(id), HttpStatus.OK);
    }
}
