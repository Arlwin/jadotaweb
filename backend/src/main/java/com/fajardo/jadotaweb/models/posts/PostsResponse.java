package com.fajardo.jadotaweb.models.posts;

import java.util.Date;

import com.fajardo.jadotaweb.entities.Post;
import com.fajardo.jadotaweb.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsResponse {
    
    private String id;
    private String name;

    private String title;
    private Date submitDate;
    private User user;
    private long likes;
    private String coverImgUrl;
    private String text;

    public PostsResponse(Post post, User user){

        this.id = post.getId();
        this.name = post.getName();
        this.title = post.getTitle();
        this.submitDate = post.getSubmitDate();
        this.user = user;
        this.likes = post.getLikes();
        this.coverImgUrl = post.getCoverImgUrl();
        this.text = post.getText();
    }
}
