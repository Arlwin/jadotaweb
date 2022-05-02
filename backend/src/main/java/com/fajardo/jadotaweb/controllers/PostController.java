package com.fajardo.jadotaweb.controllers;

import java.util.List;

import com.fajardo.jadotaweb.dao.Post;
import com.fajardo.jadotaweb.dao.User;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.models.posts.PostsResponse;
import com.fajardo.jadotaweb.services.PostService;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

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
    public ResponseEntity<String> createPost(@RequestBody PostsRequest post){

        String postId = postService.createPost(post);

        return ResponseEntity.ok(postId);
    }
}
