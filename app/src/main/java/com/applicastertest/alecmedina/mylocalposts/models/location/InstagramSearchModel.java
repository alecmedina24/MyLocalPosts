package com.applicastertest.alecmedina.mylocalposts.models.location;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alec.medina on 7/27/17.
 */

@AutoValue @AutoGson
public abstract class InstagramSearchModel {

    @SerializedName("data")
    public abstract List<LocationData> data();

}
