package com.example.myapplication.drivago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class studentHome extends AppCompatActivity {
ImageButton sign;
ImageButton question;
Button regis , pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        sign = findViewById(R.id.student_sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentHome.this , HomeSign.class);
                startActivity(i);

            }
        });


        question = findViewById(R.id.student_question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        regis = findViewById(R.id.student_regis);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentHome.this,stdDetails.class);
                startActivity(i);

            }
        });

        pay = findViewById(R.id.student_pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentHome.this,paymentMain.class);
                startActivity(i);

            }
        });
    }
}