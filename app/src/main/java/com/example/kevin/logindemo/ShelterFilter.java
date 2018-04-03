package com.example.kevin.logindemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 4/3/2018.
 */

public class ShelterFilter {

    protected static List<Shelter> filter(CharSequence charSequence, List<Shelter> shelters) {
        List<Shelter> filteredShelters = new ArrayList<>();
        String charSequenceString = charSequence.toString().toLowerCase();
        if (charSequenceString.isEmpty()) {
            filteredShelters = shelters;
        } else {
            if (charSequenceString.equals("male")) {
                filteredShelters = ShelterDatabaseSearcher.searchMale(shelters);
            } else if (charSequenceString.equals("female")) {
                filteredShelters = ShelterDatabaseSearcher.searchFemale(shelters);
            } else if (charSequenceString.equals("newborn")){
                filteredShelters = ShelterDatabaseSearcher.searchNewborn(shelters);
            } else if (charSequenceString.equals("family") || charSequence.equals("families")) {
                filteredShelters = ShelterDatabaseSearcher.searchFamily(shelters);
            } else if (charSequenceString.equals("families with newborns")) {
                filteredShelters = ShelterDatabaseSearcher.searchFamiliesWithNewborns(shelters);
            } else if (charSequenceString.equals("children")) {
                filteredShelters = ShelterDatabaseSearcher.searchChildren(shelters);
            } else if (charSequenceString.equals("young adults")) {
                filteredShelters = ShelterDatabaseSearcher.searchYoungAdults(shelters);
            } else if (charSequenceString.equals("anyone")) {
                filteredShelters = ShelterDatabaseSearcher.searchAnyone(shelters);
            } else {
                filteredShelters = ShelterDatabaseSearcher.searchByName(shelters, charSequenceString);
            }
        }
        return filteredShelters;
    }
}
