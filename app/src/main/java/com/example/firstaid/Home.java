package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    ImageView covid,asthma,bleeding,bone,choking,burns,headinjury,heartattack, allergy,hypothermia,diabetic,heartstroke;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        covid = (ImageView) findViewById(R.id.covidpic);
        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Covid19.class);
                startActivity(intent);
            }
        });
        t1 = (TextView) findViewById(R.id.covidtxt);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Covid19.class);
                startActivity(intent);
            }
        });

        asthma = (ImageView) findViewById(R.id.asthmapic);
        asthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Asthma.class);
                startActivity(intent);
            }
        });

        t2 = (TextView) findViewById(R.id.asthmatxt);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Asthma.class);
                startActivity(intent);
            }
        });

        bleeding = (ImageView) findViewById(R.id.bleedpic);
        bleeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Bleeding.class);
                startActivity(intent);
            }
        });
        t3 = (TextView) findViewById(R.id.bleedingtxt);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Bleeding.class);
                startActivity(intent);
            }
        });

        bone = (ImageView) findViewById(R.id.bonepic);
        bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Bone.class);
                startActivity(intent);
            }
        });

        t4 = (TextView) findViewById(R.id.bonetxt);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Bone.class);
                startActivity(intent);
            }
        });

        choking = (ImageView) findViewById(R.id.chokingpic);
        choking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Choking.class);
                startActivity(intent);
            }
        });

        t5 = (TextView) findViewById(R.id.chokingtxt);
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Choking.class);
                startActivity(intent);
            }
        });


        burns = (ImageView) findViewById(R.id.burnpic);
        burns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Burns.class);
                startActivity(intent);
            }
        });
        t6 = (TextView) findViewById(R.id.burnstxt);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Burns.class);
                startActivity(intent);
            }
        });

        t7 = (TextView) findViewById(R.id.headtxt);
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Head_Injury.class);
                startActivity(intent);
            }
        });
        t8 = (TextView) findViewById(R.id.hrtatk);
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Heart_Attack.class);
                startActivity(intent);
            }
        });
        t9 = (TextView) findViewById(R.id.allergytxt);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Allergies.class);
                startActivity(intent);
            }
        });
        t10 = (TextView) findViewById(R.id.hypotxt);
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Covid19.class);
                startActivity(intent);
            }
        });
        t11 = (TextView) findViewById(R.id.diabetictxt);
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Diabetic_Emergency.class);
                startActivity(intent);
            }
        });
        t12 = (TextView) findViewById(R.id.heartst);
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Heart_Stroke.class);
                startActivity(intent);
            }
        });

    }
}