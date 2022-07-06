package com.fajardo.jadotaweb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fajardo.jadotaweb.models.submissions.SubmissionRequest;
import com.fajardo.jadotaweb.models.submissions.SubmissionResponse;
import com.fajardo.jadotaweb.services.SubmissionService;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("${api.base}/submissions")
public class SubmissionController {
    
    SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService){

        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(
        @Valid @RequestBody SubmissionRequest submission, 
        Authentication authentication
    ){

        ResponseEntity<SubmissionResponse> response = null;

        // TODO Add try catch here when Exception is created
        var createdSubmission = this.submissionService.createSubmission(
            submission, 
            authentication.getPrincipal().toString()
        );

        response = ResponseEntity.ok(
            new SubmissionResponse(
                createdSubmission.getId(), 
                "Create Submission Success"
            )
        );

        return response;
    }
}
