package com.example.kevin.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShelterInformationActivity extends AppCompatActivity {

    private TextView shelterNameTextView;
    private TextView capacityTextView;
    private TextView restrictionsTextView;
    private TextView longitudeTextView;
    private TextView latitudeTextView;
    private TextView addressTextView;
    private TextView phoneNumberTextView;

    private Shelter shelter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_information);

        shelter = getIntent().getExtras().getParcelable("SHELTER");

        shelterNameTextView = (TextView) findViewById(R.id.shelter_name_text_view);
        capacityTextView = (TextView) findViewById(R.id.capacity_text_view);
        restrictionsTextView = (TextView) findViewById(R.id.restrictions_text_view);
        longitudeTextView = (TextView) findViewById(R.id.longitude_text_view);
        latitudeTextView = (TextView) findViewById(R.id.latitude_text_view);
        addressTextView = (TextView) findViewById(R.id.address_text_view);
        phoneNumberTextView = (TextView) findViewById(R.id.phone_number_text_view);

        setInformationViews();
    }

    private void setInformationViews() {
        shelterNameTextView.setText("Name: " + shelter.getName());
        capacityTextView.setText("Capacity: " + shelter.getCapacity());
        restrictionsTextView.setText("Restrictions: " + shelter.getRestrictions());
        longitudeTextView.setText("Longitude: " + shelter.getLongitude());
        latitudeTextView.setText("Latitude: " + shelter.getLatitude());
        addressTextView.setText("Address: " + shelter.getAddress());
        phoneNumberTextView.setText("Phone Number: " + shelter.getPhoneNumber());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            Intent intent = new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
