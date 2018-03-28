package com.example.kevin.logindemo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private RecyclerView shelterDatabaseRecyclerView;
    private ShelterDatabaseAdapter shelterDatabaseAdapter;
    private RecyclerView.LayoutManager shelterDatabaseLayoutManager;
    private SearchView searchView;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    //private CSVParser csvParser = new CSVParser();

    ArrayList<Shelter> shelters = new ArrayList<>();
    final ArrayList<Shelter> tempList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Firebase.setAndroidContext(this);
        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference().child("shelters");

        loadShelterDatabase();

        shelterDatabaseRecyclerView = (RecyclerView) findViewById(R.id.shelter_database_recycler_view);
        shelterDatabaseRecyclerView.setHasFixedSize(true);

        shelterDatabaseLayoutManager = new LinearLayoutManager(this);
        shelterDatabaseRecyclerView.setLayoutManager(shelterDatabaseLayoutManager);

        shelterDatabaseAdapter = new ShelterDatabaseAdapter(shelters, shelters, this);
        shelterDatabaseRecyclerView.setAdapter(shelterDatabaseAdapter);
    }

    private void loadShelterDatabase() {
        InputStream inputStream = getResources().openRawResource(R.raw.homeless_shelter_database);
        CSVParser csvParser = new CSVParser(inputStream);
        //getFirebaseShelter();
        shelters = csvParser.getShelters();
    }

    public void getFirebaseShelter() {
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    String a = (String) child.child("Address").getValue();
                    String b = "" + child.child("Capacity").getValue();
                    double c = (double) child.child("Latitude").getValue();
                    double d = (double) child.child("Longitude").getValue();
                    String e = (String) child.child("Phone Number").getValue();
                    String f = (String) child.child("Restrictions").getValue();
                    String g = (String) child.child("Shelter Name").getValue();
                    String h = (String) child.child("Special Notes").getValue();
                    long i = (long) child.child("Unique Key").getValue();
                    long j = (long) child.child("Vacancy").getValue();
                    tempList.add(new Shelter(a,b,c,d,e,f,g,h,i,j));
                    Log.e("Hello", "onDataChange: " + shelters.size());
                }
                //csvParser.setShelter(tempList);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.getItem(0)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                shelterDatabaseAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                shelterDatabaseAdapter.getFilter().filter(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
