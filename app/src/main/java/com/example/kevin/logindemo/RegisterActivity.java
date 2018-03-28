package com.example.kevin.logindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button registerButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioButton userRadioButton;
    private RadioButton adminRadioButton;
    private ProgressDialog progressDialog;
    private String userType = "User";

    private FirebaseAuth fireBaseAuth;
    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);
        fireBaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        emailEditText = (EditText) findViewById(R.id.editText_email);
        passwordEditText = (EditText) findViewById(R.id.editText_password);

        cancelButton = (Button) findViewById(R.id.button_register_cancel);
        registerButton = (Button) findViewById(R.id.button_register_register);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerCancelClicked(view);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerClicked(view);
            }
        });

        userRadioButton = (RadioButton) findViewById(R.id.radio_button_user);
        adminRadioButton = (RadioButton) findViewById(R.id.radio_button_admin);

        userRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "User";
                userButtonClicked(view);
            }
        });
        adminRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "Admin";
                adminButtonClicked(view);
            }
        });
    }

    public void registerCancelClicked(View view) {
        finish();
    }

    public void registerClicked(View view) {
        // Add to database and go to log-in
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        if (email.length() == 0 || password.length() == 0) {
            Toast.makeText(RegisterActivity.this, (email.length() == 0 ? "email" : "password")
                    + " is a required field", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog.setMessage("Registering User...");
            progressDialog.show();
            fireBaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Register "
                                                + "Successfully as " + userType + ".",
                                        Toast.LENGTH_SHORT).show();
                                createFirebaseUser(email);
                                finish();
                                startActivity(new Intent(RegisterActivity.this,
                                        LoginActivity.class));
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Registration "
                                                + "Unsuccessful. Please try again.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
           /*
            if (userRadioButton.isChecked()) {
                LoginActivity.users.add(email, password);
                Toast.makeText(RegisterActivity.this, "Register "
                                + "Successfully as " + userType + ".",
                        Toast.LENGTH_SHORT).show();
                finish();
            } else {
                LoginActivity.admins.add(email, password);
                Toast.makeText(RegisterActivity.this, "Register "
                                + "Successfully as " + userType + ".",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }*/

    private void userButtonClicked(View view) {
        userRadioButton.setChecked(true);
        adminRadioButton.setChecked(false);
    }

    private void adminButtonClicked(View view) {
        adminRadioButton.setChecked(true);
        userRadioButton.setChecked(false);
    }

    private void createFirebaseUser (String email) {
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://kaman-buzzshelter.firebaseio.com/");
        Users dummy = new Users(email);
        String id = email.substring(0, email.indexOf("@"));
        Firebase mRefChild = mRef.child("users");
        Firebase mRefChildd = mRefChild.child(id);
        mRefChildd.setValue(dummy);

    }
}
