package com.example.parking_car.security.userpincal;

import com.example.parking_car.model.Account;
import com.example.parking_car.model.Customer;
import com.example.parking_car.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private String accountName;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    public UserPrinciple() {
    }

    public UserPrinciple(Long id, String accountName, String password, Collection<? extends GrantedAuthority> roles) {
        this.accountName = accountName;
        this.password = password;
        this.roles = roles;
    }

    public static UserPrinciple build(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();
//            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(account.getRole().getName());
        authorities.add(new SimpleGrantedAuthority(account.getRole().getName()));
        return new UserPrinciple(
                account.getId() ,
                account.getAccountName(),
                account.getPassword(),
                authorities
        );
    }




    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accountName;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
