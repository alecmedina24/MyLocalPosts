package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.google.gson.annotations.Expose;

/**
 * Created by alec.medina on 7/28/17.
 */

public class Images {

    @Expose
    private LowResolution lowResolution;
    @Expose
    private Thumbnail thumbnail;
    @Expose
    private StandardResolution standardResolution;

    public LowResolution getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public StandardResolution getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolution standardResolution) {
        this.standardResolution = standardResolution;
    }
}
