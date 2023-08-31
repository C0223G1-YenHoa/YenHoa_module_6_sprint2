package com.example.parking_car.model;

import javax.persistence.*;

@Entity
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float penaltyPrice;
    private int penaltyHour;
    @ManyToOne
    private Reservation reservation;

    public Penalty() {
    }

    public Penalty(Long id, float penaltyPrice, int penaltyHour, Reservation reservation) {
        this.id = id;
        this.penaltyPrice = penaltyPrice;
        this.penaltyHour = penaltyHour;
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPenaltyPrice() {
        return penaltyPrice;
    }

    public void setPenaltyPrice(float penaltyPrice) {
        this.penaltyPrice = penaltyPrice;
    }

    public int getPenaltyHour() {
        return penaltyHour;
    }

    public void setPenaltyHour(int penaltyHour) {
        this.penaltyHour = penaltyHour;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
