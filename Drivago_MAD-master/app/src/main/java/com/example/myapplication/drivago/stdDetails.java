package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.drivago.models.Cal;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class stdDetails extends AppCompatActivity {

    EditText etid,etname,etaddress,ettel,etvehical;
    Button btnadd,btndelete,btnupdate,btndisplay,btnNext;

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aadd_student);

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        //myRef.setValue("Hello, World!");

        etid=(EditText) findViewById(R.id.et_idstu);
        etname=(EditText) findViewById(R.id.et_namestu);
        etaddress=(EditText) findViewById(R.id.et_addressstu);
        ettel=(EditText) findViewById(R.id.et_telstu);
        etvehical=(EditText) findViewById(R.id.et_vehicalstu);
        btnadd=findViewById(R.id.btnaddstu);
        btndelete=findViewById(R.id.btndeletestu);
        btnupdate=findViewById(R.id.btnupdatestu);
        btndisplay=findViewById(R.id.btndisplaystu);
        btnNext = findViewById(R.id.next);
        addData();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stdDetails.this, Cal.class);
                startActivity(i);
            }
        });
        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id=etid.getText().toString();
                DatabaseReference std= FirebaseDatabase.getInstance().getReference("Student_Details").child(id);
                std.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name=dataSnapshot.child("Name").getValue().toString();
                        String address=dataSnapshot.child("Address").getValue().toString();
                        String tel=dataSnapshot.child("Tel").getValue().toString();
                        String vehical=dataSnapshot.child("vehical").getValue().toString();

                        etname.setText(name);
                        etaddress.setText(address);
                        ettel.setText(tel);
                        etvehical.setText(vehical);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData(etid);

            }

            private void deleteData(EditText etid) {
                final String id=etid.getText().toString();

                DatabaseReference std= FirebaseDatabase.getInstance().getReference("Student_Details").child(id);
                std.removeValue();
                    Toast.makeText(getApplicationContext(),"Sucessfully delete from database",Toast.LENGTH_LONG).show();
            }

        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String id=etid.getText().toString();
                final String name=etname.getText().toString();
                final String address=etaddress.getText().toString();
                final String tel=ettel.getText().toString();
                final String vehical=etvehical.getText().toString();
                HashMap hashMap=new HashMap();
                hashMap.put("Name",name);
                hashMap.put("Address",address);
                hashMap.put("Tel",tel);
                hashMap.put("vehical",vehical);

                myRef.child(id).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Data Sucessfully updated to database",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }





    private void addData() {
        database= FirebaseDatabase.getInstance();
        myRef=database.getReference("Student_Details");

        /*final String id=etid.getText().toString();
        final String name=etid.getText().toString();
        final String address=etid.getText().toString();
        final String tel=etid.getText().toString();
        final String vehical=etid.getText().toString();*/
        btnadd=findViewById(R.id.btnaddstu);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id=etid.getText().toString();
                final String name=etname.getText().toString();
                final String address=etaddress.getText().toString();
                final String tel=ettel.getText().toString();
                final String vehical=etvehical.getText().toString();

                //Add time stamp
                /*long mDateTime=9999999999999L -System.currentTimeMillis();
                    String mOrderTime=String.valueOf(mDateTime);*/
                HashMap hashMap=new HashMap();
                hashMap.put("ID",id);
                hashMap.put("Name",name);
                hashMap.put("Address",address);
                hashMap.put("Tel",tel);
                hashMap.put("vehical",vehical);

                //child(mOrderTime)

                myRef.child(id).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override

                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Sucessfully apply to database",Toast.LENGTH_LONG).show();
                        }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Fail to apply to database",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}