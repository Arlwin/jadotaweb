package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.dao.User;
import com.fajardo.jadotaweb.models.users.NewUserRequest;

public interface UserService {
    
    public String addUser(User user);
    public String addUser(NewUserRequest user);
    public User getUser(String userId);
    public Boolean isUserExists(String userId);
}
