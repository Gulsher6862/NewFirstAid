package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CartScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<product_model> list;
    Toolbar toolbar;
    TextView tt;
    Button ctob;
    int carttotal = 0;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screen);
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

        tt = findViewById(R.id.totaltxt);
        ctob = findViewById(R.id.continuebtn);

        ctob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.size()>0) {
                    Intent intent = new Intent(CartScreen.this, AddressScreen.class);
                    intent.putExtra("cart_total", carttotal);
                    intent.putParcelableArrayListExtra("cart_list", list);
                    startActivity(intent);
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new Adapter(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(CartScreen.this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        getCart();

    }

    private void getCart() {
        db.collection("cart").whereEqualTo("userid",mAuth.getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    list.add(new product_model(document.get("productid").toString(),
                            document.get("name").toString(),
                            document.get("img").toString(),
                            document.get("desc").toString(),
                            document.get("price").toString(),
                            document.get("quantity").toString(),
                            document.get("total_price").toString(),
                            document.getId(),
                            document.get("userid").toString()));

                    carttotal = carttotal + Integer.parseInt(document.get("total_price").toString());
                }
                tt.setText("Total: $"+carttotal);
                adapter.notifyDataSetChanged();
            }
        });
    }
}