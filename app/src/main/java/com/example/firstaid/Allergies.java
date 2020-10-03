package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Allergies extends AppCompatActivity {


    Button bw,btyp,btreat;
    TextView tw,ttyp,ttreat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);
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
                ttyp.setVisibility(View.GONE);
                ttreat.setVisibility(View.GONE);
            }
        });
        btyp = (Button) findViewById(R.id.typebtn);
        btyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btyp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ttyp.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                ttyp.setVisibility(View.VISIBLE);
                ttreat.setVisibility(View.GONE);
            }
        });
        btreat = (Button) findViewById(R.id.treatbtn);
        btreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btreat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ttreat.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                ttyp.setVisibility(View.GONE);
                ttreat.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        ttyp = (TextView) findViewById(R.id.typetxt);
        ttyp.setVisibility(View.GONE);
        ttreat = (TextView) findViewById(R.id.treattxt);
        ttreat.setVisibility(View.GONE);
    }
}