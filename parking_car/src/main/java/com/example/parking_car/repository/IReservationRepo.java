package com.example.parking_car.repository;

import com.example.parking_car.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservationRepo extends JpaRepository<Reservation,Long> {
    @Override
    List<Reservation> findAll();
}
