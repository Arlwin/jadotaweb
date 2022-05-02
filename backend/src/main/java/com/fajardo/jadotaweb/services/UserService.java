package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.dao.User;

public interface UserService {
    
    public String addUser(User user);
    public User getUser(String userId);
    public Boolean isUserExists(String userId);
}
