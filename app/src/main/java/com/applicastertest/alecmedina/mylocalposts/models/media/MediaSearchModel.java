package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by alec.medina on 7/28/17.
 */

public class MediaSearchModel {

    @Expose
    private List<MediaData> data = null;

    public List<MediaData> getData() {
        return data;
    }

    public void setData(List<MediaData> data) {
        this.data = data;
    }
}
