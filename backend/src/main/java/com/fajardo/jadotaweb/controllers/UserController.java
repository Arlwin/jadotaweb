package com.fajardo.jadotaweb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.fajardo.jadotaweb.exceptions.user.InvalidNewUserException;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.models.users.LoginUserRequest;
import com.fajardo.jadotaweb.models.users.LoginUserResponse;
import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.models.users.NewUserResponse;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        ResponseEntity<NewUserResponse> res = null;
        
        try {

            String userId = userService.addUser(user);
            
            res = ResponseEntity.ok(
                NewUserResponse.builder()
                    .userId(userId)
                    .message("User created successfully")
                    .build()
            );

        } catch (NullPointerException e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (InvalidNewUserException e) {

            res = ResponseEntity.badRequest().body(
                NewUserResponse.builder().message(e.getMessage()).build()
            );
        }

        return res;
    }

    @GetMapping("/login")
    public ResponseEntity<LoginUserResponse> loginUser(Authentication authentication){

        ResponseEntity<LoginUserResponse> resEntity = null;

        try {

            var user = userService.getUser(authentication.getPrincipal().toString());
            resEntity = ResponseEntity.ok(
                new LoginUserResponse(
                    user, 
                    "Login Successful"
            ));

        } catch (InvalidUserException e) {

            resEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginUserResponse(null, e.getMessage()));
        }   

        return resEntity;
    }

    // Utils
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateField(
        @RequestParam Optional<String> email,
        @RequestParam Optional<String> username
    ){

        // Prioritize Email
        if (email.isPresent()) {

            return ResponseEntity.ok(userService.isEmailExists(email.get()));
        }

        if (username.isPresent()) {

            return ResponseEntity.ok(userService.isUsernameExists(username.get()));
        } 

        return ResponseEntity.badRequest().build();
    }
}
