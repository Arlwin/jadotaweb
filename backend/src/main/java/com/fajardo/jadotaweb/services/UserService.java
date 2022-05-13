package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.models.users.LoginUserRequest;
import com.fajardo.jadotaweb.models.users.NewUserRequest;

public interface UserService {
    
    public String addUser(User user);
    public String addUser(NewUserRequest newUser);
    public User getUser(String userId) throws InvalidUserException;
    public Boolean isUserExists(String userId);
}
