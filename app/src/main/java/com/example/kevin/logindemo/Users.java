package com.example.kevin.logindemo;

/**
 * Created by Nick on 2/12/2018.
 */

class Users {

    private String Email;
    private int roomsReserved;
    private String shelterReserved;
    private long shelterId;

    /**
     * creates a user
     */
    public Users() {

    }

    /**
     * creates a user
     * @param email the email of the user
     */
    public Users(String email) {
        this.Email = email;
        roomsReserved = 0;
        shelterReserved = "none";
    }

    /**
     * creates a user
     *
     * @param email email of the user
     * @param roomsReserved number of rooms the user has reserved
     * @param shelterReserved the shelter the user has reserved
     */
    public Users(String email, int roomsReserved, String shelterReserved) {
        this.Email = email;
        this.roomsReserved = roomsReserved;
        this.shelterReserved = shelterReserved;
    }

    /**
     * getter that returns the shelter reserved
     *
     * @return the shelter returned
     */
    public String getShelterReserved() {
        return this.shelterReserved;
    }

    /**
     * getter that returns the email of the user
     *
     * @return the email of the user
     */
    public String getEmail() {
        return this.Email;
    }

    /**
     * getter that returns the number of rooms reserved by the user
     *
     * @return the number of rooms reserved by the user
     */
    public int getRoomsReserved() {
        return this.roomsReserved;
    }

    /**
     * returns the shelter id
     *
     * @return the shelter id
     */
    public long getShelterId() {
        return shelterId;
    }

    /**
     * sets the shelter id
     * @param id the shelter id
     */
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
