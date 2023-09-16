package com.example.parking_car.controller;

import com.example.parking_car.dto.CustomerDto;
import com.example.parking_car.model.Account;
import com.example.parking_car.model.Customer;
import com.example.parking_car.model.Role;
import com.example.parking_car.security.jwt.JwtProvider;
import com.example.parking_car.service.account.IAccountService;
import com.example.parking_car.service.customer.ICustomerService;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IAccountService accountService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/{port}")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerdto, @PathVariable("port") String port) throws MessagingException, UnsupportedEncodingException {
        Customer customer = new Customer();
        customerdto.setExpiryDate(calculateExpiryDate());
        BeanUtils.copyProperties(customerdto, customer);
        Account account = new Account();
        account.setAccountName(customer.getEmail());
        String encoderNewPassword = passwordEncoder.encode(customer.getAccount().getPassword());
        account.setPassword(encoderNewPassword);
        Role role = new Role(1L, "ROLE_CUSTOMER");
        account.setRole(role);
        accountService.createAccount(account);
        customer.setAccount(accountService.findByEmail(account.getAccountName()));
        customerService.create(customer);
        customerService.sendVerificationEmail(customer, port);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/verify/{code}")
    public ResponseEntity<?> verifyCustomer(@PathVariable("code") String code) {
        if (customerService.verify(code)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/{email}")
    public ResponseEntity<?> getCustomer(@PathVariable("email") String email) {
        return new ResponseEntity<>(customerService.findCustomerByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{money}/{email}")
    public ResponseEntity<?> recharge(@PathVariable("money")Long money,@PathVariable("email")String email){
        Customer customer=customerService.findCustomerByEmail(email);
        customer.setPurse((customer.getPurse()+money));
        customerService.update(customer);
        return new ResponseEntity<>( HttpStatus.OK);

    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 1);
        return new Date(cal.getTime().getTime());
    }


}
