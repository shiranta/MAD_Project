package com.example.myapplication.drivago;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupLearners extends AppCompatActivity {

    private EditText nameEt, emailEt, passwordEt1, passwordEt2;
    private Button SignUpButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    DatabaseReference dbRef;

     UserLearners userLearners;

     private void clearControls(){
         nameEt.setText("");
         emailEt.setText("");
         passwordEt1.setText("");
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuplearners);
        firebaseAuth=FirebaseAuth.getInstance();
        SignUpButton = (Button) findViewById(R.id.signupBtn);
        nameEt = (EditText) findViewById(R.id.etName);
        emailEt = (EditText) findViewById(R.id.etEmail);
        passwordEt1 = (EditText) findViewById(R.id.etPassword);
        passwordEt2 = (EditText) findViewById(R.id.etPassword2);
        progressDialog = new ProgressDialog(this);
        userLearners = new UserLearners();
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

    }

    private void Register() {
        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String password1 = passwordEt1.getText().toString();
        String password2 = passwordEt2.getText().toString();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Users");
        if (TextUtils.isEmpty(name)) {
            nameEt.setError("Enter your name");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailEt.setError("Enter your email");
            return;
        }  if (TextUtils.isEmpty(password1)) {
            passwordEt1.setError("Enter your password");
            return;
        }  if (TextUtils.isEmpty(password2)) {
            passwordEt2.setError("Confirm your password");
            return;
        }  if (!password1.equals(password2)) {
            passwordEt2.setError("Password does not match");
            return;
        }  if (password1.length() < 4) {
            passwordEt1.setError("Length should be > 4");
            return;
        }  if (!isValidEmail(email)) {
            emailEt.setError("invalid email");
            return;
        }

        else{
            userLearners.setName(nameEt.getText().toString().trim());
            userLearners.setEmail(emailEt.getText().toString().trim());
            userLearners.setPassword(passwordEt1.getText().toString().trim());

            dbRef.push().setValue(userLearners);
            dbRef.child("user1").setValue(userLearners);
            Toast.makeText(signupLearners.this,"Credentials saved successfully !",Toast.LENGTH_LONG).show();
            clearControls();

        }
        progressDialog.setTitle("Create Account");
        progressDialog.setMessage("Please wait, while we are checking the credentials");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signupLearners.this,"Successfully registered",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(signupLearners.this, studentHome.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(signupLearners.this,"Sign up fail!",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private Boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}