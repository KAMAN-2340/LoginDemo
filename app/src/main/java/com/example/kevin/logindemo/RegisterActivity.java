package com.example.kevin.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
    }


}
