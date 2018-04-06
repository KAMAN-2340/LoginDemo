package com.example.kevin.logindemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nick on 2/18/2018.
 */

class Admins extends Person{

    private Map<String, String> admins;

     /**
     * Creates an admin
     *
     * @param login_name the login name for the admin
     * @param password the password for the admin
     */
    public Admins(String login_name, String password) {
        super(login_name,password);
    }

    /**
     * Creates an admin
     *
     * @param login_name the login name of the admin
     * @param password the password of the admin
     * @param first_name the first name of the admin
     * @param last_name the last name of the admin
     * @param gender the gender of the admin
     * @param contact_info the contact information of the admin
     */
    public Admins (String login_name, String password, String first_name, String last_name,
                  int gender, String contact_info) {
        super(login_name, password, first_name, last_name, gender, contact_info);
    }


    /**
     * adds username and password and adds it to a hashmap
     *
     * @param name the name to be added to the hashmap
     * @param password the password to be added to the hashmap
     */
    public void add(String name, String password) {
        admins.put(name, password);
    }

    /**
     * returns if name and password is in the hashmap
     *
     * @param name the name to look for in the hashmap
     * @param password the password to look for in the hashmap
     * @return
     */
    public boolean contains(String name, String password) {
        return admins.containsKey(name) && admins.get(name).equals(password);
    }
}
