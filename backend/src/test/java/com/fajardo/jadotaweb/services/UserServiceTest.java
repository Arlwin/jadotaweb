package com.fajardo.jadotaweb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.exceptions.user.InvalidNewUserException;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.factories.UserFactory;
import com.fajardo.jadotaweb.models.users.NewUserRequest;
import com.fajardo.jadotaweb.repositories.UserRepository;
import com.fajardo.jadotaweb.services.impl.UserServiceImpl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserFactory userFactory;
    
    @Mock
    private UserRepository userRepository;

    @Mock
    private FirebaseAuth firebaseAuth;

    @InjectMocks
    private UserServiceImpl userService;

    User testUser = new User()
        .setId("test_id")
        .setEmail("test_email@gmail.com")
        .setUsername("test_username")
        .setFirstName("test_firstName")
        .setLastName("test_lastName");

    NewUserRequest testNewUser = new NewUserRequest(
        testUser.getEmail(),
        testUser.getUsername(),
        "test_Password"
    );

    @BeforeEach
    public void init() throws FirebaseAuthException {

        when(userRepository.save(any(User.class))).thenReturn(Mono.just(testUser));
        when(userRepository.findById(testUser.getId())).thenReturn(Mono.just(testUser));
        when(userRepository.findById("invalid_id")).thenReturn(Mono.empty());
        when(userRepository.existsById(testUser.getId())).thenReturn(Mono.just(true));
        when(userRepository.existsById("invalid_id")).thenReturn(Mono.just(false));
        when(userRepository.findByUsername(testNewUser.getUsername())).thenReturn(Flux.empty());
        when(userRepository.findByEmail(testNewUser.getEmail())).thenReturn(Flux.empty());
        when(userFactory.createUser(any(NewUserRequest.class))).thenReturn(testUser.getId());
        when(firebaseAuth.createUser(any())).thenReturn(null);
    }

    @Test
    public void addUser_userIsValid_userId(){

        String userId = userService.addUser(testUser);
        assertEquals(userId, testUser.getId());
    }

    @Test
    public void addUser_newUserRequestIsValid_userId() throws InvalidNewUserException {

        String userId = userService.addUser(testNewUser);
        assertEquals(userId, testUser.getId());
    }

    @Test
    public void getUser_userIdExists_user() throws InvalidUserException{

        User user = userService.getUser(testUser.getId());
        assertEquals(user, testUser);
    }

    @Test
    public void getUser_userIdNotExists_null() throws InvalidUserException{

        assertThrows(InvalidUserException.class, () -> userService.getUser("invalid_id"));
    }

    @Test
    public void isUserExists_userIdExists_true(){

        assertTrue(userService.isUserExists(testUser.getId()));
    }

    @Test
    public void isUserExists_userIdNotExists_false(){

        assertFalse(userService.isUserExists("invalid_id"));
    }
}
