package com.applicastertest.alecmedina.mylocalposts.models.media;

import android.location.Location;
import android.support.annotation.Nullable;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class MediaData {

    @SerializedName("type")
    public abstract String type();
    @SerializedName("usersInPhoto")
    public abstract @Nullable List<Object> usersInPhoto();
    @SerializedName("filter")
    public abstract String filter();
    @SerializedName("tags")
    public abstract @Nullable List<String> tags();
    @SerializedName("comments")
    public abstract Comments comments();
    @SerializedName("caption")
    public abstract Caption caption();
    @SerializedName("likes")
    public abstract Likes likes();
    @SerializedName("link")
    public abstract String link();
    @SerializedName("user")
    public abstract User user();
    @SerializedName("createdTime")
    public abstract String createdTime();
    @SerializedName("images")
    public abstract Images images();
    @SerializedName("userHasLiked")
    public abstract Boolean userHasLiked();
    @SerializedName("id")
    public abstract String id();
    @SerializedName("location")
    public abstract Location location();
}
