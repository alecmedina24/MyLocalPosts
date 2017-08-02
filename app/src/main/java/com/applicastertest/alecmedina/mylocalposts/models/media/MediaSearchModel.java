package com.applicastertest.alecmedina.mylocalposts.models.media;

import android.support.annotation.Nullable;

import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoGson;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alec.medina on 7/28/17.
 */

@AutoValue @AutoGson
public abstract class MediaSearchModel {

    @SerializedName("data")
    public abstract @Nullable List<MediaData> data();
}
