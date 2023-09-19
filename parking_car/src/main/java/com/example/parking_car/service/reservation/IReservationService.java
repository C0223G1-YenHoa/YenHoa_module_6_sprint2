package com.example.parking_car.service.reservation;

import com.example.parking_car.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    void create(Reservation reservation);

    List<Reservation> getAll();

    Optional<Reservation> getReservation(Long id);

    Page<Reservation> history(Long id, Pageable pageable);

    Optional<Reservation> confirmQR( String idCard,Long slotId,Long total,String numberPlate,String start,String end);
    void sendQR(String qr,String email) throws MessagingException, UnsupportedEncodingException;
}
