package com.example.parking_car.repository;

import com.example.parking_car.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IReservationRepo extends JpaRepository<Reservation,Long> {
        Page<Reservation> findByAccount_IdOrderByStartTimeDesc(Long idAccount, Pageable pageable);
        Optional<Reservation> findById(Long id);

        Optional<Reservation> findByIdCardContainingAndParkingSlot_IdAndTotalPriceAndNumberPlateAndStartTimeAndEndTime(
                String idCard,Long slotId,Long total,String numberPlate,String start,String end
        );
}
