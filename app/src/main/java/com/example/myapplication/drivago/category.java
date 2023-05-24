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

public class category extends AppCompatActivity {

    ImageButton add;
    RecyclerView recyclerView;
    myCategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = (RecyclerView) findViewById(R.id.recycleCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<modelCategory> options =
                new FirebaseRecyclerOptions.Builder<modelCategory>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vehicle"), modelCategory.class)
                        .build();


        adapter = new myCategoryAdapter(options);
        recyclerView.setAdapter(adapter);


        add = (ImageButton)findViewById(R.id.addVehicle);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Home.this,
//                        Teacher.class));
                Intent i = new Intent(category.this, vehi_add.class);
                startActivity(i);

            }
        });
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