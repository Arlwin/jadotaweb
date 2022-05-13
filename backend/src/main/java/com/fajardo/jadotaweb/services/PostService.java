package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.exceptions.user.InvalidUserException;
import com.fajardo.jadotaweb.models.posts.PostsRequest;

import reactor.core.publisher.Flux;

public interface PostService {
    
    // Create
    public String createPost(Post post);
    public String createPost(PostsRequest post, String userId) throws InvalidUserException;

    // Read
    public Post getPost(String postId);
    public Flux<Post> getPosts();

    // Update

    // Delete
}
