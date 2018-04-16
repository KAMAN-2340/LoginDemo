package com.example.kevin.logindemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 4/3/2018.
 * Filter class that selects which search to be done
 */

class ShelterFilter {

    static List<Shelter> filter(CharSequence charSequence, List<Shelter> shelters) {
        List<Shelter> filteredShelters = new ArrayList<>();
        String charSequenceString = charSequence.toString().toLowerCase();
        if (charSequenceString.isEmpty()) {
            filteredShelters = shelters;
        } else {
            if ("male".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchMale(shelters);
            } else if ("female".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchFemale(shelters);
            } else if ("newborn".equals(charSequenceString)){
                filteredShelters = ShelterDatabaseSearcher.searchNewborn(shelters);
            } else if ("family".equals(charSequenceString) || "families".equals(charSequence)) {
                filteredShelters = ShelterDatabaseSearcher.searchFamily(shelters);
            } else if ("families with newborns".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchFamiliesWithNewborns(shelters);
            } else if ("children".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchChildren(shelters);
            } else if ("young adults".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchYoungAdults(shelters);
            } else if ("anyone".equals(charSequenceString)) {
                filteredShelters = ShelterDatabaseSearcher.searchAnyone(shelters);
            } else {
                filteredShelters = ShelterDatabaseSearcher.searchByName(shelters,
                        charSequenceString);
            }
        }
        return filteredShelters;
    }
}
