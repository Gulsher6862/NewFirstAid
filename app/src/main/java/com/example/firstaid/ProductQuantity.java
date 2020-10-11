package com.example.firstaid;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class ProductQuantity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView img;
    TextView name,price,desc;
    EditText qty;
    Button atcb;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_quantity);

        mAuth = FirebaseAuth.getInstance();

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

                }
            }
        });

    }
}