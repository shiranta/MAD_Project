package com.example.myapplication.drivago;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class myCategoryAdapter  extends FirebaseRecyclerAdapter<modelCategory,myCategoryAdapter.myCategoryviewholder>{


    public myCategoryAdapter(@NonNull FirebaseRecyclerOptions<modelCategory> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myCategoryviewholder holder, final int position, @NonNull modelCategory model) {
        holder.cName.setText(model.getcName());
        holder.price.setText(model.getPrice());
        holder.period.setText(model.getPeriod());




        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // AlertDialog.Builder builder = new AlertDialog.Builder(holder.url.getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.cName.getContext());
                builder.setTitle("Delete panel");
                builder.setMessage("Are you sure?");


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Vehicle").child(getRef(position).getKey()).removeValue();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


    }



    @NonNull
    @Override
    public myCategoryviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorysinglerow,parent,false);
        return new myCategoryAdapter.myCategoryviewholder(view);


    }

    class myCategoryviewholder extends RecyclerView.ViewHolder{

        TextView cName , price , period ;
        Button btnDelete;
        public myCategoryviewholder(@NonNull View itemView) {
            super(itemView);
            btnDelete = itemView.findViewById(R.id.btnDeleteCategory);

            cName = (TextView)itemView.findViewById(R.id.categoryName);
            price = (TextView)itemView.findViewById(R.id.categoryPrice);
            period = (TextView)itemView.findViewById(R.id.categoryPeriod);

        }
    }
}
