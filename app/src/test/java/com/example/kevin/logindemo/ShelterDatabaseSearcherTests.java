import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;


public class ShelterDatabaseSearcherTests {
    private List<Integer> shelterList;
    private List<Integer> emptyList;


    // public static List<Shelter> searchFamily(List<Shelter> shelters) {
    //     ArrayList<Shelter> newFilteredList = new ArrayList<>();
    //     for (Shelter sh : shelters) {
    //         String restrictions = sh.getRestrictions().toLowerCase();
    //         if (restrictions.contains("families")) {
    //             newFilteredList.add(sh);
    //         }
    //         if (restrictions.contains("anyone")) {
    //             newFilteredList.add(sh);
    //         } else if (restrictions.length() == 0) {
    //             newFilteredList.add(sh);
    //         }
    //     }
    //     return newFilteredList;
    // }

    private String restrictionFamilies;
    private String restrictionAnyone;
    private String restrictionMen;
    private String restrictionFemale;
    private String restrictionNewBorn;
    private String restrictionYoungAdults;
    private String restrictionName;



    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        restrictionFamilies = "Families";
        restrictionAnyone = "anyone";
        restrictionMen = "men";
        restrictionFemale = "Women";
        restrictionNewBorn = "newborn" ;
        restrictionYoungAdults = "youngadults";
        restrictionChildren = "Children";

        shelterList = new ArrayList<>();
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 0, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 1, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 2, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 3, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 4, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 5, 200 ));

        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 6, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 7, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 8, 200 ));
        shelterList.add(new Shelter("123 Crayola Rd", "200", -84.087, 44.76,
                                        "(404) 367-2465", restrictionFamilies,
                                    "Nick'sCrib", "the coolest crib", 9, 200 ));


        emptyList = new ArrayList<>();


    }


    @Test(timeout = TIMEOUT)
    public void searchForFamilyEmpty() {
    assertEquals(sellAnswer,
                PatternMatching.bruteForce(sell, sellText, comparator));
        assertTrue("Did not use the comparator.", comparator.getCount() != 0);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 44.", comparator.getCount() == 44);
    }

    @Test(timeout = TIMEOUT)
    public void searchForFamilyContains() {
    assertEquals(sellAnswer,
                PatternMatching.bruteForce(sell, sellText, comparator));
        assertTrue("Did not use the comparator.", comparator.getCount() != 0);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 44.", comparator.getCount() == 44);
    }

    @Test(timeout = TIMEOUT)
    public void searchForFamilyDoesntContain() {
    assertEquals(sellAnswer,
                PatternMatching.bruteForce(sell, sellText, comparator));
        assertTrue("Did not use the comparator.", comparator.getCount() != 0);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 44.", comparator.getCount() == 44);
    }

}
