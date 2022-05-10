package com.fajardo.jadotaweb.config.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private String baseUrl;

	public WebSecurityConfig(@Qualifier("baseUrl") String baseUrl) {

		this.baseUrl = baseUrl;
	}
    
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(); // Passwords are encrypted by Firebase Auth
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
			.authorizeRequests()
		  		.antMatchers(HttpMethod.POST, baseUrl + "/posts").authenticated()
				.anyRequest().permitAll()
				.and()
			.csrf()
		  		.disable()
			.httpBasic();
    }
}
