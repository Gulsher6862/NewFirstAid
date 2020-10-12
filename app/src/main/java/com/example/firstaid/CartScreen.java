package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product_model> list;
    Toolbar toolbar;
    TextView tt;
    Button ctob;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screen);

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

        tt = findViewById(R.id.totaltxt);
        ctob = findViewById(R.id.continuebtn);

        ctob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new Adapter(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(CartScreen.this));
        recyclerView.setAdapter(adapter);

        list.add(new product_model("1","Kit","","This is kit","99",""));
        list.add(new product_model("1","Kit","","This is kit","99",""));
        list.add(new product_model("1","Kit","","This is kit","99",""));
        list.add(new product_model("1","Kit","","This is kit","99",""));
        adapter.notifyDataSetChanged();

    }
}