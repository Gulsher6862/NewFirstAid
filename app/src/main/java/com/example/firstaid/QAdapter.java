package com.example.firstaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        holder.op1.setChecked(false);
        holder.op2.setChecked(false);
        holder.op3.setChecked(false);
        holder.op1.setEnabled(true);
        holder.op2.setEnabled(true);
        holder.op3.setEnabled(true);
        holder.rw_txt.setVisibility(View.GONE);
        holder.next_btn.setVisibility(View.GONE);
        holder.que.setText(list.get(position).getQue());
        holder.op1.setText(list.get(position).getOpt1());
        holder.op2.setText(list.get(position).getOpt2());
        holder.op3.setText(list.get(position).getOpt3());

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.op2.setEnabled(false);
                holder.op3.setEnabled(false);

                if (holder.op1.getText().toString().equals(list.get(position).getAns())){
                    holder.rw_txt.setText("Correct Answer!");
                }
                else {
                    holder.rw_txt.setText("Wrong Answer!\nThe Correct Answer is :\n\n"+list.get(position).getAns());
                }
                holder.rw_txt.setVisibility(View.VISIBLE);
                holder.next_btn.setVisibility(View.VISIBLE);
            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.op1.setEnabled(false);
                holder.op3.setEnabled(false);
                if (holder.op2.getText().toString().equals(list.get(position).getAns())){
                    holder.rw_txt.setText("Correct Answer!");
                }
                else {
                    holder.rw_txt.setText("Wrong Answer!\nThe Correct Answer is :\n\n"+list.get(position).getAns());
                }
                holder.rw_txt.setVisibility(View.VISIBLE);
                holder.next_btn.setVisibility(View.VISIBLE);
            }
        });

        holder.op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.op1.setEnabled(false);
                holder.op2.setEnabled(false);
                if (holder.op3.getText().toString().equals(list.get(position).getAns())){
                    holder.rw_txt.setText("Correct Answer!");
                }
                else {
                    holder.rw_txt.setText("Wrong Answer!\nThe Correct Answer is :\n\n"+list.get(position).getAns());
                }
                holder.rw_txt.setVisibility(View.VISIBLE);
                holder.next_btn.setVisibility(View.VISIBLE);
            }
        });

        holder.next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.op1.isChecked()) {
                    quizSelection.onSelect(position,holder.op1.getText().toString());
                }
                else if (holder.op2.isChecked()) {
                    quizSelection.onSelect(position,holder.op2.getText().toString());
                }
                else if (holder.op3.isChecked()) {
                    quizSelection.onSelect(position,holder.op3.getText().toString());
                }
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


        TextView que, rw_txt;
        CheckBox op1,op2, op3;
        Button next_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            que = itemView.findViewById(R.id.que);
            op1 = itemView.findViewById(R.id.opt1);
            op2 = itemView.findViewById(R.id.opt2);
            op3 = itemView.findViewById(R.id.opt3);
            rw_txt = itemView.findViewById(R.id.rw_txt);
            next_btn = itemView.findViewById(R.id.next_btn);

            itemView.setTag(this);

            itemView.setOnClickListener(listener);

        }
    }

}