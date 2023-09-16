package com.example.parking_car.controller;

import com.example.parking_car.dto.response.JwtResponse;
import com.example.parking_car.model.Account;
import com.example.parking_car.security.jwt.JwtProvider;
import com.example.parking_car.security.userpincal.UserPrinciple;
import com.example.parking_car.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private IAccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody Account account){
        Account acc=accountService.findByEmail(account.getAccountName());
        boolean match=passwordEncoder.matches(account.getPassword(),acc.getPassword());
        if (match){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(account.getAccountName(), account.getPassword())
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String token = jwtProvider.createToken(authentication);
                UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
                return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(),userPrinciple.getAuthorities()));
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getAccount( @PathVariable("email") String email){
        return new ResponseEntity<>(accountService.findByEmail(email),HttpStatus.OK);
    }


//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    @GetMapping("/aa")
//    public ResponseEntity<?> aa (){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
