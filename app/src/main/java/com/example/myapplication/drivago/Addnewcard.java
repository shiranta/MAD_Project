package com.example.myapplication.drivago;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addnewcard extends AppCompatActivity {
    private EditText name, cardNo, exDate, cvv;
    private Button AddButton;
    private ProgressDialog progressDialog;
    DatabaseReference dbRef;

    CardInfo card;

    private void clearControls(){
        name.setText("");
        cardNo.setText("");
        exDate.setText("");
        cvv.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewcard);

        AddButton = (Button) findViewById(R.id.addcard);
        name = (EditText) findViewById(R.id.Cname);
        cardNo = (EditText) findViewById(R.id.Cno);
        exDate = (EditText) findViewById(R.id.Cdate);
        cvv = (EditText) findViewById(R.id.Cvv);
        progressDialog = new ProgressDialog(this);
        card = new CardInfo();
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCard();
                Intent intent = new Intent (Addnewcard.this, Card.class);
                startActivity(intent);
            }
        });


    }

    private void addCard() {
        String Name = name.getText().toString();
        String CardNo = cardNo.getText().toString();
        String ExDate = exDate.getText().toString();
        String CVV = cvv.getText().toString();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Cards");

        if (TextUtils.isEmpty(Name)) {
            name.setError("Enter your name");
            return;
        }
        if (TextUtils.isEmpty(CardNo)) {
            cardNo.setError("Enter the Card No");
            return;
        }
        if (TextUtils.isEmpty(ExDate)) {
            exDate.setError("Enter the Expiry Date");
            return;
        }
        if (TextUtils.isEmpty(CVV)) {
            cvv.setError("Enter the CVV No");
            return;
        }
        else{
            card.setName(name.getText().toString().trim());
            card.setCardNo(cardNo.getText().toString().trim());
            card.setExDate(exDate.getText().toString().trim());
            card.setCvv(cvv.getText().toString().trim());

            dbRef.push().setValue(card);
            Toast.makeText(Addnewcard.this,"Card added successfully.",Toast.LENGTH_LONG).show();
            clearControls();

        }
    }
}