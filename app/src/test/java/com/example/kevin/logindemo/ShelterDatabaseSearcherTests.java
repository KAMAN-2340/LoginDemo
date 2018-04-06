
import com.example.kevin.logindemo.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;


public class ShelterDatabaseSearcherTests {
    private List<Shelter> shelterList;
    private List<Shelter> emptyList;

    private String restrictionFamilies;
    private String restrictionAnyone;
    private String restrictionMale;
    private String restrictionFemale;
    private String restrictionNewborn;
    private String restrictionChildren;
    private String restrictionYoungAdults;



    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        restrictionFamilies = "Families";
        restrictionAnyone = "Anyone";
        restrictionMale = "Men";
        restrictionFemale = "Women";
        restrictionNewborn = "Newborn";
        restrictionChildren = "Children";
        restrictionYoungAdults = "Young Adults";

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

    }


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
        assertEquals(4, filteredList.size());
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
        assertEquals(4, filteredList.size());

        assertEquals(0, filteredList.get(0).getKey());
        assertEquals(1, filteredList.get(1).getKey());
        assertEquals(7, filteredList.get(2).getKey());
        assertEquals(8, filteredList.get(3).getKey());
    }

    @Test(timeout = TIMEOUT)
    public void searchForFamilyDoesntContain() {
        List<Shelter> filteredList =
                ShelterDatabaseSearcher.searchFamily(shelterList);
        boolean removed = shelterList.remove(filteredList.get(0));
        assertTrue(removed);
        assertFalse(shelterList.remove(filteredList.get(0)));
    }

}
