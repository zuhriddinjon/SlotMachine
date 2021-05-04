package com.softdata.slotmachinezuhriddin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainJavaActivity extends AppCompatActivity {

    private AppCompatButton btn;
    private ArrayList<ImageRvModel> list = new ArrayList<>();
    private RVAdapter adapter;
    private RecyclerView rv1, rv2, rv3;
    private Random random1, random2, random3;
    private RecyclerViewDisabler disabler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_start);
        disabler = new RecyclerViewDisabler(true);

        setInitialData();

        adapter = new RVAdapter(list);

        rv1 = findViewById(R.id.rv_1);
        rv1.setAdapter(adapter);
        disabler.setEnable(false);
        rv1.addOnItemTouchListener(disabler);

        rv2 = findViewById(R.id.rv_2);
        rv2.addOnItemTouchListener(disabler);
        rv2.setAdapter(adapter);

        rv3 = findViewById(R.id.rv_3);
        rv3.addOnItemTouchListener(disabler);
        rv3.setAdapter(adapter);

        btn.setOnClickListener(v -> clickStart());
    }

    private void setInitialData() {
        list.add(new ImageRvModel(R.drawable.apple));
        list.add(new ImageRvModel(R.drawable.car));
        list.add(new ImageRvModel(R.drawable.flower));
        list.add(new ImageRvModel(R.drawable.piano));
    }

    private void clickStart() {
        random1 = new Random(200);
        random2 = new Random(200);
        random3 = new Random(200);

        disabler.setEnable(true);

        rv1.smoothScrollToPosition(random1.nextInt());
        rv2.scrollToPosition(random2.nextInt());
        rv3.scrollToPosition(random3.nextInt());

    }
}
