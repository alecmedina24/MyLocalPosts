package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class From {

    @SerializedName("username")
    public abstract String username();
    @SerializedName("fullname")
    public abstract String fullName();
    @SerializedName("type")
    public abstract String type();
    @SerializedName("id")
    public abstract String id();
}
