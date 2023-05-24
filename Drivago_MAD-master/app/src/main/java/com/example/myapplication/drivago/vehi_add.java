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

public class vehi_add extends AppCompatActivity {

    private Button Vadd;

    EditText cName, cPrice, cPeriod;


    DatabaseReference dbRef;
   Vehicle vehicle;

    private void clearControls(){
        cName.setText("");
        cPeriod.setText("");
        cPrice.setText("");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehi_add);


        cName = findViewById(R.id.vCategory);
        cPrice = findViewById(R.id.period);
        cPeriod = findViewById(R.id.charge);

        vehicle = new Vehicle();

        Vadd = (Button) findViewById(R.id.v_add);

        Vadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(vehi_add.this, category.class);
                startActivity(i);

                dbRef = FirebaseDatabase.getInstance().getReference().child("Vehicle");
                try{
                    if(TextUtils.isEmpty(cName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Vehicle Category",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(cPrice.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter learning charges", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(cPeriod.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter learning period", Toast.LENGTH_SHORT).show();

                    else{
                        vehicle.setcName(cName.getText().toString().trim());
                        vehicle.setPrice(cPrice.getText().toString().trim());
                        vehicle.setPeriod(cPeriod.getText().toString().trim());


                        dbRef.push().setValue(vehicle);

                        dbRef.child("std1").setValue(vehicle);
                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }


                }
                catch (NumberFormatException e){
                    //Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}