package com.fajardo.jadotaweb.models.security;

import java.util.Collection;
import java.util.List;

import com.fajardo.jadotaweb.entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;

public class SecurityUser implements UserDetails {

    private User user;

    public SecurityUser(){}

    public SecurityUser(User user){
        
        this.user = user;
    }

    public String getId(){

        return user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return List.of(() -> "ROLE_USER");
    }

    @Override
    public String getPassword() {
        
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        
        return user.getUsername();
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
