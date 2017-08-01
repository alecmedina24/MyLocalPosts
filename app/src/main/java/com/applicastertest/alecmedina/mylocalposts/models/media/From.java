package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.google.gson.annotations.Expose;

/**
 * Created by alec.medina on 7/28/17.
 */

public class From {

    @Expose
    private String username;
    @Expose
    private String fullName;
    @Expose
    private String type;
    @Expose
    private String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
