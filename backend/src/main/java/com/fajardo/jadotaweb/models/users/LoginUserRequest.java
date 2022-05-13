package com.fajardo.jadotaweb.models.users;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserRequest {
    
    @NotBlank(message = "Username / Email is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}
