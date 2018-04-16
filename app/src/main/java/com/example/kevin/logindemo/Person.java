package com.example.kevin.logindemo;

/**
 * Created by Kevin on 3/23/2018.
 * Generic person parent class
 */

abstract class Person {
    private String first_name;
    private String last_name;
    private String login_name;
    private String password;
    private boolean account_state;
    private int gender;
    private String contact_info;

    Person(){

    }

    /**
     * creates person
     *
     * @param login_name the login name of the user
     * @param password the password of the user
     */
    Person(String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }

    /**
     * creates a person
     *
     * @param login_name the login name of the person
     * @param password the password of the person
     * @param first_name the first name of the person
     * @param last_name the last name of the person
     * @param gender the gender of the person
     * @param contact_info the contact information of the person
     */
    Person(String login_name, String password, String first_name, String last_name,
           int gender, String contact_info) {
        this.login_name = login_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.contact_info = contact_info;
    }
}
