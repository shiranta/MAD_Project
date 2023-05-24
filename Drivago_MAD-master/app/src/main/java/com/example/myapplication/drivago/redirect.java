package com.example.myapplication.drivago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class redirect extends AppCompatActivity {
    private Spinner spinner;
    private static final String[] paths = {"choose", "Teacher", "Admin" , "thushan" , "none"};
    RadioButton rdo;
    Button teacher , student, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);



        student = findViewById(R.id.red_student);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Button start;
//                start = findViewById(R.id.getStarted);

//                start.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
                        Intent i =new Intent(redirect.this , HomeActivityLearners.class);
                        startActivity(i);
                    }
                });


        teacher = findViewById(R.id.red_teacher);
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (redirect.this, HomeActivity.class);
                startActivity(i);
            }
        });

        admin = findViewById(R.id.red_admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (redirect.this, MainActivity.class);
                startActivity(i);
            }
        });
            }
        //});


    }
