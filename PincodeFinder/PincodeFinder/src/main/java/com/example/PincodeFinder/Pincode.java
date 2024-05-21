package com.example.PincodeFinder;

public class Pincode {
    public String lat;
    public String lng;
    public String District;
    public String State;
    public String Pincode;
    private String Area;

    
    public Pincode(String lat, String lng, String district, String state, String pincode, String area) {
        this.lat = lat;
        this.lng = lng;
        District = district;
        State = state;
        Pincode = pincode;
        Area = area;
    }

    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getDistrict() {
        return District;
    }
    public void setDistrict(String district) {
        District = district;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getPincode() {
        return Pincode;
    }
    public void setPincode(String pincode) {
        Pincode = pincode;
    }
    public String getArea() {
        return Area;
    }
    public void setArea(String area) {
        Area = area;
    }

    @Override
    public String toString() {
        return "Pincode [lat=" + lat + ", lng=" + lng + ", District=" + District + ", State=" + State + ", Pincode="
                + Pincode + ", Area=" + Area + "]";
    }

    
}