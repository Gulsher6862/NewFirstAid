package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Heart_Stroke extends AppCompatActivity {

    Button bw,bsymtoms,bdiagn;
    TextView tw,tsymtoms,tdiagn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart__stroke);
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
                tsymtoms.setVisibility(View.GONE);
                tdiagn.setVisibility(View.GONE);
            }
        });
        bsymtoms = (Button) findViewById(R.id.symtomsbtn);
        bsymtoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bsymtoms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tsymtoms.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymtoms.setVisibility(View.VISIBLE);
                tdiagn.setVisibility(View.GONE);
            }
        });
        bdiagn = (Button) findViewById(R.id.diagnbtn);
        bdiagn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdiagn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tdiagn.setVisibility(View.GONE);
                    }
                });
                tw.setVisibility(View.GONE);
                tsymtoms.setVisibility(View.GONE);
                tdiagn.setVisibility(View.VISIBLE);
            }
        });
        tw = (TextView) findViewById(R.id.whattxt);
        tw.setVisibility(View.GONE);
        tsymtoms = (TextView) findViewById(R.id.symtomstxt);
        tsymtoms.setVisibility(View.GONE);
        tdiagn = (TextView) findViewById(R.id.diagntxt);
        tdiagn.setVisibility(View.GONE);
    }
}