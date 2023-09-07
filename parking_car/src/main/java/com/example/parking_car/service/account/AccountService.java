package com.example.parking_car.service.account;

import com.example.parking_car.model.Account;
import com.example.parking_car.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    IAccountRepo accountRepo;
    @Override
    public void createAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepo.findByAccountNameContainsIgnoreCase(email);
    }
}
