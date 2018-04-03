package com.example.kevin.logindemo;

/**
 * Created by Nick on 2/12/2018.
 */

public class Users {

    private String Email;
    private int roomsReserved;
    private String shelterReserved;
    private long shelterId;

    public Users() {

    }

    public Users(String email) {
        this.Email = email;
        roomsReserved = 0;
        shelterReserved = "none";
    }
    public Users(String email, int roomsReserved, String shelterReserved) {
        this.Email = email;
        this.roomsReserved = roomsReserved;
        this.shelterReserved = shelterReserved;
    }

    public String getShelterReserved() {
        return this.shelterReserved;
    }

    public String getEmail() {
        return this.Email;
    }

    public int getRoomsReserved() {
        return this.roomsReserved;
    }

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long id) {
        this.shelterId = id;
    }

//    public Users(String login_name, String password) {
//        super(login_name,password);
//    }

//    public Users (String login_name, String password, String first_name, String last_name,
//                   int gender, String contact_info) {
//        super(login_name, password, first_name, last_name, gender, contact_info);
//    }

//    public void add(String email, String password) {
//        users.put(email, password);
//    }

//    public boolean contains(String email, String password) {
//        if (users.containsKey(email)) {
//            return users.get(email).equals(password);
//        }
//        return false;
//    }
}
