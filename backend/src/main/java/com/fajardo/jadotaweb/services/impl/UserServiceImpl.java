package com.fajardo.jadotaweb.services.impl;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.factories.UserFactory;
import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.repositories.UserRepository;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserFactory userFactory;

    @Autowired
    public UserServiceImpl(UserFactory userFactory, UserRepository userRepository){

        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Override
    public String addUser(User user) {

        return this.userRepository.save(user).block().getId();
    }
    
    @Override
    public String addUser(NewUserRequest newUser) {
        
        // Add to Firestore first
        String uid = this.userFactory.createUser(newUser);

        // var firebaseAuthUser = new CreateRequest()
        //     .setUid(uid)
        //     .setEmail(newUser.getEmail())
        //     .setPassword(newUser.getPassword())
        //     .setDisplayName(newUser.getUsername());

        // // Add to Firebase Auth
        // try {
            
        //     firebaseAuth.createUser(firebaseAuthUser);
        // } catch(FirebaseAuthException fe) {

        //     log.error("Unable to add user to Firebase Auth");
        //     fe.printStackTrace();
        // }
        
        return uid;
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
