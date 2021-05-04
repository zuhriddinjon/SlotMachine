package com.softdata.slotmachinezuhriddin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CustomVH> {

    private ArrayList<ImageRvModel> list;
    private int lastPosition = -1;


    public RVAdapter(ArrayList<ImageRvModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CustomVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomVH(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_rv, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(CustomVH holder, int position) {
        holder.getImage().setImageResource(list.get(position % list.size()).getImage());

        setStartAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    private void setStartAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.rv_anim);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public class CustomVH extends RecyclerView.ViewHolder {
        AppCompatImageView image;

        public CustomVH(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_inner_rv);
        }

        AppCompatImageView getImage() {
            return image;
        }
    }
}
