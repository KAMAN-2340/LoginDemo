package com.example.kevin.logindemo;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Integer.parseInt;

/**
 * shelter info activity
 */
public class ShelterInformationActivity extends AppCompatActivity {

    private TextView shelterNameTextView;
    private TextView capacityTextView;
    private TextView restrictionsTextView;
    private TextView longitudeTextView;
    private TextView latitudeTextView;
    private TextView addressTextView;
    private TextView phoneNumberTextView;
    private TextView vacancyTextView;

    private EditText inputReserveEditText;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference databaseRef;
    private DatabaseReference userRef;
    private ValueEventListener mUserListener;
    private ValueEventListener mShelterListener;

    private int userReserved = 0;
    private long vacants = 0;
    private int rooms = 0;
    private Shelter shelter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_information);
        FirebaseApp.initializeApp(this);
        Firebase.setAndroidContext(this);

        shelter = getIntent().getExtras().getParcelable("SHELTER");

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        assert user != null;
        String id = user.getEmail().substring(0, user.getEmail().indexOf("@"));
        userRef = FirebaseDatabase.getInstance().getReference().child("users").child(id);
        databaseRef = FirebaseDatabase.getInstance().getReference().child("shelters").child(""
                + shelter.getKey()).child("Vacancy");


        shelterNameTextView = findViewById(R.id.shelter_name_text_view);
        capacityTextView = findViewById(R.id.capacity_text_view);
        restrictionsTextView = findViewById(R.id.restrictions_text_view);
        longitudeTextView = findViewById(R.id.longitude_text_view);
        latitudeTextView = findViewById(R.id.latitude_text_view);
        addressTextView = findViewById(R.id.address_text_view);
        phoneNumberTextView = findViewById(R.id.phone_number_text_view);
        vacancyTextView = findViewById(R.id.vacancy_text_view);

        inputReserveEditText = findViewById(R.id.editText_reserve);
        Button reserveButton = findViewById(R.id.reserve_room_button);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userReserved != 0) {
                    Snackbar.make(view, "User Already Has Reservations", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                String input = inputReserveEditText.getText().toString().trim();
                if (input.matches("[0-9]+")) {
                    rooms = parseInt(input);
                    if (rooms <= 0) {
                        Snackbar.make(view, "Invalid Input", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        return;
                    }else if ((vacants - rooms) < 0) {
                        Snackbar.make(view, "Cannot Overbook Rooms", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        return;
                    }
                    userRef.child("roomsReserved").setValue(rooms);
                    userRef.child("shelterReserved").setValue(shelter.getName());
                    userRef.child("shelterId").setValue(shelter.getKey());
                    databaseRef.setValue(vacants - rooms);
                    inputReserveEditText.setText("");
                    Snackbar.make(view, "Successful Registration", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(view, "Invalid Input", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        setInformationViews();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Add value event listener to the post
        // [START post_value_event_listener]
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users dummy = dataSnapshot.getValue(Users.class);
                assert dummy != null;
                userReserved = dummy.getRoomsReserved();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };

        ValueEventListener shelterListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vacants = (long) dataSnapshot.getValue();
                vacancyTextView.setText("Vacancy: " + vacants);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };
        databaseRef.addValueEventListener(shelterListener);
        mShelterListener = shelterListener;
        userRef.addValueEventListener(userListener);
        mUserListener = userListener;
    }

    @Override
    public void onStop() {
        super.onStop();

        // Remove post value event listener
        if (mUserListener != null) {
            databaseRef.removeEventListener(mShelterListener);
            userRef.removeEventListener(mUserListener);
        }
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
            Intent intent = new Intent(this,
                    MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
