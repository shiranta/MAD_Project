 package com.example.myapplication.drivago;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageButton;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;

 import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;

 public class Home extends AppCompatActivity {
     private ImageButton button1;
     private ImageButton sign_btn;
     private ImageButton vehi_btn;
     Button btnSignOut;
     FirebaseAuth mAuth;
     TextView user;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_home);

         DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();
         //signs is used temporarily
         mDatabaseRef.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 long count= dataSnapshot.getChildrenCount();
                 user = findViewById(R.id.users);

                 String str = Long.toString(count);
                 user.setText(str);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });


         mAuth = FirebaseAuth.getInstance();

         btnSignOut = findViewById(R.id.logout);

         btnSignOut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mAuth.signOut();
                 signOutUser();
             }
         });



         button1 = (ImageButton) findViewById(R.id.teacher);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                startActivity(new Intent(Home.this,
//                        Teacher.class));
                 Intent i = new Intent(Home.this, teacherN.class);
                 startActivity(i);

             }


         });

         sign_btn = (ImageButton) findViewById(R.id.signTab);
         sign_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                startActivity(new Intent(Home.this,
//                        Teacher.class));
                 Intent i = new Intent(Home.this, signs_mand.class);
                 startActivity(i);

             }
         });


         vehi_btn = (ImageButton) findViewById(R.id.vehicletab);
         vehi_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                startActivity(new Intent(Home.this,
//                        Teacher.class));
                 Intent i = new Intent(Home.this, category.class);
                 startActivity(i);

             }
         });

     }
     private void signOutUser() {
         Intent mainActivity = new Intent(Home.this, MainActivity.class);
         mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
         startActivity(mainActivity);
         finish();
     }
 }