package com.effect.pixeleffect.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Activity.PhotoEditingActivity;
import com.effect.pixeleffect.Effect.Effects;
import com.effect.pixeleffect.R;

public class Effect_Adapter extends RecyclerView.Adapter<Effect_Adapter.EffectHolder> {

    Activity activity;
    String[] filter_name;

    public Effect_Adapter(PhotoEditingActivity photoEditingActivity, String[] filter_name) {

        activity = photoEditingActivity;
        this.filter_name = filter_name;
    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.effects_layout, parent, false);
        return new EffectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.text.setText(filter_name[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhotoEditingActivity.Filter(position);
            }
        });


        switch (position) {

            case 0:
                Effects.applyEffectNone(holder.image);
                break;

            case 1:
                Effects.applyEffect1(holder.image);
                break;

            case 2:
                Effects.applyEffect2(holder.image);
                break;

            case 3:
                Effects.applyEffect3(holder.image);
                break;

            case 4:
                Effects.applyEffect4(holder.image);
                break;

            case 5:
                Effects.applyEffect5(holder.image);
                break;

            case 6:
                Effects.applyEffect6(holder.image);
                break;

            case 7:
                Effects.applyEffect7(holder.image);
                break;

            case 8:
                Effects.applyEffect8(holder.image);
                break;

            case 9:
                Effects.applyEffect9(holder.image);
                break;

            case 10:
                Effects.applyEffect10(holder.image);
                break;

            case 11:
                Effects.applyEffect11(holder.image);
                break;

            case 12:
                Effects.applyEffect12(holder.image);
                break;

            case 13:
                Effects.applyEffect13(holder.image);
                break;

            case 14:
                Effects.applyEffect14(holder.image);
                break;

            case 15:
                Effects.applyEffect15(holder.image);
                break;

            case 16:
                Effects.applyEffect16(holder.image);
                break;

            case 17:
                Effects.applyEffect17(holder.image);
                break;

            case 18:
                Effects.applyEffect18(holder.image);
                break;

            case 19:
                Effects.applyEffect19(holder.image);
                break;

            case 20:
                Effects.applyEffect20(holder.image);
                break;

            case 21:
                Effects.applyEffect21(holder.image);
                break;

            case 22:
                Effects.applyEffect22(holder.image);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return filter_name.length;
    }

    public class EffectHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }
}
