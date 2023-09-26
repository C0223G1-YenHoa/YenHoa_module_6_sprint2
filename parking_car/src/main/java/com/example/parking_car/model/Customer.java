package com.example.parking_car.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String idCard;
    private String phone;
    private String licensePlates;
    private float purse;
    private String verificationCode;

    private boolean enabled;
    private Date expiryDate;
    private boolean flagDelete;



    @OneToOne
    private Account account;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String idCard, String phone, String licensePlates, float purse, String verificationCode, boolean enabled, Date expiryDate, boolean flagDelete, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idCard = idCard;
        this.phone = phone;
        this.licensePlates = licensePlates;
        this.purse = purse;
        this.verificationCode = verificationCode;
        this.enabled = enabled;
        this.expiryDate = expiryDate;
        this.flagDelete = flagDelete;
        this.account = account;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
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
