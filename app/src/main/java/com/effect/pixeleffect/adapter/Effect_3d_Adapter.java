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

public class Effect_3d_Adapter extends RecyclerView.Adapter<Effect_3d_Adapter.Effect_3d_holder> {

    Activity activity;
    int[] effect_3d_img;

    public Effect_3d_Adapter() {

    }

    public Effect_3d_Adapter(PhotoEditingActivity photoEditingActivity, int[] effect_3d_img) {

        activity = photoEditingActivity;
        this.effect_3d_img = effect_3d_img;
    }

    @NonNull
    @Override
    public Effect_3d_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.effects_3d_layout, parent, false);
        return new Effect_3d_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Effect_3d_holder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(effect_3d_img[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhotoEditingActivity.effects_3d(effect_3d_img[position]);

            }
        });

    }

    @Override
    public int getItemCount() {
        return effect_3d_img.length;
    }

    public class Effect_3d_holder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public Effect_3d_holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}
