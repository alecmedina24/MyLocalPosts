package com.applicastertest.alecmedina.mylocalposts.models.location;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alec.medina on 7/27/17.
 */

@AutoValue @AutoGson
public abstract class LocationData {

    @SerializedName("id")
    public abstract String id();
    @SerializedName("latitude")
    public abstract Double latitude();
    @SerializedName("longitude")
    public abstract Double longitude();
    @SerializedName("name")
    public abstract String name();
}
