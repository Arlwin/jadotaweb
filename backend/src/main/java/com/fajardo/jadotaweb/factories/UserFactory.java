package com.fajardo.jadotaweb.factories;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.repositories.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserFactory(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public String createUser(NewUserRequest user) {

        return userRepository.save(
            new User()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(passwordEncoder.encode(user.getPassword()))
        )
        .block()
        .getId();
    }
}
