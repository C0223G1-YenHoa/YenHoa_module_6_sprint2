package com.example.parking_car.model;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private float purse;

    @OneToOne
    private Account account;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String phone, float purse, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.purse = purse;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getPurse() {
        return purse;
    }

    public void setPurse(float purse) {
        this.purse = purse;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
