package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Diabetic_Emergency extends AppCompatActivity {

    Button bw,bsymt,bdiag;
    TextView tw,tsymt,tdiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetic__emergency);
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
                tsymt.setVisibility(View.GONE);
                tdiag.setVisibility(View.GONE);
            }
        });
        bsymt = (Button) findViewById(R.id.symtbtn);
        bsymt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bsymt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tsymt.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymt.setVisibility(View.VISIBLE);
                tdiag.setVisibility(View.GONE);
            }
        });
        bdiag = (Button) findViewById(R.id.diagbtn);
        bdiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdiag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tdiag.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymt.setVisibility(View.GONE);
                tdiag.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        tsymt = (TextView) findViewById(R.id.symttxt);
        tsymt.setVisibility(View.GONE);
        tdiag = (TextView) findViewById(R.id.diagtxt);
        tdiag.setVisibility(View.GONE);
    }
}