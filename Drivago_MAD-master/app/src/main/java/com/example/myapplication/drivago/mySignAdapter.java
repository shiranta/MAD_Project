package com.example.myapplication.drivago;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class mySignAdapter extends FirebaseRecyclerAdapter<modelSign,mySignAdapter.mySignviewholder> {


    public mySignAdapter(@NonNull FirebaseRecyclerOptions<modelSign> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final mySignviewholder holder, final int position, @NonNull modelSign model) {
        holder.sname.setText(model.getSname());
        holder.descp.setText(model.getDescp());

        // holder.plate.setText(model.getPlate());
        Glide.with(holder.url.getContext()).load(model.getUrl()).into(holder.url);

        //Glide.with(holder.img.getContext()).load


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.url.getContext());
                builder.setTitle("Delete panel");
                builder.setMessage("Are you sure?");


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Signs").child(getRef(position).getKey()).removeValue();

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
    public mySignviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signsinglerow,parent,false);
        return new mySignviewholder(view);


    }

    class mySignviewholder extends RecyclerView.ViewHolder{
        ImageView url;
        TextView sname,descp ;
        Button btnDelete;
        public mySignviewholder(@NonNull View itemView) {
            super(itemView);
            btnDelete = itemView.findViewById(R.id.btnDeleteSign);
            url = (ImageView)itemView.findViewById(R.id.signimg);
            sname = (TextView)itemView.findViewById(R.id.signName);
            descp = (TextView)itemView.findViewById(R.id.signDes);

        }
    }
}
