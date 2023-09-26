package com.example.parking_car.controller;


import com.example.parking_car.model.Account;
import com.example.parking_car.model.Customer;
import com.example.parking_car.model.Notification;
import com.example.parking_car.model.Reservation;
import com.example.parking_car.service.account.IAccountService;
import com.example.parking_car.service.customer.ICustomerService;
import com.example.parking_car.service.reservation.IReservationService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Component
public class Schedule {
    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(cron = "0 0/1 * * * *")
    private void cronJobSchedule() {
        String pattern = "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        List<Reservation> reservations = reservationService.getAll();
        List<Reservation> expire = new ArrayList<>();
        for (Reservation re : reservations) {
            LocalDateTime end = LocalDateTime.parse(re.getEndTime(), formatter);
            Duration duration = Duration.between(now, end);
            if (duration.toHours() == 0 && duration.toMinutes() < 40 && duration.toMinutes() >= 30) {
                expire.add(new Reservation(re.getEndTime(),re.getNumberPlate(), re.getParkingSlot(), re.getAccount()));
            }
        }
        System.out.println(expire.size());
        Notification notification ;

        for (Reservation reservation : expire) {
            if (Objects.nonNull(reservation.getAccount().getAccountName())) {
                notification= new Notification("Thời gian của vị trí YH."+reservation.getParkingSlot().getId()+" Biển số xe "+reservation.getNumberPlate()+" sắp hết thời gian");
                System.out.println(reservation.getNumberPlate());
                simpMessagingTemplate.convertAndSendToUser(reservation.getAccount().getAccountName(), "/private", notification);
            }
        }
    }

    @Scheduled(cron = "0 0/10 * * * *")
    public void checkExpire() {
        List<Customer> customers = customerService.getList();
        Calendar cal = Calendar.getInstance();
        for (Customer customer : customers) {
            if (customer.getExpiryDate() != null) {
                if ((customer.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
                    customerService.delete(customer);
                    accountService.deleteAcc(accountService.findByEmail(customer.getEmail()));
                    System.out.println("success");
                }
            }
        }
    }

}
