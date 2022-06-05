package com.effect.pixeleffect;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoEditingActivity extends AppCompatActivity {

    ImageView imageView;

    RecyclerView bottom_effect,bottom_tools;

    int[] mode_image = new int[] {R.drawable.ic_3d,R.drawable.ic_effect,R.drawable.brush,R.drawable.ic_lenseflare,R.drawable.icon_edit,R.drawable.ic_text,
                                  R.drawable.ic_sticker,R.drawable.ic_rotate,R.drawable.ic_flip};
    String[] mode_text = new String[] {"3D","Effect","Color","Glare","Filter","Text","Sticker","Rotate","Flip"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editing);

        imageView = findViewById(R.id.imageView);
        bottom_tools = findViewById(R.id.bottom_tools);
        bottom_effect = findViewById(R.id.bottom_effect);

        imageView.setImageBitmap(Image_cropActivity.bitmap1);
//        imageView.setImageURI(uri);
//        imageView.setImageBitmap(MainActivity.uri);
//        imageView.setImageURI(Image_cropActivity.uri);


        bottom_tools.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this,LinearLayoutManager.HORIZONTAL,false));
        bottom_tools.setAdapter(new Adpater(PhotoEditingActivity.this,mode_image,mode_text));
    }
}