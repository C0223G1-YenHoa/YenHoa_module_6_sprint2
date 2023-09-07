package com.example.parking_car.security.userpincal;

import com.example.parking_car.model.Account;
import com.example.parking_car.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IAccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Account account=accountRepo.findByAccountName(username).orElseThrow(()-> new UsernameNotFoundException("User not found -> user name or password"+username));
        return UserPrinciple.build(account);
    }
}
