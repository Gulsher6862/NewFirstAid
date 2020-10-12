package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class CategoryDetails extends AppCompatActivity {

    Toolbar toolbar;

    ImageView imageView, pbtn;
    LinearLayout progress;
    Button q1, q2, q3;
    TextView qt1, qt2, qt3;
    ImageView qi1, qi2, qi3;
    FirebaseFirestore db;

    LinearLayout ll1,ll2,ll3;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);

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

        db = FirebaseFirestore.getInstance();

        imageView = findViewById(R.id.imageView);
        pbtn = findViewById(R.id.playbtn);
        progress = findViewById(R.id.progressLL);
        q1 = findViewById(R.id.que1);
        q2 = findViewById(R.id.que2);
        q3 = findViewById(R.id.que3);
        qt1 = findViewById(R.id.que1txt);
        qt2 = findViewById(R.id.que2txt);
        qt3 = findViewById(R.id.que3txt);
        qi1 = findViewById(R.id.img1);
        qi2 = findViewById(R.id.img2);
        qi3 = findViewById(R.id.img3);
        ll1 = findViewById(R.id.q1LL);
        ll2 = findViewById(R.id.q2LL);
        ll3 = findViewById(R.id.q3LL);


        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qt1.getVisibility() == View.VISIBLE){
                    qt1.setVisibility(View.GONE);
                    qi1.setRotation(0);
                }
                else {
                    qt1.setVisibility(View.VISIBLE);
                    qi1.setRotation(180);
                }
            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qt2.getVisibility() == View.VISIBLE){
                    qt2.setVisibility(View.GONE);
                    qi2.setRotation(0);
                }
                else {
                    qt2.setVisibility(View.VISIBLE);
                    qi2.setRotation(180);
                }
            }
        });

        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qt3.getVisibility() == View.VISIBLE){
                    qt3.setVisibility(View.GONE);
                    qi3.setRotation(0);
                }
                else {
                    qt3.setVisibility(View.VISIBLE);
                    qi3.setRotation(180);
                }
            }
        });


    }
}