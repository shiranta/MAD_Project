package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Card extends AppCompatActivity {

    Button addnew;
    Button avcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        addnew = findViewById(R.id.addnew);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Card.this, Addnewcard.class);
                startActivity(intent);


            }
        });




        avcard = findViewById(R.id.avcard);
        avcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Card.this, Available.class);
                startActivity(intent);


            }
        });

    }

}