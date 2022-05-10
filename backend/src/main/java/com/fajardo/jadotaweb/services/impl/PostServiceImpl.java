package com.fajardo.jadotaweb.services.impl;

import java.util.Date;
import java.util.List;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.entities.User;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.repositories.PostRepository;
import com.fajardo.jadotaweb.services.PostService;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    UserService userService;

    @Autowired
    public PostServiceImpl(
        PostRepository postRepository, 
        UserService userService
    ) {

        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public String createPost(Post post) {
        
        return this.postRepository.save(post).block().getId();
    }

    @Override
    public String createPost(PostsRequest post, String userId) {

        // Get user details first
        User user = userService.getUser(userId);

        return this.postRepository.save(transformRequest(post, user)).block().getId();
    }

    @Override
    public Post getPost(String postId) {
        
        return this.postRepository.findById(postId).block();
    }

    @Override
    public Flux<Post> getPosts() {
        
        return this.postRepository.findAll();
    }

    private Post transformRequest(PostsRequest post, User user){

        Post postDao = new Post(
            post.getTitle(), 
            new Date(), 
            user.getId(), 
            1, 
            post.getCoverImgUrl(), 
            post.getText()
        );

        return postDao;
    }
}
