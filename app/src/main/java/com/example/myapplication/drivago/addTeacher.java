package com.example.myapplication.drivago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class addTeacher extends AppCompatActivity {

    private ImageButton button4;
    private ImageButton button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        button4 = (ImageButton) findViewById(R.id.t_edit);
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(addTeacher.this,
                        teacherN.class));

                button5 = (ImageButton) findViewById(R.id.t_delete);
                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(addTeacher.this,
                                teacherN.class));

            }
        });
    }
});
    }
}