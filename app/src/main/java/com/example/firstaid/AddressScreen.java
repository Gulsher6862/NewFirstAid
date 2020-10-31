package com.example.firstaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressScreen extends AppCompatActivity {

    private ArrayList<product_model> list;
    private EditText bnum,street,pd, cnum, cvv, exp_date;
    Button placeOrderBtn;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    Toolbar toolbar;
    LinearLayout progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_screen);

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

        progressBar = findViewById(R.id.progressLL);
        bnum = findViewById(R.id.bnum);
        street = findViewById(R.id.street);
        pd = findViewById(R.id.code);
        cnum = findViewById(R.id.cardnum);
        cvv = findViewById(R.id.cvv);
        exp_date = findViewById(R.id.expdate);
        placeOrderBtn = findViewById(R.id.btnorder);
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String building_num = bnum.getText().toString().trim();
                String street_name = street.getText().toString().trim();
                String postal_code = pd.getText().toString().trim();
                String card_num = cnum.getText().toString().trim();
                String cvv_num = cvv.getText().toString().trim();
                String expDate = exp_date.getText().toString().trim();

                order(building_num, street_name, postal_code, card_num, cvv_num, expDate);
            }
        });

        if (getIntent()!=null) {
            list = getIntent().getParcelableArrayListExtra("cart_list");
        }
    }

    private void order(String building_num, String street_name, String postal_code, String card_num, String cvv_num, String expDate) {

        if (building_num.equals("") | street_name.equals("") | postal_code.equals("") | card_num.equals("") | cvv_num.equals("") | expDate.equals("")) {
            Toast.makeText(AddressScreen.this,"Fields can't be empty!",Toast.LENGTH_LONG).show();
        }
        else if (card_num.length()<16) {
            Toast.makeText(AddressScreen.this,"Enter valid card number!",Toast.LENGTH_LONG).show();
        }
        else if (!isValidDate(expDate)) {
            Toast.makeText(AddressScreen.this,"Enter valid expiry date!",Toast.LENGTH_LONG).show();
        }
        else if (cvv_num.length()<3){
            Toast.makeText(AddressScreen.this,"Enter valid CVV!",Toast.LENGTH_LONG).show();
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            for (int i = 0; i<list.size(); i++) {

                Map<String, Object> orderdata = new HashMap<>();
                orderdata.put("userid", mAuth.getCurrentUser().getUid());
                orderdata.put("product_id", list.get(i).getId());
                orderdata.put("name",list.get(i).getName());
                orderdata.put("img", list.get(i).getImage());
                orderdata.put("desc", list.get(i).getDesc());
                orderdata.put("product_price", list.get(i).getPrice());
                orderdata.put("cart_id", list.get(i).getCart_id());
                orderdata.put("quantity", list.get(i).getQuantity());
                orderdata.put("product_total_price", list.get(i).getTotal_prize());
                orderdata.put("order_total", getIntent().getIntExtra("cart_total",0));
                orderdata.put("address", building_num+", "+street_name+", "+postal_code);
                orderdata.put("card_num", card_num);
                orderdata.put("cvv", cvv_num);
                orderdata.put("exp_date",expDate);


                // Add a new document with a generated ID
                final int finalI = i;
                db.collection("orders")
                        .add(orderdata)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                db.collection("cart").document(list.get(finalI).getCart_id()).delete();
                            }
                        });
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddressScreen.this,"Order placed successfully!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddressScreen.this, Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            },2000);
        }

    }

    private boolean isValidDate(String expDate) {
        return expDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
    }


}