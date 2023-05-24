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

public class signs_mand extends AppCompatActivity {

    private ImageButton add;
    RecyclerView recyclerView;
    mySignAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs_mand);

        recyclerView = (RecyclerView) findViewById(R.id.recycleSign);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelSign> options =
                new FirebaseRecyclerOptions.Builder<modelSign>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Signs"), modelSign.class)
                        .build();


        adapter = new mySignAdapter(options);
        recyclerView.setAdapter(adapter);

        add = (ImageButton) findViewById(R.id.addsign1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(signs_mand.this, addSign.class);
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