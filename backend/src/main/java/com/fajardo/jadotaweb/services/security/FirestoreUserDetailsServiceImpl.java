package com.fajardo.jadotaweb.services.security;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.models.security.SecurityUser;
import com.fajardo.jadotaweb.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FirestoreUserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public FirestoreUserDetailsServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).blockFirst();
        return new SecurityUser(user);
    }
}
