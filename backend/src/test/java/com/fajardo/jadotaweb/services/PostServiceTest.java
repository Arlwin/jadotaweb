package com.fajardo.jadotaweb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.repositories.PostRepository;
import com.fajardo.jadotaweb.services.impl.PostServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
public class PostServiceTest {
    
    @Mock
    PostRepository postRepository;

    @Mock
    UserService userService;

    @InjectMocks
    PostServiceImpl postService;

    Date currentDate = new Date();

    User testUser = User.builder()
        .id("testUserId")
        .email("testEmail")
        .username("testUsername")
        .password("testPassword")
        .build();

    Post testPost = new Post(
        "testId",
        "testtitle",
        "testTitle",
        currentDate,
        testUser.getId(),
        1,
        "testCoverImgUrl",
        "testText"
    );

    PostsRequest testPostRequest = new PostsRequest(
        testPost.getTitle(), 
        testPost.getCoverImgUrl(), 
        testPost.getText()
    );

    @BeforeEach
    public void init() throws InvalidUserException {

        when(postRepository.save(testPost)).thenReturn(Mono.just(testPost));
        when(postRepository.save(any(Post.class))).thenReturn(Mono.just(testPost));
        when(postRepository.findById(testPost.getId())).thenReturn(Mono.just(testPost));
        when(postRepository.findById("invalid_post")).thenReturn(Mono.empty());

        when(userService.getUser(testPost.getUserId())).thenReturn(testUser);
    }

    @Test
    public void createPost_validPost_postId() {

        String postId = postService.createPost(testPost);
        assertEquals(testPost.getId(), postId);
    }

    @Test
    public void createPost_validPostRequestAndValidUserId_postId() throws InvalidUserException {

        String postId = postService.createPost(testPostRequest, testUser.getId());
        assertEquals(testPost.getId(), postId);
    }

    @Test
    public void transformRequest_validPostAndValidUser_post() {

        Post post = postService.transformRequest(testPostRequest, testUser, currentDate);

        // Assume post already has an ID (for equals method to work)
        post.setId(testPost.getId());

        assertEquals(testPost, post);
    }

    @Test
    public void getPost_validPostId_post() {
        assertEquals(testPost, postService.getPost(testPost.getId()));
    }

    @Test
    public void getPost_invalidPostId_null() {
        assertNull(postService.getPost("invalid_post"));
    }
}
