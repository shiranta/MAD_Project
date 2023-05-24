package com.example.myapplication.drivago;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class  myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {


    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getName());
        holder.contNo.setText(String.valueOf(model.getContNo()));
        holder.type.setText(model.getType());
        holder.plate.setText(model.getPlate());

        //Glide.with(holder.img.getContext()).load

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);


    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,contNo , type , plate;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            contNo = (TextView)itemView.findViewById(R.id.contact);
            type = (TextView)itemView.findViewById(R.id.notype);
            plate = (TextView)itemView.findViewById(R.id.noplate);
        }
    }
}
