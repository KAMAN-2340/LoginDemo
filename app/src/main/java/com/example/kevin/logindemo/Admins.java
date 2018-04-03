package com.example.kevin.logindemo;

import java.util.HashMap;

/**
 * Created by Nick on 2/18/2018.
 */

public class Admins extends Person{

    HashMap<String, String> admins;

     /**
     * Creates an admin
     *
     * @param login_name
     * @param password
     */
    public Admins(String login_name, String password) {
        super(login_name,password);
    }

    /**
     * Creates an admin
     *
     * @param login_name
     * @param password
     * @param first_name
     * @param last_name
     * @param gender
     * @param contact_info
     */
    public Admins (String login_name, String password, String first_name, String last_name,
                  int gender, String contact_info) {
        super(login_name, password, first_name, last_name, gender, contact_info);
    }


    /**
     * adds username and password and adds it to a hashmap
     *
     * @param name
     * @param password
     */
    public void add(String name, String password) {
        admins.put(name, password);
    }

    /**
     * returns if name and password is in the hashmap
     *
     * @param name
     * @param password
     * @return
     */
    public boolean contains(String name, String password) {
        if (admins.containsKey(name)) {
            return admins.get(name).equals(password);
        }
        return false;
    }
}
