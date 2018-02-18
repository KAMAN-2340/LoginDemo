package com.example.kevin.logindemo;

import java.util.HashMap;

/**
 * Created by Nick on 2/18/2018.
 */

public class Admins {

    HashMap<String, String> admins;

    public Admins() {
        admins = new HashMap<>();
    }

    public void add(String name, String password) {
        admins.put(name, password);
    }

    public boolean contains(String name, String password) {
        if (admins.containsKey(name)) {
            return admins.get(name).equals(password);
        }
        return false;
    }
}
