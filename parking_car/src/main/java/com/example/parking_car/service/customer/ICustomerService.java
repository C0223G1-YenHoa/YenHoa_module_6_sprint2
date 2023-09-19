package com.example.parking_car.service.customer;

import com.example.parking_car.model.Customer;
import javax.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ICustomerService{
    void create(Customer customer);
    void sendVerificationEmail(Customer customer, String siteURL) throws MessagingException, UnsupportedEncodingException;
    boolean verify(String verificationCode);
    Customer findCustomerByEmail(String email);

    void update(Customer customer);

    Customer findByCode(String code);

    List<Customer> getList();

    void delete(Customer customer);
}
