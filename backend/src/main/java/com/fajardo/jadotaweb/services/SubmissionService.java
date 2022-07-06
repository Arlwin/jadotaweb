package com.fajardo.jadotaweb.services;

import com.fajardo.jadotaweb.entities.Submission;
import com.fajardo.jadotaweb.models.submissions.SubmissionRequest;

public interface SubmissionService {
    
    public Submission createSubmission(SubmissionRequest submission, String userId);
}
