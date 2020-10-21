package com.example.firstaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QAdapter extends RecyclerView.Adapter<QAdapter.ViewHolder>{

    private ArrayList<quiz_model> list;
    private Context context;
    private View.OnClickListener listener;
    @NonNull
    private QuizSelection quizSelection;

    public QAdapter(ArrayList<quiz_model> list,Context context,QuizSelection quizSelection) {
        this.list = list;
        this.context = context;
        this.quizSelection = quizSelection;
    }


    @NonNull
    @Override
    public QAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item,parent,false);

        return new QAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QAdapter.ViewHolder holder,final int position) {

        holder.que.setText(list.get(position).getQue());
        holder.op1.setText(list.get(position).getOpt1());
        holder.op2.setText(list.get(position).getOpt2());
        holder.op3.setText(list.get(position).getOpt3());

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizSelection.onSelect(position,holder.op1.getText().toString());
            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizSelection.onSelect(position,holder.op2.getText().toString());
            }
        });

        holder.op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizSelection.onSelect(position,holder.op3.getText().toString());
            }
        });
    }

    interface QuizSelection{
        void onSelect(int position,String text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView que;
        CheckBox op1,op2, op3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            que = itemView.findViewById(R.id.que);
            op1 = itemView.findViewById(R.id.opt1);
            op2 = itemView.findViewById(R.id.opt2);
            op3 = itemView.findViewById(R.id.opt3);

            itemView.setTag(this);

            itemView.setOnClickListener(listener);

        }
    }

}