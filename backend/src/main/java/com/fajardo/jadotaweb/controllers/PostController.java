package com.fajardo.jadotaweb.controllers;

import javax.validation.Valid;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.models.posts.CreatePostResponse;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.models.posts.PostsResponse;
import com.fajardo.jadotaweb.services.PostService;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController()
@RequestMapping("${api.base}/posts")
public class PostController extends BaseController {
    
    PostService postService;
    UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {

        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping()
    public Flux<Post> getPosts(){

        return postService.getPosts();
    }


    @GetMapping("/{postId}")
    public ResponseEntity<PostsResponse> getPost(@PathVariable String postId){

        Post post = postService.getPost(postId);
        
        if (post == null) return ResponseEntity.notFound().build();

        User user = null;
        try {

            user = userService.getUser(post.getUserId());
        } catch (InvalidUserException e){

            user = null;
        }

        return ResponseEntity.ok(new PostsResponse(post, user));
    }

    @PostMapping()
    public ResponseEntity<CreatePostResponse> createPost(@Valid @RequestBody PostsRequest post, Authentication authentication){
        
        ResponseEntity<CreatePostResponse> resEntity = null;

        try {

            String postId = postService.createPost(post, authentication.getPrincipal().toString());
            resEntity = ResponseEntity.ok(
                new CreatePostResponse(postId, "Create Post Success")
            );
        } catch (InvalidUserException e) {

            resEntity = ResponseEntity.badRequest().body(new CreatePostResponse(null, "Post Creation Fail: " + e.getMessage()));
        }

        return resEntity;
    }
}
