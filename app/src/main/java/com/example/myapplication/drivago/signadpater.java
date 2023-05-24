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

class signadapter extends FirebaseRecyclerAdapter<modelSign,signadapter.mySignviewholder> {


    public signadapter(@NonNull FirebaseRecyclerOptions<modelSign> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final mySignviewholder holder, final int position, @NonNull modelSign model) {
        holder.sname.setText(model.getSname());
        holder.descp.setText(model.getDescp());

        // holder.plate.setText(model.getPlate());
        Glide.with(holder.url.getContext()).load(model.getUrl()).into(holder.url);

        //Glide.with(holder.img.getContext()).load





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

        public mySignviewholder(@NonNull View itemView) {
            super(itemView);

            url = (ImageView)itemView.findViewById(R.id.signimg);
            sname = (TextView)itemView.findViewById(R.id.signName);
            descp = (TextView)itemView.findViewById(R.id.signDes);

        }
    }
}
