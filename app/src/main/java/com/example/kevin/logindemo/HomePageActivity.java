package com.example.kevin.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    private RecyclerView shelterDatabaseRecyclerView;
    private RecyclerView.Adapter shelterDatabaseAdapter;
    private RecyclerView.LayoutManager shelterDatabaseLayoutManager;

    private ArrayList<Shelter> shelters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        loadShelterDatabase();

        shelterDatabaseRecyclerView = (RecyclerView) findViewById(R.id.shelter_database_recycler_view);
        shelterDatabaseRecyclerView.setHasFixedSize(true);

        shelterDatabaseLayoutManager = new LinearLayoutManager(this);
        shelterDatabaseRecyclerView.setLayoutManager(shelterDatabaseLayoutManager);

        shelterDatabaseAdapter = new ShelterDatabaseAdapter(shelters, this);
        shelterDatabaseRecyclerView.setAdapter(shelterDatabaseAdapter);
    }

    private void loadShelterDatabase() {
        InputStream inputStream = getResources().openRawResource(R.raw.homeless_shelter_database);
        CSVParser csvParser = new CSVParser(inputStream);
        shelters = csvParser.getShelters();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
