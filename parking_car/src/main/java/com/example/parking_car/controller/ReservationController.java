package com.example.parking_car.controller;


import com.example.parking_car.dto.CustomerDto;
import com.example.parking_car.model.Customer;
import com.example.parking_car.model.Reservation;
import com.example.parking_car.service.customer.ICustomerService;
import com.example.parking_car.service.parking_slot.IParkingSlotService;
import com.example.parking_car.service.reservation.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private IParkingSlotService parkingSlotService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<Customer> creatReservation(@RequestBody Reservation reservation) throws MessagingException, UnsupportedEncodingException {
        if(parkingSlotService.findByIdAndVersion(reservation.getParkingSlot().getId()).isPresent()) {
            parkingSlotService.update(reservation.getParkingSlot().getId());
            Customer customer = customerService.findCustomerByEmail(reservation.getAccount().getAccountName());
            customer.setPurse(customer.getPurse() - reservation.getTotalPrice());
            reservationService.create(reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/history")
    public ResponseEntity<?> history(@RequestParam("id") Long id, @PageableDefault(size=5) Pageable pageable) {
        return new ResponseEntity<>(reservationService.history(id,pageable),HttpStatus.OK);

    }
    @GetMapping("/qr/{id}")
    public ResponseEntity<?> getQr(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reservationService.getReservation(id),HttpStatus.OK);
    }
    @GetMapping("/qr/{idCard}/{slotId}/{total}/{numberPlate}/{start}/{end}/")
    public ResponseEntity<?> confirmQR(@PathVariable("idCard") String idCard,@PathVariable("slotId") Long slotId,@PathVariable("total") Long total,@PathVariable("numberPlate") String numberPlate,@PathVariable("start") String start,@PathVariable("end") String end) {
        if(reservationService.confirmQR(idCard, slotId, total, numberPlate, start, end).isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
