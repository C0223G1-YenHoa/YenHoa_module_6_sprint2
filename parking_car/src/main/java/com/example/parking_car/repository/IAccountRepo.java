package com.example.parking_car.repository;

import com.example.parking_car.model.Account;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountName(String email);
    Account findByAccountNameContainsIgnoreCase(String email);
}
