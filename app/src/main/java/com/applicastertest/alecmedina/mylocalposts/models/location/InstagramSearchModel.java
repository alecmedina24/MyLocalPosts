package com.applicastertest.alecmedina.mylocalposts.models.location;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by alec.medina on 7/27/17.
 */

public class InstagramSearchModel {

    @Expose
    private List<LocationData> data = null;

    public List<LocationData> getData() {
        return data;
    }

    public void setData(List<LocationData> data) {
        this.data = data;
    }

}
