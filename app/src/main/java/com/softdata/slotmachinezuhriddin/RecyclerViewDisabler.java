package com.softdata.slotmachinezuhriddin;

import android.view.MotionEvent;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewDisabler implements RecyclerView.OnItemTouchListener {

    boolean isEnable = true;

    public RecyclerViewDisabler(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return !isEnable;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){}
}
