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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.InputStream;
import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private RecyclerView shelterDatabaseRecyclerView;
    private ShelterDatabaseAdapter shelterDatabaseAdapter;
    private RecyclerView.LayoutManager shelterDatabaseLayoutManager;
    private SearchView searchView;

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

        shelterDatabaseAdapter = new ShelterDatabaseAdapter(shelters, shelters, this);
        shelterDatabaseRecyclerView.setAdapter(shelterDatabaseAdapter);
    }

    private void loadShelterDatabase() {
        InputStream inputStream = getResources().openRawResource(R.raw.homeless_shelter_database);
        CSVParser csvParser = new CSVParser(inputStream);
        shelters = csvParser.getShelters();
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

}
