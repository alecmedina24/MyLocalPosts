package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class Caption {

    @SerializedName("createdTime")
    public abstract String createdTime();
    @SerializedName("text")
    public abstract String text();
    @SerializedName("from")
    public abstract From from();
    @SerializedName("id")
    public abstract String id();
}
