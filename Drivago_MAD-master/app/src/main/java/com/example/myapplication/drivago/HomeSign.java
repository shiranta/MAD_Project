package com.example.myapplication.drivago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeSign extends AppCompatActivity {
    RecyclerView recyclerView;
    signadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sign);



        recyclerView = (RecyclerView) findViewById(R.id.recycleSignHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelSign> options =
                new FirebaseRecyclerOptions.Builder<modelSign>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Signs"), modelSign.class)
                        .build();


        adapter = new signadapter(options);
        recyclerView.setAdapter(adapter);


    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}