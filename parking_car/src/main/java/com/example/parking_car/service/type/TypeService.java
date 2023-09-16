package com.example.parking_car.service.type;

import com.example.parking_car.model.FloorParking;
import com.example.parking_car.model.Type;
import com.example.parking_car.repository.IFloorParkingRepo;
import com.example.parking_car.repository.ITypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepo typeRepo;
    @Override
    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepo.findById(id);
    }
}
