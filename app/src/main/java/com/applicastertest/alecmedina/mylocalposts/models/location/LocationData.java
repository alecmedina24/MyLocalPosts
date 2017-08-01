package com.applicastertest.alecmedina.mylocalposts.models.location;

import com.google.gson.annotations.Expose;

/**
 * Created by alec.medina on 7/27/17.
 */

public class LocationData {

    @Expose
    private String id;
    @Expose
    private Double latitude;
    @Expose
    private Double longitude;
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
