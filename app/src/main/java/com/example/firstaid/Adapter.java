package com.example.firstaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private boolean isCart = false;
    private boolean isOrder = false;

    @NonNull
    private CartSelection cartSelection;
    public Adapter(ArrayList<product_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public Adapter(ArrayList<product_model> list, Context context, boolean isOrder) {
        this.list = list;
        this.context = context;
        this.isOrder = isOrder;
    }

    public Adapter(ArrayList<product_model> list, Context context, boolean isCart, CartSelection cartSelection) {
        this.list = list;
        this.context = context;
        this.isCart = isCart;
        this.cartSelection = cartSelection;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {

        if (isCart) {
            holder.remove_btn.setVisibility(View.VISIBLE);
            holder.price.setText("Price: $"+ list.get(position).getTotal_prize());
            holder.desc.setText("Qty: "+list.get(position).getQuantity());
        }
        else if (isOrder) {
            holder.price.setText("Price: $"+ list.get(position).getTotal_prize());
            holder.desc.setText("Qty: "+list.get(position).getQuantity());
        }
        else {
            holder.price.setText("Price: $"+ list.get(position).getPrice());
            holder.desc.setText(list.get(position).getDesc());
        }

        holder.name.setText(list.get(position).getName());

        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);

        holder.remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cartSelection.onDelete(position);
            }
        });
    }

    public void setOnClickListener(View.OnClickListener clickListener){

        listener = clickListener;

    }

    interface CartSelection{
        void onDelete(int position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name,price,desc;
        ImageView imageView;
        ImageButton remove_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.prdname);
            price = itemView.findViewById(R.id.prdprice);
            imageView = itemView.findViewById(R.id.image);
            desc = itemView.findViewById(R.id.prddesc);
            remove_btn = itemView.findViewById(R.id.remove_btn);
            itemView.setTag(this);

            itemView.setOnClickListener(listener);

        }
    }

}