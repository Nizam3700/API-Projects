package org.example;

public class Address {
    String distance;
    String address;
    String subregion;
    String region;
    String postalcode;

    public Address(String distance, String address, String subregion, String region, String postalcode) {
        this.distance = distance;
        this.address = address;
        this.subregion = subregion;
        this.region = region;
        this.postalcode = postalcode;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        distance = distance;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSubregion() {
        return subregion;
    }
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getPostalcode() {
        return postalcode;
    }
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    @Override
    public String toString() {
        return "Address [Distance=" + distance + ", address=" + address + ", subregion=" + subregion + ", region="
                + region + ", postalcode=" + postalcode + "]";
    }

    
}
