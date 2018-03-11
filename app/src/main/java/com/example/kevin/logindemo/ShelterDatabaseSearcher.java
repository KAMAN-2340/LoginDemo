package com.example.kevin.logindemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 3/5/2018.
 */

public class ShelterDatabaseSearcher {

    public static List<Shelter> searchMale(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (!restrictions.contains("women")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchFemale(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions();
            if (restrictions.contains("Women") || restrictions.contains("women")) {
                newFilteredList.add(sh);
            } else if (!restrictions.contains("Men")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchFamily(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("families")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchNewborn(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("newborn")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchFamiliesWithNewborns(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("newborn") || restrictions.contains("families")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchChildren(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("children")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchYoungAdults(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("young adults")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchAnyone(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.length() == 0) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    public static List<Shelter> searchByName(List<Shelter> shelters, String name) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String shName = sh.getName().toLowerCase();
            if (shName.contains(name)) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }
}
