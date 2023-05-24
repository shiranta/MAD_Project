package com.example.myapplication.drivago;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Available extends AppCompatActivity
{
    RecyclerView recview;
    adapatorpay adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available);

        recview=(RecyclerView)findViewById(R.id.recviewpay);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<paymentModel> options =
                new FirebaseRecyclerOptions.Builder<paymentModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Cards"), paymentModel.class)
                        .build();

        adapter= new adapatorpay(options);
        recview.setAdapter(adapter);

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