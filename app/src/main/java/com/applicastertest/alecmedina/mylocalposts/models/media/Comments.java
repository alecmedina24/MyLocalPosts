package com.applicastertest.alecmedina.mylocalposts.models.media;

import com.google.gson.annotations.Expose;

/**
 * Created by alec.medina on 7/28/17.
 */

public class Comments {

    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
