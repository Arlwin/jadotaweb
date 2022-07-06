package com.fajardo.jadotaweb.models.submissions;

import com.fajardo.jadotaweb.models.http.HttpBaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SubmissionResponse extends HttpBaseResponse {
    
    public String submissionId;

    public SubmissionResponse(String submissionId, String message) {

        this.submissionId = submissionId;
        this.message = message;
    }
}
