package com.fajardo.jadotaweb.models.posts;

import java.util.Date;

import com.fajardo.jadotaweb.dao.Post;
import com.fajardo.jadotaweb.dao.User;

public class PostsResponse {
    
    private String id;
    private String name;

    private String title;
    private Date submitDate;
    private User user;
    private long likes;
    private String coverImgUrl;
    private String text;

    public PostsResponse(){}

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

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getSubmitDate() {
        return submitDate;
    }
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
    public User getUser() {
        return user;
    }
    public void setUserId(User user) {
        this.user = user;
    }
    public long getLikes() {
        return likes;
    }
    public void setLikes(long likes) {
        this.likes = likes;
    }
    public String getCoverImgUrl() {
        return coverImgUrl;
    }
    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    
}
