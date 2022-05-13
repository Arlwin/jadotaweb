package com.fajardo.jadotaweb.config.firebase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Auth {

    @Value("${spring.cloud.gcp.credentials.encoded-key}")
    private String serviceAccountJson;

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        var options = FirebaseOptions.builder()
            .setCredentials(
                GoogleCredentials.fromStream(
                    new ByteArrayInputStream(
                        Base64.getDecoder().decode(serviceAccountJson)
                    )
                )
            )
            .build();

        return FirebaseApp.initializeApp(options);
    }
    
    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {

        return FirebaseAuth.getInstance(firebaseApp());
    }
}
