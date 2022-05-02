package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.dao.Post;
import com.fajardo.jadotaweb.models.posts.PostsRequest;

public interface PostService {
    
    public String createPost(Post post);
    public String createPost(PostsRequest post);
    public Post getPost(String postId);
}
