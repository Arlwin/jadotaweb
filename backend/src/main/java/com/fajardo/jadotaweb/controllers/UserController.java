package com.fajardo.jadotaweb.controllers;

import javax.validation.Valid;

import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.models.users.NewUserResponse;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("${api.base}/users")
public class UserController extends BaseController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<NewUserResponse> createUser(@Valid @RequestBody NewUserRequest user){

        String userId = null;

        try {

            userId = userService.addUser(user);
        } catch (NullPointerException e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(
            NewUserResponse.builder()
                .userId(userId)
                .message("User created successfully")
                .build()
        );
    }
}
