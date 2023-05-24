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

public class addSign extends AppCompatActivity {
     Button button1;
    EditText sName, sUrl, sDescp;


    DatabaseReference dbRef1;
    Signs sign;

    private void clearControls(){
        sName.setText("");
        sUrl.setText("");
        sDescp.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sign);


        sName= findViewById(R.id.sName);
        sUrl = findViewById(R.id.url);
        sDescp = findViewById(R.id.sDetails);


        //vAdd = findViewById(R.id.t_add);

        sign = new Signs();


        button1 = (Button) findViewById(R.id.signAdd);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(addSign.this, signs_mand.class);
                startActivity(i);


                dbRef1 = FirebaseDatabase.getInstance().getReference().child("Signs");
                try{
                    if(TextUtils.isEmpty(sName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Sign Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(sDescp.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter description", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(sUrl.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter image Url", Toast.LENGTH_SHORT).show();

                    else{
                        sign.setSname(sName.getText().toString().trim());
                        sign.setDescp(sDescp.getText().toString().trim());
                        sign.setUrl(sUrl.getText().toString().trim());


                        dbRef1.push().setValue(sign);

                        dbRef1.child("std1").setValue(sign);
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




