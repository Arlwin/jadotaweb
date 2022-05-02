package com.fajardo.jadotaweb.repositories;

import com.fajardo.jadotaweb.dao.Post;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface PostRepository extends FirestoreReactiveRepository<Post> {
    
}
