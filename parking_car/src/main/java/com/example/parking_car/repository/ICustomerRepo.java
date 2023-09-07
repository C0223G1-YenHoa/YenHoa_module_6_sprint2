package com.example.parking_car.repository;

import com.example.parking_car.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {

    Customer findByVerificationCode(String verify);
    Customer findByEmail(String email);

}
