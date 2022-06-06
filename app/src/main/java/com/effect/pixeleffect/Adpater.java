package com.effect.pixeleffect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adpater extends RecyclerView.Adapter<Adpater.DataHolder>{

    Activity activity;
    int[] mode_image;
    String mode_text[];

    public Adpater(PhotoEditingActivity photoEditingActivity, int[] mode_image, String[] mode_text) {

        activity = photoEditingActivity;
        this.mode_image = mode_image;
        this.mode_text = mode_text;


    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.bottom_effect_layout,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.mode_image.setImageResource(mode_image[position]);
        holder.mode_txt.setText(mode_text[position]);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(activity, ""+mode_text[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mode_image.length;
    }

    class DataHolder extends RecyclerView.ViewHolder {

        ImageView mode_image;
        TextView mode_txt;

        public DataHolder(@NonNull View itemView) {
            super(itemView);

            mode_image = itemView.findViewById(R.id.mode_image);
            mode_txt = itemView.findViewById(R.id.mode_txt);
        }
    }
}
