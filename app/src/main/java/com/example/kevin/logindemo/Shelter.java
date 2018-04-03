package com.example.kevin.logindemo;

import android.os.Parcel;
import android.os.Parcelable;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

/**
 * Created by Nick on 2/26/2018.
 * Unique Key,Shelter Name,Capacity,Restrictions,
 * Longitude,Latitude,Address,Special Notes,Phone Number
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

    /**
     * creates shelter
     *
     * @param info the shelter info
     */
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

    /**
     * creates shelter
     */
    public Shelter() {

    }

    /**
     * creates shelter
     *
     * @param address the address
     * @param capacity the capacity
     * @param latitude the latitude
     * @param longitude the longitude
     * @param phoneNumber the phone number
     * @param restrictions the restrictions
     * @param shelterName the name of the shelter
     * @param specialNotes the special notes
     * @param key the key
     * @param vacancy the vacancy
     */
    public Shelter (String address, String capacity, double latitude, double longitude,
                    String phoneNumber, String restrictions, String shelterName,
                    String specialNotes, long key, long vacancy) {
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

    /**
     * creates shelter
     *
     * @param parcel the parcel
     */
    public Shelter(Parcel parcel) {
        readFromParcel(parcel);
    }

    /**
     * returns key
     *
     * @return the key
     */
    public long getKey() {
        return key;
    }

    /**
     * sets key
     *
     * @param key the key
     */
    public void setKey(long key) {
        this.key = key;
    }

    /**
     * returns name of shelter
     *
     * @return the name of the shelter
     */
    public String getName() {
        return name;
    }

    /**
     * sets shelter name
     *
     * @param name the shelter name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return capacity
     *
     * @return the capacity of the shelter
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * sets capacity
     *
     * @param capacity the capacity of the shelter
     */
    public void setCapacity(int capacity) {
        this.capacity = "" + capacity;
    }

    /**
     * returns restrictions
     *
     * @return restrictions for the shelter
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     * sets restrictions
     *
     * @param restrictions the shelter's restrictions
     */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * returns longitude of the shelter
     *
     * @return the longitude of the shelter
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * sets the longitude of the shelter
     *
     * @param longitude the longitude of the shelter
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * returns latitude of the shelter
     *
     * @return the latitude of the shelter
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * sets the latitude of the shelter
     *
     * @param latitude the longitude of the shelter
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * gets the of the shelter
     *
     * @return address the longitude of the shelter
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets address of the shelter
     *
     * @param address the address of the shelter
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the special notes of the shelter
     *
     * @return the special notes
     */
    public String getSpecialNotes() {
        return specialNotes;
    }

    /**
     * sets the special notes of the shelter
     *
     * @param specialNotes the special notes of the shelter
     */
    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    /**
     * returns the phone number of the shelter
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * sets the phone number of the shelter
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * returns the vacancy of the shelter
     *
     * @return the vacancy
     */
    public long getVacancy() {
        return this.vacancy;
    }

    /**
     * sets the vacancy of the shelter
     *
     * @param n the vacancy
     */
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

    /**
     * reads the parcel
     *
     * @param parcel the parcel
     */
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
        @Override
        public Shelter createFromParcel(Parcel parcel) {
            return new Shelter(parcel);
        }

        @Override
        public Shelter[] newArray(int size) {
            return new Shelter[size];
        }
    };
}
