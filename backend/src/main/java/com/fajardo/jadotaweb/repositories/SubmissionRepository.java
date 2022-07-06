package com.fajardo.jadotaweb.repositories;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import com.fajardo.jadotaweb.entities.Submission;

public interface SubmissionRepository extends FirestoreReactiveRepository<Submission> {
    
}