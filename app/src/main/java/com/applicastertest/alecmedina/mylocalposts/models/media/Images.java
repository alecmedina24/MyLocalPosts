package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class Images {

    @SerializedName("lowResolution")
    public abstract LowResolution lowResolution();
    @SerializedName("thumbnail")
    public abstract Thumbnail thumbnail();
    @SerializedName("standardResolution")
    public abstract StandardResolution standardResolution();
}
