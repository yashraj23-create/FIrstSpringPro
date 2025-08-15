package com.example.demo.Security;

import com.example.demo.Entity.UserIdentity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrinciple implements UserDetails {
    private final UserIdentity userIdentity;
    public UserPrinciple(UserIdentity userIdentity){
        this.userIdentity = userIdentity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return userIdentity.getPassword();
    }

    @Override
    public String getUsername() {
        return userIdentity.getUsername();
    }
}
