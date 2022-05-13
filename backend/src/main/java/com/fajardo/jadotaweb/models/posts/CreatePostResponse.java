package com.fajardo.jadotaweb.models.posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostResponse {
    
    private String id;
    private String message;
}
