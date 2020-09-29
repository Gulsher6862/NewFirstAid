package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Head_Injury extends AppCompatActivity {
    Button bw,bdtyp,bdtest;
    TextView tw,tdtyp,tdtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head__injury);
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
                tdtyp.setVisibility(View.GONE);
                tdtest.setVisibility(View.GONE);
            }
        });
        bdtyp = (Button) findViewById(R.id.diffbtn);
        bdtyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdtyp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tdtyp.setVisibility(View.GONE);
                    }
                });
                tdtest.setVisibility(View.GONE);
                tdtyp.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);
            }
        });
        bdtest = (Button) findViewById(R.id.testbtn);
        bdtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdtest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tdtest.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tdtyp.setVisibility(View.GONE);
                tdtest.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        tdtyp = (TextView) findViewById(R.id.difftxt);
        tdtyp.setVisibility(View.GONE);
        tdtest = (TextView) findViewById(R.id.testtext);
        tdtest.setVisibility(View.GONE);

    }
}