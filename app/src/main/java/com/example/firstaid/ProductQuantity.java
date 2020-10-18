package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProductQuantity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView img;
    TextView name,price,desc;
    EditText qty;
    Button atcb;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_quantity);

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

        img = findViewById(R.id.image);
        name = findViewById(R.id.prdname);
        price = findViewById(R.id.prdprice);
        desc = findViewById(R.id.prddesc);
        qty = findViewById(R.id.prdqnty);
        atcb = findViewById(R.id.cartbtn);
        atcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser()==null){
                    Toast.makeText(ProductQuantity.this,"Please login first!",Toast.LENGTH_LONG).show();
                }
                else {
                    String quantity = qty.getText().toString().trim();
                    addInCart(quantity);
                }
            }
        });

        name.setText(getIntent().getStringExtra("name"));
        price.setText("Price: $"+ getIntent().getStringExtra("price"));
        desc.setText(getIntent().getStringExtra("desc"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("image")).into(img);
    }

    private void addInCart(String quantity) {
        if (quantity.equals("")) {
            Toast.makeText(ProductQuantity.this,"Please enter quantity!",Toast.LENGTH_LONG).show();
        }
        else {
            atcb.setEnabled(false);
            Map<String, Object> cartdata = new HashMap<>();
            cartdata.put("userid", mAuth.getCurrentUser().getUid());
            cartdata.put("productid", getIntent().getStringExtra("id"));
            cartdata.put("quantity", quantity);
            cartdata.put("total_price", String.valueOf(Integer.parseInt(getIntent().getStringExtra("price")) * Integer.parseInt(quantity)));
            cartdata.put("name", getIntent().getStringExtra("name"));
            cartdata.put("img", getIntent().getStringExtra("image"));
            cartdata.put("desc", getIntent().getStringExtra("desc"));
            cartdata.put("price", getIntent().getStringExtra("price"));


            // Add a new document with a generated ID
            db.collection("cart")
                    .add(cartdata)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            atcb.setEnabled(true);
                            startActivity(new Intent(ProductQuantity.this,CartScreen.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            atcb.setEnabled(false);
                            Toast.makeText(ProductQuantity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
        }

    }
}