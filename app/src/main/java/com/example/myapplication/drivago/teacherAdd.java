package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class teacherAdd extends AppCompatActivity {
    private Button add;

    EditText vType, vName, vPlate, vNumber;
   // Button vSave, vShow, vUpdate, vDelete;
    Button vAdd;
    DatabaseReference dbRef;
    Teacher teacher;

    private void clearControls(){
        vType.setText("");
        vName.setText("");
        vPlate.setText("");
        vNumber.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_add);


        vPlate = findViewById(R.id.plate);
        vName = findViewById(R.id.tName);
        vType = findViewById(R.id.type);
        vNumber = findViewById(R.id.contNo);

        //vAdd = findViewById(R.id.t_add);

        teacher = new Teacher();

        add = (Button) findViewById(R.id.t_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(teacherAdd.this, teacherN.class);
                startActivity(i);



                dbRef = FirebaseDatabase.getInstance().getReference().child("Teacher");
                try{
                    if(TextUtils.isEmpty(vType.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Vehicle Type",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(vName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a name", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(vPlate.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter number plate", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(vNumber.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter contact number", Toast.LENGTH_SHORT).show();
                    else{
                        teacher.setPlate(vPlate.getText().toString().trim());
                        teacher.setName(vName.getText().toString().trim());
                        teacher.setType(vType.getText().toString().trim());
                        teacher.setConNo(Integer.parseInt(vNumber.getText().toString().trim()));

                        dbRef.push().setValue(teacher);

                        dbRef.child("std1").setValue(teacher);
                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }


                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

        }
