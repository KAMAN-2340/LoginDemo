package com.example.kevin.logindemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nick on 2/26/2018.
 * Unique Key,Shelter Name,Capacity,Restrictions,Longitude ,Latitude ,Address,Special Notes,Phone Number
 */

public class Shelter implements Parcelable {

    private String key;
    private String name;
    private String capacity;
    private String restrictions;
    private String longitude;
    private String latitude;
    private String address;
    private String specialNotes;
    private String phoneNumber;
    private String vacancy;

    public Shelter(String[] info) {
        key = info[0];
        name = info[1];
        capacity = info[2];
        restrictions = info[3];
        longitude = info[4];
        latitude = info[5];
        address = info[6];
        specialNotes = info[7];
        phoneNumber = info[8];
    }

    public Shelter(Parcel parcel) {
        readFromParcel(parcel);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(name);
        parcel.writeString(capacity);
        parcel.writeString(restrictions);
        parcel.writeString(longitude);
        parcel.writeString(latitude);
        parcel.writeString(address);
        parcel.writeString(specialNotes);
        parcel.writeString(phoneNumber);
    }

    private void readFromParcel(Parcel parcel) {
        key = parcel.readString();
        name = parcel.readString();
        capacity = parcel.readString();
        restrictions = parcel.readString();
        longitude = parcel.readString();
        latitude = parcel.readString();
        address = parcel.readString();
        specialNotes = parcel.readString();
        phoneNumber = parcel.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Shelter createFromParcel(Parcel parcel) {
            return new Shelter(parcel);
        }

        public Shelter[] newArray(int size) {
            return new Shelter[size];
        }
    };
}
