package com.fajardo.jadotaweb.entities;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.gcp.data.firestore.Document;

import com.fajardo.jadotaweb.models.skills.Skill;
import com.fajardo.jadotaweb.models.submissions.SubmissionRequest;
import com.google.cloud.firestore.annotation.DocumentId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collectionName = "submissions")
public class Submission {
    
    @DocumentId
    private String id;

    private String name;
    private List<String> coverImgUrls;
    private String description;
    private List<Skill> skills;

    // Metadata
    private Date submitDate;
    private String userId;
    private long likes = 0;

    public Submission(SubmissionRequest request) {

        this.name = request.getHeroName();
        this.coverImgUrls = request.getCoverImgUrls();
        this.description = request.getDescription();
        this.skills = request.getSkills();
    }
}
