package com.example.kevin.logindemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button registerButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioButton userRadioButton;
    private RadioButton adminRadioButton;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

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
                userButtonClicked(view);
            }
        });
        adminRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminButtonClicked(view);
            }
        });
    }

    public void registerCancelClicked(View view) {
        finish();
    }

    public void registerClicked(View view) {
        // add to database and go to app
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(TextUtils.isEmpty(email)) {
            // email is empty
            Toast.makeText(RegisterActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stops the function to execute further
            return;
        }

        if(TextUtils.isEmpty(password)) {
            // password is empty
            Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
            //stops the function to execute further
            return;
        }
//        if (email.length() == 0 || password.length() == 0) {
//            Toast.makeText(RegisterActivity.this, (email.length() == 0 ? "email" : "password")
//                    + " is a required field", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            if (userRadioButton.isChecked()) {
//                LoginActivity.users.add(email, password);
//                finish();
//            } else {
//                LoginActivity.users.add(email, password);
//                finish();
//            }
//        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    // user is successfully registered
                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Could not register. please try again", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void userButtonClicked(View view) {
        userRadioButton.setChecked(true);
        adminRadioButton.setChecked(false);
    }

    private void adminButtonClicked(View view) {
        adminRadioButton.setChecked(true);
        userRadioButton.setChecked(false);
    }
}
