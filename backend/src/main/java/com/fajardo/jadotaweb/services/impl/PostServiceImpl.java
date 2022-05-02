package com.fajardo.jadotaweb.services.impl;

import java.util.Date;

import com.fajardo.jadotaweb.dao.Post;
import com.fajardo.jadotaweb.dao.User;
import com.fajardo.jadotaweb.models.posts.PostsRequest;
import com.fajardo.jadotaweb.repositories.PostRepository;
import com.fajardo.jadotaweb.services.PostService;
import com.fajardo.jadotaweb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String createPost(PostsRequest post) {

        return this.postRepository.save(transformRequest(post)).block().getId();
    }

    @Override
    public Post getPost(String postId) {
        
        return this.postRepository.findById(postId).block();
    }

    private Post transformRequest(PostsRequest post){

        if (!userService.isUserExists(post.getUserId())) return null;

        Post postDao = new Post(
            post.getTitle(), 
            new Date(), 
            post.getUserId(), 
            1, 
            post.getCoverImgUrl(), 
            post.getText()
        );

        return postDao;
    }
}
