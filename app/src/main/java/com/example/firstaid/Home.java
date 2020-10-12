package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    ImageView covid,asthma,bleeding,bone,choking,burns,headinjury,heartattack, allergy,hypothermia,diabetic,heartstroke,nosebleed,poisoning,sting;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        covid = (ImageView) findViewById(R.id.covidpic);
        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","covid");
                startActivity(intent);
            }
        });
        t1 = (TextView) findViewById(R.id.covidtxt);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","covid");
                startActivity(intent);
            }
        });

        asthma = (ImageView) findViewById(R.id.asthmapic);
        asthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","asthma");
                startActivity(intent);
            }
        });

        t2 = (TextView) findViewById(R.id.asthmatxt);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","asthma");
                startActivity(intent);
            }
        });

        bleeding = (ImageView) findViewById(R.id.bleedpic);
        bleeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","bleeding");
                startActivity(intent);
            }
        });
        t3 = (TextView) findViewById(R.id.bleedingtxt);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","bleeding");
                startActivity(intent);
            }
        });

        bone = (ImageView) findViewById(R.id.bonepic);
        bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","bone");
                startActivity(intent);
            }
        });

        t4 = (TextView) findViewById(R.id.bonetxt);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","bone");
                startActivity(intent);
            }
        });

        choking = (ImageView) findViewById(R.id.chokingpic);
        choking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","choking");
                startActivity(intent);
            }
        });

        t5 = (TextView) findViewById(R.id.chokingtxt);
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","choking");
                startActivity(intent);
            }
        });


        burns = (ImageView) findViewById(R.id.burnpic);
        burns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","burn");
                startActivity(intent);
            }
        });
        t6 = (TextView) findViewById(R.id.burnstxt);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","burn");
                startActivity(intent);
            }
        });

        headinjury = (ImageView)findViewById(R.id.headpic);
        headinjury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","head_injury");
                startActivity(intent);
            }
        });

        t7 = (TextView) findViewById(R.id.headtxt);
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","head_injury");
                startActivity(intent);

            }
        });

        heartattack = (ImageView)findViewById(R.id.heartpc);
        heartattack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","heart_attack");
                startActivity(intent);
            }
        });



        t8 = (TextView) findViewById(R.id.hrtatk);
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","heart_attack");
                startActivity(intent);
            }
        });


        allergy = (ImageView)findViewById(R.id.allergypic);
        allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","allergy");
                startActivity(intent);
            }
        });

        t9 = (TextView) findViewById(R.id.allergytxt);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","allergy");
                startActivity(intent);
            }
        });

        hypothermia = (ImageView)findViewById(R.id.hypopic);
        hypothermia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","hypothermia");
                startActivity(intent);
            }
        });

        t10 = (TextView) findViewById(R.id.hypotxt);
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","hypothermia");
                startActivity(intent);
            }
        });

        diabetic = (ImageView)findViewById(R.id.diabeticpic);
        diabetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","diabetic");
                startActivity(intent);
            }
        });
        t11 = (TextView) findViewById(R.id.diabetictxt);
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","diabetic");
                startActivity(intent);
            }
        });

        heartstroke = (ImageView)findViewById(R.id.heartpic);
        heartstroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","heart_stroke");
                startActivity(intent);
            }
        });

        t12 = (TextView) findViewById(R.id.heartst);
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","heart_stroke");
                startActivity(intent);
            }
        });

        nosebleed = (ImageView)findViewById(R.id.nosepic);
        nosebleed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","nose");
                startActivity(intent);
            }
        });

        t13 = (TextView) findViewById(R.id.nosetxt);
        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","nose");
                startActivity(intent);
            }
        });

        poisoning = (ImageView)findViewById(R.id.poisonpic);
        poisoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","poison");
                startActivity(intent);
            }
        });

        t14 = (TextView) findViewById(R.id.poisontxt);
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","poison");
                startActivity(intent);
            }
        });

        sting = (ImageView)findViewById(R.id.bitepic);
        sting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","stings");
                startActivity(intent);
            }
        });

        t15 = (TextView) findViewById(R.id.bitetxt);
        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoryDetails.class);
                intent.putExtra("category","stings");
                startActivity(intent);
            }
        });


    }
}