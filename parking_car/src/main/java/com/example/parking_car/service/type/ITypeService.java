package com.example.parking_car.service.type;

import com.example.parking_car.model.FloorParking;
import com.example.parking_car.model.Type;

import java.util.List;
import java.util.Optional;

public interface ITypeService {
    List<Type> findAll();
    Optional<Type> findById(Long id);
}
