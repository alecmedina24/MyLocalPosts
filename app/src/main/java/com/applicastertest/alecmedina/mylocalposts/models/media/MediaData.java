package com.applicastertest.alecmedina.mylocalposts.models.media;

import android.location.Location;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by alec.medina on 7/28/17.
 */

public class MediaData {

    @Expose
    private String type;
    @Expose
    private List<Object> usersInPhoto = null;
    @Expose
    private String filter;
    @Expose
    private List<String> tags = null;
    @Expose
    private Comments comments;
    @Expose
    private Caption caption;
    @Expose
    private Likes likes;
    @Expose
    private String link;
    @Expose
    private User user;
    @Expose
    private String createdTime;
    @Expose
    private Images images;
    @Expose
    private Boolean userHasLiked;
    @Expose
    private String id;
    @Expose
    private Location location;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getUsersInPhoto() {
        return usersInPhoto;
    }

    public void setUsersInPhoto(List<Object> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Boolean getUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(Boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
