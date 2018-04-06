package com.example.kevin.logindemo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Nick on 2/26/2018.
 */

class CSVParser {

    private InputStream inputStream;
    private ArrayList<Shelter> shelterArrayList;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = database.getReference().child("shelters");

     /**
     * parses CSV file
     */
    public CSVParser () {}

     /**
     * parses CSV file
     *
     * @param inputStream the input
     */
    public CSVParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

     /**
     * parses CSV file
     *
     * @param list
     */
    public CSVParser(ArrayList<Shelter> list) {
        this.shelterArrayList = list;
    }

     /**
     * returns a list of shelters
     *
     * @return the list of available shelters
     */
    public ArrayList getShelters() {
        ArrayList<Shelter> shelterArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream != null) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    shelterArrayList.add(new Shelter(line.split(",")));
                }
            }
        } catch (IOException ignored) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException ignored) {

            }
        }
        return shelterArrayList;
    }

     /**
     * sets shelter
     *
     * @param list the list of shelters to set
     */
    public void setShelter(ArrayList<Shelter> list) {
        this.shelterArrayList = list;
    }

     /**
     * gets the firebase shelter
     *
     * @return the firebase shelter
     */
    public ArrayList<Shelter> returnFirebaseShelter() {
        return this.shelterArrayList;
    }
//        public void getFirebaseShelter() {
//        final ArrayList<Shelter> list = new ArrayList<>();
//        databaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot child: dataSnapshot.getChildren()) {
//                    String a = (String) child.child("Address").getValue();
//                    String b = "" + child.child("Capacity").getValue();
//                    double c = (double) child.child("Latitude").getValue();
//                    double d = (double) child.child("Longitude").getValue();
//                    String e = (String) child.child("Phone Number").getValue();
//                    String f = (String) child.child("Restrictions").getValue();
//                    String g = (String) child.child("Shelter Name").getValue();
//                    String h = (String) child.child("Special Notes").getValue();
//                    long i = (long) child.child("Unique Key").getValue();
//                    long j = (long) child.child("Vacancy").getValue();
//                    list.add(new Shelter(a,b,c,d,e,f,g,h,i,j));
//                }
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }
}
