package com.example.parking_car.service.customer;

import com.example.parking_car.model.Customer;
import javax.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface ICustomerService{
    void create(Customer customer);
    void sendVerificationEmail(Customer customer, String siteURL) throws MessagingException, UnsupportedEncodingException;
    boolean verify(String verificationCode);
    Customer findCustomerByEmail(String email);

    void update(Customer customer);

}
