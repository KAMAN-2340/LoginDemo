package com.example.kevin.logindemo;

import java.util.HashMap;

/**
 * Created by Nick on 2/12/2018.
 */

public class Users {

    HashMap<String, String> users;

    public Users() {
        users = new HashMap<>();
        users.put("admin", "admin");
    }

    public void add(String email, String password) {
        users.put(email, password);
    }

    public boolean contains(String email, String password) {
        if (users.containsKey(email)) {
            return users.get(email).equals(password);
        }
        return false;
    }
}
