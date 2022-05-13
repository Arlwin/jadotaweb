package com.fajardo.jadotaweb.services.impl;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.factories.UserFactory;
import com.fajardo.jadotaweb.models.users.LoginUserRequest;
import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.repositories.UserRepository;
import com.fajardo.jadotaweb.services.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord.CreateRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private FirebaseAuth firebaseAuth;

    private UserRepository userRepository;
    private UserFactory userFactory;

    @Autowired
    public UserServiceImpl(UserFactory userFactory, UserRepository userRepository, FirebaseAuth firebaseAuth){

        this.userRepository = userRepository;
        this.userFactory = userFactory;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public String addUser(User user) {

        return this.userRepository.save(user).block().getId();
    }
    
    @Override
    public String addUser(NewUserRequest newUser) {
        
        // Add to Firestore first
        String uid = this.userFactory.createUser(newUser);

        // Add to Firebase Auth
        var firebaseAuthUser = new CreateRequest()
            .setUid(uid)
            .setEmail(newUser.getEmail())
            .setPassword(newUser.getPassword())
            .setDisplayName(newUser.getUsername());
        try {
            
            firebaseAuth.createUser(firebaseAuthUser);
        } catch(FirebaseAuthException fe) {

            log.error("Unable to add user to Firebase Auth");
            fe.printStackTrace();
        }
        
        return uid;
    }

    @Override
    public User getUser(String userId) throws InvalidUserException {
        
        User user = this.userRepository.findById(userId).block();

        if (user == null) {

            throw InvalidUserException.USER_DOES_NOT_EXIST(userId);
        }

        user.setPassword(null); // Make sure password will not be passed
        return user;
    }

    @Override
    public Boolean isUserExists(String userId) {
        
        return this.userRepository.existsById(userId).block();
    }
}
