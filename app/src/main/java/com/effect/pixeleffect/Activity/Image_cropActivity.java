package com.effect.pixeleffect.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.canhub.cropper.CropImageView;
import com.effect.pixeleffect.R;

public class Image_cropActivity extends AppCompatActivity {

    ImageView done;
    public static CropImageView cropImageView;
    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_crop);

        done = findViewById(R.id.save);
        cropImageView = findViewById(R.id.cropImageView);


        cropImageView.setImageUriAsync(MainActivity.uri);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bitmap = cropImageView.getCroppedImage();

                startActivity(new Intent(Image_cropActivity.this, PhotoEditingActivity.class));
            }
        });
    }
}