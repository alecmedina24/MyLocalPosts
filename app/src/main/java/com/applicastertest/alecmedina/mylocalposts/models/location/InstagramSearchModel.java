package com.applicastertest.alecmedina.mylocalposts.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by alec.medina on 7/27/17.
 */

public class InstagramSearchModel {

    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
