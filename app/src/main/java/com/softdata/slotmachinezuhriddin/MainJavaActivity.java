package com.softdata.slotmachinezuhriddin;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.Random;

public class MainJavaActivity extends AppCompatActivity {

    private AppCompatButton btn;
    private ArrayList<ImageRvModel> list = new ArrayList<>();
    private RVAdapter adapter;
    private RecyclerView rv1, rv2, rv3;
    private Random random1, random2, random3;
    private RecyclerViewDisabler disabler;
    SnapHelper snapHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_start);
        disabler = new RecyclerViewDisabler(true);

        snapHelper= new PagerSnapHelper();
        random1 = new Random();

        setInitialData();
        initRV();
        btn.setOnClickListener(v -> clickStart());
    }

    private void setInitialData() {
//        list.add(new ImageRvModel(R.drawable.apple));
//        list.add(new ImageRvModel(R.drawable.car));
        list.add(new ImageRvModel(R.drawable.flower));
        list.add(new ImageRvModel(R.drawable.bath));
        list.add(new ImageRvModel(R.drawable.piano));
    }

    private void initRV() {
        adapter = new RVAdapter(list);

        rv1 = findViewById(R.id.rv_1);
        rv1.setAdapter(adapter);
        disabler.setEnable(false);
        rv1.addOnItemTouchListener(disabler);
        snapHelper.attachToRecyclerView(rv1);


        rv2 = findViewById(R.id.rv_2);
        rv2.addOnItemTouchListener(disabler);
        rv2.setAdapter(adapter);

        rv3 = findViewById(R.id.rv_3);
        rv3.addOnItemTouchListener(disabler);
        rv3.setAdapter(adapter);
        snapHelper.attachToRecyclerView(rv3);
    }

    private void clickStart() {

        Log.d("TAG", "clickStart:" + random1);


        rv3.smoothScrollToPosition(random1.nextInt(200));
        rv1.smoothScrollToPosition(random1.nextInt(200));
        rv2.smoothScrollToPosition(random1.nextInt(200));
        snapHelper.attachToRecyclerView(rv1);
        snapHelper.attachToRecyclerView(rv2);
        snapHelper.attachToRecyclerView(rv3);
//        rv3.requestFocus();

        disabler.setEnable(false);
    }
}
