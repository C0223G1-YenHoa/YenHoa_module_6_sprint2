package com.example.parking_car.service.account;

import com.example.parking_car.model.Account;

public interface IAccountService {
    void createAccount(Account account);
    Account findByEmail(String email);
}
