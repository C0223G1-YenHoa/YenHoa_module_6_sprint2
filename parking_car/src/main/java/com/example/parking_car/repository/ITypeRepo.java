package com.example.parking_car.repository;

import com.example.parking_car.model.Type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ITypeRepo extends JpaRepository<Type,Long> {
    Optional<Type> findById(Long id);
}
