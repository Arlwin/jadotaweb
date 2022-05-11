package com.fajardo.jadotaweb.models.posts;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsRequest {
    
    @NotNull(message = "Title is required")
    private String title;

    private String coverImgUrl;

    @NotNull(message = "Text content is required")
    private String text;
}
