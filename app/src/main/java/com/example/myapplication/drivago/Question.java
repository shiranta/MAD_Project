package com.example.myapplication.drivago;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.drivago.adapter.QuestionAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question extends AppCompatActivity {

    private FloatingActionButton floating_btn;
    private RecyclerView recyclerView;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Question");
    private List<com.example.myapplication.drivago.models.Question> list = new ArrayList<>();
    private QuestionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquestion);




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_naviagtion);
        bottomNavigationView.setSelectedItemId(R.id.Question);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch ( menuItem.getItemId()){
                    case R.id.Question:

                        return  true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), settings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), TeacherHome.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        floating_btn = findViewById(R.id.floating_btn);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        floating_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                showDialogAddNote();
            }
        });

        readData();

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showDialogAddNote() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp =  new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        Button btnclose = dialog.findViewById(R.id.close_btn);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        final EditText addquestion = dialog.findViewById(R.id.ed_note);
        Button btnadd = dialog.findViewById(R.id.btn_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(addquestion.getText())){
                    addquestion.setError("this fileed cant be not empty");
                }else{
                    addDataToFirebase(addquestion.getText().toString());
                    dialog.dismiss();
                }
            }
        });


        dialog.show();


    }

    private void addDataToFirebase(final String text){

        String id = myRef.push().getKey();
        com.example.myapplication.drivago.models.Question question = new com.example.myapplication.drivago.models.Question(id,text);

        myRef.child(id).setValue(question).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"Succefully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void readData() {

        // Read from the database

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    com.example.myapplication.drivago.models.Question value = snapshot.getValue(com.example.myapplication.drivago.models.Question.class);
                    list.add(value);
                }
                adapter = new QuestionAdapter(Question.this,list);
                recyclerView.setAdapter(adapter);
                setClick();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w( "tag", "Failed to read value.", error.toException());
            }
        });

    }

    private void setClick() {
        adapter.setOnCallBack(new QuestionAdapter.OnCallBack() {
            @Override
            public void onButtonDeleteClick(com.example.myapplication.drivago.models.Question question) {
                deleteQuestion(question);
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onButtonEditClick(com.example.myapplication.drivago.models.Question question) {
                showDialogUpdateNote(question);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showDialogUpdateNote(final com.example.myapplication.drivago.models.Question question) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp =  new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        Button btnclose = dialog.findViewById(R.id.close_btn);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        final EditText addquestion = dialog.findViewById(R.id.ed_note);
        addquestion.setText(question.getQuestion());
        Button btnadd = dialog.findViewById(R.id.btn_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(addquestion.getText())){
                    addquestion.setError("this fileed cant be not empty");
                }else{
                    updateQuestion(question,addquestion.getText().toString());
                    dialog.dismiss();
                }
            }
        });


        dialog.show();


    }

    private void updateQuestion(com.example.myapplication.drivago.models.Question question, String newQuestion) {

        myRef.child(question.getId()).child("question").setValue(newQuestion).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"updated succfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void deleteQuestion(final com.example.myapplication.drivago.models.Question question){
        myRef.child(question.getId()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                Toast.makeText(getApplicationContext(),"Deleted :"+question.getQuestion(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}