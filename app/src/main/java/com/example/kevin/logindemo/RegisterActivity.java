package com.example.kevin.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button registerButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioButton userRadioButton;
    private RadioButton adminRadioButton;
    private String userType = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
        // add to database and go to app
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (email.length() == 0 || password.length() == 0) {
            Toast.makeText(RegisterActivity.this, (email.length() == 0 ? "email" : "password")
                    + " is a required field", Toast.LENGTH_SHORT).show();
        } else {
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
        }
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
