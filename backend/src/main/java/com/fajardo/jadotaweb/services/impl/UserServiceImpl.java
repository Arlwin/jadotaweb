package com.fajardo.jadotaweb.services.impl;

import com.fajardo.jadotaweb.dao.User;
import com.fajardo.jadotaweb.repositories.UserRepository;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public String addUser(User user) {

        return this.userRepository.save(user).block().getId();
    }

    @Override
    public User getUser(String userId) {
        
        return this.userRepository.findById(userId).block();
    }

    @Override
    public Boolean isUserExists(String userId) {
        return this.userRepository.existsById(userId).block();
    }
}
