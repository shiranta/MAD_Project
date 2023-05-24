package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherHome extends AppCompatActivity {

    TextView user;
    TextView ques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

        DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        //signs is used temporarily
        mDatabaseRef.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long count= dataSnapshot.getChildrenCount();
                user = findViewById(R.id.studentCount);

                String str = Long.toString(count);
                user.setText(str);
            }




            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference mqDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mqDatabaseRef.child("Question").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long count= dataSnapshot.getChildrenCount();
                ques = findViewById(R.id.ques);

                String str = Long.toString(count);
                ques.setText(str);
            }




            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_naviagtion);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch ( menuItem.getItemId()){
                    case R.id.Question:
                        startActivity(new Intent(getApplicationContext(), Question.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), settings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:

                        return true;
                }
                return false;
            }


        });
    }
}