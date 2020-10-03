package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hypothermia extends AppCompatActivity {

    Button bw,bsymp,brisk;
    TextView tw,tsymp,trisk;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypothermia);
        back = (ImageView) findViewById(R.id.imageView6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hypothermia.this,Home.class);
                startActivity(intent);
            }
        });
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
                tsymp.setVisibility(View.GONE);
                trisk.setVisibility(View.GONE);
            }
        });
        bsymp = (Button) findViewById(R.id.sympbtn);
        bsymp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bsymp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tsymp.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymp.setVisibility(View.VISIBLE);
                trisk.setVisibility(View.GONE);
            }
        });
        brisk = (Button) findViewById(R.id.riskbtn);
        brisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brisk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        trisk.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymp.setVisibility(View.GONE);
                trisk.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        tsymp = (TextView) findViewById(R.id.symptxt);
        tsymp.setVisibility(View.GONE);
        trisk = (TextView) findViewById(R.id.risktxt);
        trisk.setVisibility(View.GONE);

    }
}