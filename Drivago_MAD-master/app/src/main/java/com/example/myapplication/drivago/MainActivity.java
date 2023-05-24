package com.example.myapplication.drivago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText mEmail, Password;
    Button mLogin;

    ProgressBar progressBar;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.username1);
        Password = findViewById(R.id.password1);
        mLogin = findViewById(R.id.signin);
        progressBar= findViewById(R.id.progressBar);
        fAuth= FirebaseAuth.getInstance();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =mEmail.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty((email))){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty((password))){
                    Password.setError("Password is Required");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Logged in Succesfully",Toast.LENGTH_SHORT).show();;
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this,"ERROR !"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();;
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });


    }
}