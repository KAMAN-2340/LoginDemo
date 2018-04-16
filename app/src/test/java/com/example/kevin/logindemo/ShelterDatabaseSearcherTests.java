package com.example.kevin.logindemo;

import com.example.kevin.logindemo.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShelterDatabaseSearcherTests {
    private List<Shelter> shelterList;
    private List<Shelter> emptyList;


    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        String restrictionFamilies = "Families";
        String restrictionAnyone = "Anyone";
        String restrictionMale = "Men";
        String restrictionFemale = "Women";
        String restrictionNewborn = "Newborn";
        String restrictionChildren = "Children";
        String restrictionYoungAdults = "Young Adults";

        shelterList = new ArrayList<>();

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionFamilies, "Nick's Crib",
                "The coolest crib", 0, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionAnyone, "Nick's Crib",
                "The coolest crib", 1, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionMale, "Nick's Crib",
                "The coolest crib", 2, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionFemale, "Nick's Crib",
                "The coolest crib", 3, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionNewborn, "Nick's Crib",
                "The coolest crib", 4, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionChildren, "Nick's Crib",
                "The coolest crib", 5, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionYoungAdults, "Nick's Crib",
                "The coolest crib", 6, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionAnyone, "Nick's Crib",
                "The coolest crib", 7, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionFamilies, "Nick's Crib",
                "The coolest crib", 8, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", restrictionYoungAdults, "Nick's Crib",
                "The coolest crib", 9, 200));

        shelterList.add(new Shelter("123 Crayola Rd", "200", 40, -300,
                "555-555-5555", "", "Nick's Crib",
                "The coolest crib", 10, 200));

    }

//Kevin Nguyen YoungAdults Test
    @Test(timeout = TIMEOUT)
    public void searchForYoungAdultEmpty() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchYoungAdults(emptyList);
        assertEquals(0, filteredList.size());
    }

    @Test(timeout = TIMEOUT)
    public void searchForYoungAdultContains() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchYoungAdults(shelterList);
        assertEquals(5, filteredList.size());
//        assertEquals(6, filteredList.get(0).getKey());
//        assertEquals(9, filteredList.get(1).getKey());
    }

    @Test(timeout = TIMEOUT)
    public void searchForYoungAdultDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchYoungAdults(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
    }


 //Amani Konduru Family Test
    @Test(timeout = TIMEOUT)
    public void searchForFamilyEmpty() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFamily(emptyList);
        assertEquals(0, filteredList.size());
    }

    @Test(timeout = TIMEOUT)
    public void searchForFamilyContains() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFamily(shelterList);
        assertEquals(5, filteredList.size());

        assertEquals(0, filteredList.get(0).getKey());
        assertEquals(1, filteredList.get(1).getKey());
        assertEquals(7, filteredList.get(2).getKey());
        assertEquals(8, filteredList.get(3).getKey());
        assertEquals(10, filteredList.get(4).getKey());
    }

    @Test(timeout = TIMEOUT)
    public void searchForFamilyDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFamily(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
    }

    //Nick SearchAnyone
    @Test(timeout = TIMEOUT)
    public void searchForAnyoneEmpty() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchAnyone(emptyList);
        assertEquals(0, filteredList.size());
    }

    @Test(timeout = TIMEOUT)
    public void searchForAnyoneContains() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchAnyone(shelterList);
        assertEquals(3, filteredList.size());

        assertEquals(1, filteredList.get(0).getKey());
        assertEquals(7, filteredList.get(1).getKey());
        assertEquals(10, filteredList.get(2).getKey());
    }

    @Test(timeout = TIMEOUT)
    public void searchForAnyoneDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchYoungAdults(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
        removed = shelterList.remove(filteredList.get(1));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(1)));
    }

 //Allana SearchFemale
    @Test(timeout = TIMEOUT)
    public void searchByFemaleEmpty() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFemale(emptyList);
        assertEquals(0, filteredList.size());
    }


    @Test(timeout = TIMEOUT)
    public void searchForFemaleContains() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFemale(shelterList);
        assertEquals(11, filteredList.size());

        assertEquals(0, filteredList.get(0).getKey()); //anyone
        assertEquals(1, filteredList.get(1).getKey()); //female
        assertEquals(3, filteredList.get(2).getKey()); //anyone
        assertEquals(5, filteredList.get(4).getKey()); //nothing
    }


    @Test(timeout = TIMEOUT)
    public void searchForFemaleDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFemale(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
    }

//Madison SearchChildren

    @Test(timeout = TIMEOUT)
    public void searchByChildrenEmpty() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchChildren(emptyList);
        assertEquals(0, filteredList.size());
    }


@Test(timeout = TIMEOUT)
    public void searchForChildrenContains() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchChildren(shelterList);
        assertEquals(4, filteredList.size());

        assertEquals(1, filteredList.get(0).getKey()); //anyone
        assertEquals(5, filteredList.get(1).getKey()); //children
        assertEquals(7, filteredList.get(2).getKey()); //anyone
        assertEquals(10, filteredList.get(3).getKey()); //nothing
    }


@Test(timeout = TIMEOUT)
    public void searchForChildrenDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchChildren(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
    }
}
