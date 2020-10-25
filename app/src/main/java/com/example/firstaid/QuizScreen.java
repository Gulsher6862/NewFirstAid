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

        list.add(new quiz_model("1","Why do you apply pressure to a wound that is bleeding?","To take the person's mind off their bleeding and stop them from feeling sick","To stop ot slow down the flow of blood","To reduce pain and risk of infection",""));
        list.add(new quiz_model("1","Which of following could indicate that someone is having a heart attack?","Sweating","Sore toes","Pain in arms",""));
        list.add(new quiz_model("1","You are at a family get together and your uncle starts complaining of severe crushing pains in his chest. Whose advice should you listen to?","Uncle Larry,Oh he will be alright, Let him rest for half an hour. It's probably just last night's dinner. ","Cousin Tim, Sit him down and call an ambulance right away","Nan, Just help him upstairs to lie down",""));
        list.add(new quiz_model("1","You are in a busy cafe. You notice that a woman on the table next to you has stopped talking, is turning red and clutching her throat. You ask her if she is choking and she nods yes. She is panicking and can't breathe. What do you do next?","Encourage her to try and breathe through her nose","Help her drink some water","Hit her firmly on her back 5 times followed by 5 quick abdominal thrusts",""));
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