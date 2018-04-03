package com.example.kevin.logindemo;

/**
 * Created by Kevin on 3/23/2018.
 */

public abstract class Person {
    private String first_name;
    private String last_name;
    private String login_name;
    private String password;
    private boolean account_state;
    private int gender;
    private String contact_info;

    public Person(){

    }

    /**
     * creates person
     *
     * @param login_name
     * @param password
     */
    public Person (String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }

    /**
     * creates a person
     *
     * @param login_name
     * @param password
     * @param first_name
     * @param last_name
     * @param gender
     * @param contact_info
     */
    public Person (String login_name, String password, String first_name, String last_name,
                   int gender, String contact_info) {
        this.login_name = login_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.contact_info = contact_info;
    }
}
