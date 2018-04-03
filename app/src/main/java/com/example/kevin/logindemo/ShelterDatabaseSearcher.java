package com.example.kevin.logindemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 3/5/2018.
 */

public class ShelterDatabaseSearcher {

    /**
     * returns list of shelters that allow men
     *
     * @param shelters list of shelters
     * @return list of shelters that allow men
     */
    public static List<Shelter> searchMale(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (!restrictions.contains("women")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns list of shelter that allow women
     * @param shelters list of shelters
     * @return list of shelters that allow women
     */
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
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns list of shelters that allow families
     *
     * @param shelters list of shelters
     * @return list of shelters that allow families
     */
    public static List<Shelter> searchFamily(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("families")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns list of shelters that allow newborns
     *
     * @param shelters list of shelters
     * @return list of shelters that allow newborns
     */
    public static List<Shelter> searchNewborn(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("newborn")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns list of shelters that allow families with newborns
     *
     * @param shelters list of shelters
     * @return list of shelters that allow families with newborns
     */
    public static List<Shelter> searchFamiliesWithNewborns(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("newborn") || restrictions.contains("families")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns list of shelters that allow children
     *
     * @param shelters list of shelters
     * @return the list of shelters that allow children
     */
    public static List<Shelter> searchChildren(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("children")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns a list of shelters that allow young adults
     * @param shelters list of shelters
     * @return the list of shelters that allow young adults
     */
    public static List<Shelter> searchYoungAdults(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("young adults")) {
                newFilteredList.add(sh);
            }
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns a list of shelters that allow anyone
     * @param shelters list of shelters
     * @return list of shelters that allow anyone
     */
    public static List<Shelter> searchAnyone(List<Shelter> shelters) {
        ArrayList<Shelter> newFilteredList = new ArrayList<>();
        for (Shelter sh : shelters) {
            String restrictions = sh.getRestrictions().toLowerCase();
            if (restrictions.contains("anyone")) {
                newFilteredList.add(sh);
            } else if (restrictions.isEmpty()) {
                newFilteredList.add(sh);
            }
        }
        return newFilteredList;
    }

    /**
     * returns a specific shelter when searched by name
     * @param shelters list of shelters
     * @param name name of the shelter being searched
     * @return
     */
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
