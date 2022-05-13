package com.fajardo.jadotaweb.models.users;

import com.fajardo.jadotaweb.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginUserResponse {

    private User user;
    private String message;
    
    // final private String id;
    // final private String email;
    // final private String username;

    // private String firstName;
    // private String lastName;

    // public LoginUserResponse(User user) {

    //     this.id = user.getId();
    //     this.email = user.getEmail();
    //     this.username = user.getUsername();
    //     this.firstName = user.getFirstName();
    //     this.lastName = user.getLastName();
    // }
}
