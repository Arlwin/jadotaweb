package com.fajardo.jadotaweb.entities;

import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.google.cloud.firestore.annotation.DocumentId;

import org.springframework.cloud.gcp.data.firestore.Document;

@Document(collectionName = "users")
public class User {
    
    @DocumentId
    private String id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Helpers

    public User(){}

    public User(NewUserRequest newUserRequest) {
        
        this.username = newUserRequest.getUsername();
        this.email = newUserRequest.getEmail();
        this.password = newUserRequest.getPassword();
    }

    public String getId() {
        return id;
    }
    public User setId(String id) {
        this.id = id;
        return this;
    }
    public String getUsername() {
        return username;
    }
    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public String getLastName() {
        return lastName;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
