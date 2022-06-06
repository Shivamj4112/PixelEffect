package com.effect.pixeleffect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.canhub.cropper.CropImageView;

public class Image_cropActivity extends AppCompatActivity {

    ImageView done;
    public static CropImageView cropImageView;
//    public static Bitmap bitmap1;
  public static Bitmap imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_crop);

        done = findViewById(R.id.done);
        cropImageView = findViewById(R.id.cropImageView);

//        cropImageView.setImageBitmap(bitmap);

        //     imageuri=getIntent().getData();

//        imageuri = MainActivity.uri;

//        cropImageView.setImageUriAsync(imageuri);
        cropImageView.setImageUriAsync(MainActivity.uri);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                bitmap1 =  cropImageView.getCroppedImage();
                imageuri = cropImageView.getCroppedImage();

//                cropImageView.getCroppedImage();
                startActivity(new Intent(Image_cropActivity.this,PhotoEditingActivity.class));
            }
        });
    }
}