package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product_model> list;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

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

        list.add(new product_model("1","Kit","","This is kit","99"));
        list.add(new product_model("1","Kit","","This is kit","99"));
        list.add(new product_model("1","Kit","","This is kit","99"));
        list.add(new product_model("1","Kit","","This is kit","99"));
        adapter.notifyDataSetChanged();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}