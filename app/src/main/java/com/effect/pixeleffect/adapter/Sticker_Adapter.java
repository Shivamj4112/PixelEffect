package com.effect.pixeleffect.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Activity.PhotoEditingActivity;
import com.effect.pixeleffect.R;

public class Sticker_Adapter extends RecyclerView.Adapter<Sticker_Adapter.Sticker_holder> {

    Activity activity;
    int[] sticker_array;

    public Sticker_Adapter() {

    }

    public Sticker_Adapter(PhotoEditingActivity photoEditingActivity, int[] sticker_array) {

        activity = photoEditingActivity;
        this.sticker_array = sticker_array;
    }

    @NonNull
    @Override
    public Sticker_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.sticker1_layout, parent, false);
        return new Sticker_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Sticker_holder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(sticker_array[position]);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "" + position, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return sticker_array.length;
    }

    public class Sticker_holder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public Sticker_holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}
