package com.example.firstaid;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizScreen extends AppCompatActivity {

    Toolbar toolbar;
    QAdapter adapter;
    ArrayList<quiz_model> list;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomLayoutManager customLayoutManager;

    int total_score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

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

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new QAdapter(list, getApplicationContext(), new QAdapter.QuizSelection() {
            @Override
            public void onSelect(final int position, String text) {

                if (text.equals(list.get(position).getAns())) {
                    total_score = total_score + 1;
                }

                if (position != list.size()-1) {
                    customLayoutManager.setScrollEnabled(true);

                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.smoothScrollToPosition(position+1);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    customLayoutManager.setScrollEnabled(false);
                                }
                            },500);

                        }
                    },500);
                }
                else {
                    finish();
                }
            }
        });

        customLayoutManager = new CustomLayoutManager(QuizScreen.this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(customLayoutManager);
        customLayoutManager.setScrollEnabled(false);
        recyclerView.setAdapter(adapter);

        list.add(new quiz_model("1","Question 1","","This is kit","99",""));
        list.add(new quiz_model("1","Question 2","","This is kit","99",""));
        list.add(new quiz_model("1","Question 3","","This is kit","99",""));
        list.add(new quiz_model("1","Question 4","","This is kit","99",""));
        adapter.notifyDataSetChanged();
    }

    public class CustomLayoutManager extends LinearLayoutManager {
        private boolean isScrollEnabled = true;

        public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollHorizontally() {
            return isScrollEnabled && super.canScrollHorizontally();
        }
    }
}