package com.example.kevin.logindemo;

import android.os.Parcel;
import android.os.Parcelable;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * Created by Nick on 2/26/2018.
 * Unique Key,Shelter Name,Capacity,Restrictions,Longitude ,Latitude ,Address,Special Notes,Phone Number
 */

public class Shelter implements Parcelable {

    private long key;
    private String name;
    private String capacity;
    private String restrictions;
    private double longitude;
    private double latitude;
    private String address;
    private String specialNotes;
    private String phoneNumber;
    private long vacancy;

    public Shelter(String[] info) {
        key = parseLong(info[0]);
        name = info[1];
        capacity = info[2];
        restrictions = info[3];
        longitude = parseDouble(info[4]);
        latitude = parseDouble(info[5]);
        address = info[6];
        specialNotes = info[7];
        phoneNumber = info[8];
    }

    public Shelter() {

    }

    public Shelter (String address, String capacity, double latitude, double longitude, String phoneNumber,
                        String restrictions, String shelterName, String specialNotes, long key, long vacancy) {
        this.address = address;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.restrictions = restrictions;
        this.name = shelterName;
        this.specialNotes = specialNotes;
        this.key = key;
        this.vacancy = vacancy;
    }

    public Shelter(Parcel parcel) {
        readFromParcel(parcel);
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
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

    public void setCapacity(int capacity) {
        this.capacity = "" + capacity;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
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

    public long getVacancy() {
        return this.vacancy;
    }

    public void setVacancy(long n) {
        this.vacancy = n;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Long.toString(key));
        parcel.writeString(name);
        parcel.writeString(capacity);
        parcel.writeString(restrictions);
        parcel.writeString(Double.toString(longitude));
        parcel.writeString(Double.toString(latitude));
        parcel.writeString(address);
        parcel.writeString(specialNotes);
        parcel.writeString(phoneNumber);
    }

    private void readFromParcel(Parcel parcel) {
        key = parseLong(parcel.readString());
        name = parcel.readString();
        capacity = parcel.readString();
        restrictions = parcel.readString();
        longitude = parseDouble(parcel.readString());
        latitude = parseDouble(parcel.readString());
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
