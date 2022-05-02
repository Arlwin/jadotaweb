package com.fajardo.jadotaweb.repositories;

import com.fajardo.jadotaweb.dao.User;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface UserRepository extends FirestoreReactiveRepository<User>{
    
}
