package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class sign_info extends AppCompatActivity {
    private ImageButton mandatory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_info);

        //mandatory = (ImageButton) findViewById(R.id.mandatory);
        mandatory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(sign_info.this, signs_mand.class);
                startActivity(i);

            }


        });
    }
}