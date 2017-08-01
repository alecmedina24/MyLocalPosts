package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.google.gson.annotations.Expose;

/**
 * Created by alec.medina on 7/28/17.
 */

public class User {

    @Expose
    private String username;
    @Expose
    private String profilePicture;
    @Expose
    private String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
