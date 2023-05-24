package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class tip extends AppCompatActivity {
    RecyclerView recyclerView;
    mySignAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

//        recyclerView = (RecyclerView) findViewById(R.id.recycleQuestion);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseRecyclerOptions< com.example.myapplication.drivago.models.Question> options =
//                new FirebaseRecyclerOptions.Builder< com.example.myapplication.drivago.models.Question>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Signs"),  com.example.myapplication.drivago.models.Question.class)
//                        .build();
//
//
//        adapter = new  com.example.myapplication.drivago.adapter.QuestionAdapter(options);
//        recyclerView.setAdapter(adapter);
//
//        add = (ImageButton) findViewById(R.id.addsign1);



    }
}