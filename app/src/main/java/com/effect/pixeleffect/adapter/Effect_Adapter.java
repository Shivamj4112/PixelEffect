package com.effect.pixeleffect.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Activity.PhotoEditingActivity;

public class Effect_Adapter extends RecyclerView.Adapter<Effect_Adapter.EffectHolder> {

    Activity activity;
    int[] filter_img;

    public Effect_Adapter(PhotoEditingActivity photoEditingActivity, int[] filter_img) {

        activity = photoEditingActivity;
        this.filter_img = filter_img;
    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EffectHolder extends RecyclerView.ViewHolder {
        public EffectHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
