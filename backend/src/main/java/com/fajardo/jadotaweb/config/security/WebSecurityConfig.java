package com.fajardo.jadotaweb.config.security;

import com.fajardo.jadotaweb.config.security.filters.JwtAuthFilter;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private String baseUrl;

	FirebaseAuth firebaseAuth;

	public WebSecurityConfig(@Qualifier("baseUrl") String baseUrl, FirebaseAuth firebaseAuth) {

		this.baseUrl = baseUrl;
		this.firebaseAuth = firebaseAuth;
	}
    
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(); // Passwords are encrypted by Firebase Auth
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
			.cors().and()
			.authorizeRequests()
		  		.antMatchers(HttpMethod.POST, baseUrl + "/posts").authenticated()
		  		.antMatchers(HttpMethod.GET, baseUrl + "/users/login").authenticated()
				.anyRequest().permitAll()
				.and()
			.csrf()
		  		.disable()
			.addFilter(new JwtAuthFilter(authenticationManagerBean(), firebaseAuth));
    }

	@Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
