package com.fajardo.jadotaweb.dao;

import java.util.Date;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;

import org.springframework.cloud.gcp.data.firestore.Document;

@Document(collectionName = "posts")
public class Post {
    
    @DocumentId
    private String id;
    private String name;

    private String title;
    private Date submitDate;
    private String userId;
    private long likes;
    private String coverImgUrl;
    private String text;

    public Post(){}

    public Post(
        String title,
        Date submitDate,
        String userId,
        long likes,
        String coverImgUrl,
        String text
    ) {

        this.name = title.toLowerCase().replace(" ", "-");
        this.title = title;
        this.submitDate = submitDate;
        this.userId = userId;
        this.likes = likes;
        this.coverImgUrl = coverImgUrl;
        this.text = text;
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

    @PropertyName("postedBy")
    public String getUserId() {
        return userId;
    }

    @PropertyName("postedBy")
    public void setUserId(String userId) {
        this.userId = userId;
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
