package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Heart_Attack extends AppCompatActivity {

    Button bw,bsym,btrt;
    TextView tw,tsym,ttrt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart__attack);
        bw = (Button) findViewById(R.id.whatbtn);
        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tw.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.VISIBLE);
                tsym.setVisibility(View.GONE);
                ttrt.setVisibility(View.GONE);
            }
        });
        bsym = (Button) findViewById(R.id.symptombtn);
        bsym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bsym.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tsym.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsym.setVisibility(View.VISIBLE);
                ttrt.setVisibility(View.GONE);
            }
        });
        btrt = (Button) findViewById(R.id.treatmentbtn);
        btrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btrt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ttrt.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsym.setVisibility(View.GONE);
                ttrt.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        tsym = (TextView) findViewById(R.id.symptomtext);
        tsym.setVisibility(View.GONE);
        ttrt = (TextView) findViewById(R.id.treatmenttxt);
        ttrt.setVisibility(View.GONE);
    }
}