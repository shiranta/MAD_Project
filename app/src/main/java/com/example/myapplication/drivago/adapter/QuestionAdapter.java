package com.example.myapplication.drivago.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.drivago.R;
import com.example.myapplication.drivago.modelSign;
import com.example.myapplication.drivago.models.Question;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class  QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

//    public QuestionAdapter(@NonNull FirebaseRecyclerOptions<com.example.myapplication.drivago.models.Question> options) {
//        super(options);
//    }

    private Context context;
    private List<Question> list;

        private OnCallBack onCallBack;
    public QuestionAdapter(Context context, List<Question> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnCallBack(OnCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.quetitle.setText(list.get(position).getQuestion());
        holder.btndelte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCallBack.onButtonDeleteClick(list.get(position));
            }
        });
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCallBack.onButtonEditClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quetitle;
        private ImageButton btndelte,btnedit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quetitle = itemView.findViewById(R.id.Ques_title);
            btndelte = itemView.findViewById(R.id.btn_delete);
            btnedit = itemView.findViewById(R.id.btn_edit);
        }

    }
    public interface OnCallBack{
        void onButtonDeleteClick(Question question);
        void onButtonEditClick(Question question);
    }
}
