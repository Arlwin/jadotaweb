package com.fajardo.jadotaweb.controllers;

import java.security.Principal;
import java.util.List;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.models.posts.PostsResponse;
import com.fajardo.jadotaweb.models.security.SecurityUser;
import com.fajardo.jadotaweb.services.PostService;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class PostController {
    
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
        User user = userService.getUser(post.getUserId());

        if (post == null || user == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new PostsResponse(post, user));
    }

    @PostMapping()
    public ResponseEntity<String> createPost(@RequestBody PostsRequest post, Authentication authentication){
        
        String postId = postService.createPost(post, ((SecurityUser) authentication.getPrincipal()).getId());

        return ResponseEntity.ok(postId);
    }
}
