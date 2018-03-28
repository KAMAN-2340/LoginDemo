package com.example.kevin.logindemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.firebase.client.Firebase;
import com.google.firebase.database.ValueEventListener;


public class UserInfoActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference database;
    private DatabaseReference shelterRef;
    private ValueEventListener mShelterListener;
    private ValueEventListener mUserListener;

    private TextView displayName;
    private TextView displayEmail;
    private TextView displayPhone;

    int rooms;
    long vacants = 0;
    long shelterID;
    String shelterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(this);
        Firebase.setAndroidContext(this);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        String id = user.getEmail().substring(0, user.getEmail().indexOf("@"));
        database = FirebaseDatabase.getInstance().getReference().child("users").child(id);
        shelterRef = FirebaseDatabase.getInstance().getReference().child("shelters").child("" + shelterID).child("Vacancy");


        displayName = (TextView) findViewById(R.id.displayName);
        displayEmail = (TextView) findViewById(R.id.email);
        displayPhone = (TextView) findViewById(R.id.phoneNumber);
        ImageView displayImage = (ImageView) findViewById(R.id.profile);
        displayName.setText(user.getEmail());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!shelterName.equals("none") && rooms == 0) {
                    database.child("shelterReserved").setValue("none");
                }
                if (rooms == 0 || shelterName.equals("none")) {
                    Snackbar.make(view, "No Current Reservations", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                database.child("roomsReserved").setValue(0);
                database.child("shelterReserved").setValue("none");
                database.child("shelterId").setValue(0);
                shelterRef.setValue(vacants + rooms);
                Snackbar.make(view, "Reservation Released", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Add value event listener to the post
        // [START post_value_event_listener]
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users dummy = (Users) dataSnapshot.getValue(Users.class);
                shelterID = dummy.getShelterId();
                rooms = dummy.getRoomsReserved();
                shelterName = dummy.getShelterReserved();
                displayEmail.setText("Shelter Reserved: " + dummy.getShelterReserved());
                displayPhone.setText("Rooms Reserved: "+ dummy.getRoomsReserved());
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };
        database.addValueEventListener(userListener);
        mUserListener = userListener;
        shelterRef.addValueEventListener(shelterListener);
        mShelterListener = shelterListener;

    }

    @Override
    public void onStop() {
        super.onStop();

        // Remove post value event listener
        if (mUserListener != null) {
            database.removeEventListener(mUserListener);
            shelterRef.removeEventListener(mShelterListener);
        }
    }

        @Override
    public void onBackPressed() {
        finish();
    }
}
