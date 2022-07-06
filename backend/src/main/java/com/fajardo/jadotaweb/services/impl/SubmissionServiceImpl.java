package com.fajardo.jadotaweb.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fajardo.jadotaweb.entities.Submission;
import com.fajardo.jadotaweb.models.submissions.SubmissionRequest;
import com.fajardo.jadotaweb.repositories.SubmissionRepository;
import com.fajardo.jadotaweb.services.SubmissionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubmissionServiceImpl implements SubmissionService {

    SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {

        this.submissionRepository = submissionRepository;
    }

    @Override
    public Submission createSubmission(SubmissionRequest submission, String userId) {

        Date submitDate = new Date();

        log.info("Create new submission for {}", userId);

        Submission createdSubmission = new Submission(submission);
        createdSubmission.setSubmitDate(submitDate);
        createdSubmission.setUserId(userId);
        
        createdSubmission = submissionRepository.save(createdSubmission).block();

        log.info("Created new submission {}, for {}", createdSubmission.getId(), userId);

        return createdSubmission;
    }
}
