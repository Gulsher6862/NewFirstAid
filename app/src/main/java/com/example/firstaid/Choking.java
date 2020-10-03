package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Choking extends AppCompatActivity {

    ImageView back;
    Button bw,bs,bp;
    TextView tw,ts,tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choking);
        back = (ImageView) findViewById(R.id.imageView6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choking.this,Home.class);
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
                ts.setVisibility(View.GONE);
                tp.setVisibility(View.GONE);
            }
        });
        bs = (Button) findViewById(R.id.diffbtn);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bs.setOnClickListener(new View.OnClickListener() {
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
        bp = (Button) findViewById(R.id.preventbtn);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.setOnClickListener(new View.OnClickListener() {
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
        tp = (TextView) findViewById(R.id.testbtn);
        tp.setVisibility(View.GONE);
    }
}