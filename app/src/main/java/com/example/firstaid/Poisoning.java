package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Poisoning extends AppCompatActivity {

    ImageView back;
    Button btnw,btns,btnp;
    TextView tw,ts,tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poisoning);
        btnw = (Button) findViewById(R.id.whatbtn);
        back = (ImageView) findViewById(R.id.imageView6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poisoning.this,Home.class);
                startActivity(intent);
            }
        });
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tw.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.VISIBLE);
                ts.setVisibility(View.GONE);
                tp.setVisibility(View.GONE);
            }
        });
        btns = (Button) findViewById(R.id.diffbtn);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btns.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ts.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                ts.setVisibility(View.VISIBLE);
                tp.setVisibility(View.GONE);
            }
        });
        btnp = (Button) findViewById(R.id.preventbtn);
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tp.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                ts.setVisibility(View.GONE);
                tp.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        ts = (TextView) findViewById(R.id.difftxt);
        ts.setVisibility(View.GONE);
        tp = (TextView) findViewById(R.id.pvttxt);
        tp.setVisibility(View.GONE);

    }
}