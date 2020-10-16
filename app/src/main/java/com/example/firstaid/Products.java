package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product_model> list;
    Toolbar toolbar;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        db = FirebaseFirestore.getInstance();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new Adapter(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(Products.this));
        recyclerView.setAdapter(adapter);

        getProducts();
    }

    private void getProducts() {
        db.collection("products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    list.add(new product_model(document.getId(),
                            document.get("name").toString(),
                            document.get("img").toString(),
                            document.get("desc").toString(),
                            document.get("price").toString()));
                }
                adapter.notifyDataSetChanged();

                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                        int position = viewHolder.getAdapterPosition();

                        Intent intent = new Intent(Products.this,ProductQuantity.class);
                        intent.putExtra("id",list.get(position).getId());
                        intent.putExtra("name",list.get(position).getName());
                        intent.putExtra("image",list.get(position).getImage());
                        intent.putExtra("desc",list.get(position).getDesc());
                        intent.putExtra("price",list.get(position).getPrice());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}