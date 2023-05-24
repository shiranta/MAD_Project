package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class paymentMain extends AppCompatActivity {

    Button card;
    Button csh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentmain);

        card = findViewById(R.id.cardbtn);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent (paymentMain.this, Card.class);
               startActivity(intent);


            }
        });

//        csh = findViewById(R.id.cashbtn);
//        csh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent (MainActivity.this, Cashpay.class);
//                startActivity(intent);
//            }
//        });




    }
}