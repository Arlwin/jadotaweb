package com.fajardo.jadotaweb.models.users;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserRequest {

    @NonNull
    @NotBlank(message = "Email is required")
    private String email;
    
    @NonNull
    @NotBlank(message = "Username is required")
    private String username;
    
    @NonNull
    @NotBlank(message = "Password is required")
    private String password;
}

// Figure out api validation for spring 5