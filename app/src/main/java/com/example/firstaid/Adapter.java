package com.example.firstaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<product_model> list;
    private Context context;
    private View.OnClickListener listener;

    public Adapter(ArrayList<product_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.price.setText("Price: $"+ list.get(position).getPrice());
        holder.desc.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        
    }

    public void setOnClickListener(View.OnClickListener clickListener){

        listener = clickListener;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name,price,desc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.prdname);
            price = itemView.findViewById(R.id.prdprice);
            imageView = itemView.findViewById(R.id.image);
            desc = itemView.findViewById(R.id.prddesc);

            itemView.setTag(this);

            itemView.setOnClickListener(listener);

        }
    }

}