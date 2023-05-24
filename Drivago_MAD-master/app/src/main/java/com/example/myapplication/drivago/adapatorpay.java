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

import de.hdodenhof.circleimageview.CircleImageView;

public class adapatorpay extends FirebaseRecyclerAdapter<paymentModel, adapatorpay.myviewholder>
{
    public adapatorpay(@NonNull FirebaseRecyclerOptions<paymentModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull paymentModel paymentModel)
    {
        holder.name.setText(paymentModel.getName());
        holder.cardNo.setText(paymentModel.getCardNo());
        holder.exDate.setText(paymentModel.getExDate());


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // AlertDialog.Builder builder = new AlertDialog.Builder(holder.url.getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Delete ");
                builder.setMessage("Are you sure?");


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Cards").child(getRef(position).getKey()).removeValue();

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
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlepayment,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        Button btnDelete, btnPay;

        CircleImageView img;
        TextView name,cardNo,exDate, cvv;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            btnDelete=itemView.findViewById(R.id.btnDeletePay);
            name=(TextView)itemView.findViewById(R.id.namepay);
            cardNo=(TextView)itemView.findViewById(R.id.cardno);
            exDate=(TextView)itemView.findViewById(R.id.exp);
        }
    }
}

