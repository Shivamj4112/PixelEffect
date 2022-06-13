package com.effect.pixeleffect.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Activity.PhotoEditingActivity;
import com.effect.pixeleffect.R;

public class Effect_Adapter extends RecyclerView.Adapter<Effect_Adapter.Effect_holder> {

    Activity activity;
    int[] effect_effect;

    public Effect_Adapter() {

    }

    public Effect_Adapter(PhotoEditingActivity photoEditingActivity, int[] effect_effect) {

        activity = photoEditingActivity;
        this.effect_effect = effect_effect;
    }

    @NonNull
    @Override
    public Effect_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.effects_layout, parent, false);
        return new Effect_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Effect_holder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(effect_effect[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhotoEditingActivity.effects_effect(effect_effect[position]);


            }
        });

    }

    @Override
    public int getItemCount() {
        return effect_effect.length;
    }

    public class Effect_holder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public Effect_holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}
