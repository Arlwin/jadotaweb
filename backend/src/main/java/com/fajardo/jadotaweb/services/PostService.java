package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.dao.Post;
import com.fajardo.jadotaweb.models.posts.PostsRequest;

import reactor.core.publisher.Flux;

public interface PostService {
    
    // Create
    public String createPost(Post post);
    public String createPost(PostsRequest post);

    // Read
    public Post getPost(String postId);
    public Flux<Post> getPosts();

    // Update

    // Delete
}
