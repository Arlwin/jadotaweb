package com.fajardo.jadotaweb.config.security.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthFilter extends BasicAuthenticationFilter {

    private final static String TOKEN_PREFIX = "Bearer";

    FirebaseAuth firebaseAuth;

    public JwtAuthFilter(AuthenticationManager authenticationManager, FirebaseAuth firebaseAuth) {

        super(authenticationManager);
        this.firebaseAuth = firebaseAuth;
    }
    
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response, 
        FilterChain chain
        ) throws IOException, ServletException {
        
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (auth != null && auth.split(" ")[0].equals(TOKEN_PREFIX)) {
            
            var authentication = getAuthentication(auth);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authHeader){

        String token = authHeader.split(" ")[1];

        if (token != null && !token.isBlank()) {

            try {
                
                var firebaseUser = firebaseAuth.verifyIdToken(token);
                return new UsernamePasswordAuthenticationToken(
                    firebaseUser.getUid(), 
                    null, 
                    List.of(() -> "ROLE_USER")
                );

            } catch (FirebaseAuthException e) {

                e.printStackTrace();
            }
        }

        return null;
    }
}
