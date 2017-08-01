package com.applicastertest.alecmedina.mylocalposts.models;

/**
 * Created by alec.medina on 7/28/17.
 */

public class PostModel {

    private String userName;
    private String userComment;
    private String postImage;
    private String userImage;

    public PostModel(String userName, String userComment, String postImage, String userImage) {
        this.userName = userName;
        this.userComment = userComment;
        this.postImage = postImage;
        this.userImage = userImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserComment() {
        return userComment;
    }

    public String getPostImage() {
        return postImage;
    }
}
