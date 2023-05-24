package com.example.myapplication.drivago;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class settings extends AppCompatActivity {
    TextView name, mail;
    Button logout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_naviagtion);
        bottomNavigationView.setSelectedItemId(R.id.setting);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch ( menuItem.getItemId()){
                    case R.id.Question:
                        startActivity(new Intent(getApplicationContext(), Question.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.setting:

                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), TeacherHome.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}