package com.example.kevin.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button registerButton;
    private EditText emailEditText;
    private EditText passwordEditText;

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
            LoginActivity.users.add(email, password);
            finish();
        }
    }


}
