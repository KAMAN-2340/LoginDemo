package com.example.kevin.logindemo;

import android.util.Log;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Nick on 2/26/2018.
 */

public class CSVParser {

    private InputStream inputStream;
    private ArrayList<Shelter> shelterArrayList;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = database.getReference().child("shelters");

    public CSVParser () {};

    public CSVParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public CSVParser(ArrayList<Shelter> list) {
        this.shelterArrayList = list;
    }

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
        } catch (IOException e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }
        }
        return shelterArrayList;
    }

    public void setShelter(ArrayList<Shelter> list) {
        this.shelterArrayList = list;
    }

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
