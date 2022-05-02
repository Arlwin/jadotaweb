package com.fajardo.jadotaweb.controllers;

import com.fajardo.jadotaweb.dao.User;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${api.base}/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> getPost(@RequestBody User user){

        String userId = userService.addUser(user);

        return ResponseEntity.ok(userId);
    }
}
