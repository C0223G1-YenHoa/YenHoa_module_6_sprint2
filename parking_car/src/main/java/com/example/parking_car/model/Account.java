package com.example.parking_car.model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String password;

    @OneToOne
    private Role role;

    public Account() {
    }

    public Account(Long id, String accountName, String password, Role role) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
        this.role = role;
    }

    public Account(String accountName, String password, Role role) {
        this.accountName = accountName;
        this.password = password;
        this.role = role;
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
