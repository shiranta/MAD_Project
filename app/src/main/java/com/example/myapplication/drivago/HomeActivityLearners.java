package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivityLearners extends AppCompatActivity {

    Button signupButton;
    Button signinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlearners);

        signupButton = findViewById(R.id.signupBtn);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityLearners.this, signupLearners.class);
                startActivity(intent);
            }
        });

        signinButton = findViewById(R.id.signInBtn);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityLearners.this, LoginActivityLearners.class);
                startActivity(intent);
            }
        });
    }
}