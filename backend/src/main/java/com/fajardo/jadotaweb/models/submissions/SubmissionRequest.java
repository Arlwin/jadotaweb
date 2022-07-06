package com.fajardo.jadotaweb.models.submissions;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fajardo.jadotaweb.models.skills.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest {
    
    @NotNull(message = "Name is required")
    private String heroName;

    @NotNull(message = "Cover Images are required")
    private List<String> coverImgUrls;

    @NotNull(message = "Description is required")
    private String description;

    @NotEmpty(message = "Skills should not be empty")
    private List<Skill> skills;
}
