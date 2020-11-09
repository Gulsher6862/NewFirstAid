package com.example.firstaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class OrderScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product_model> list;
    Toolbar toolbar;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);
        mAuth = FirebaseAuth.getInstance();
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
        adapter = new Adapter(list,getApplicationContext(),true);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderScreen.this));
        recyclerView.setAdapter(adapter);

        getOrders();

    }

    private void getOrders() {
        db.collection("orders").whereEqualTo("userid",mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    list.add(new product_model(document.get("product_id").toString(),
                            document.get("name").toString(),
                            document.get("img").toString(),
                            document.get("desc").toString(),
                            document.get("product_price").toString(),
                            document.get("quantity").toString(),
                            document.get("product_total_price").toString(),
                            document.getId(),
                            document.get("userid").toString()));
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}