package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class editSign extends AppCompatActivity {
    private ImageButton edit;
    private ImageButton delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sign);

        edit = (ImageButton) findViewById(R.id.signEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(editSign.this, signs_mand.class);
                startActivity(i);
            }
        });

        delete = (ImageButton) findViewById(R.id.signDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(editSign.this, signs_mand.class);
                startActivity(i);
            }
        });
    }
}