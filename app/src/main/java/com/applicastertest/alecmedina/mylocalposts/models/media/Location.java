package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class Location {

    @SerializedName("latitude")
    public abstract Double latitude();
    @SerializedName("id")
    public abstract String id();
    @SerializedName("longitude")
    public abstract Double longitude();
    @SerializedName("name")
    public abstract String name();
}
