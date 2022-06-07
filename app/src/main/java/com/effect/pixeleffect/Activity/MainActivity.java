package com.effect.pixeleffect.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.effect.pixeleffect.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView more_vert, image;
    LinearLayout album, start;
    public static Uri uri;
    public static Bitmap bitmap;
    int REQUEST_IMAGE_CODE = 10;
    String file_name = "SastaEffect";


    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;

    String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        onclick();



    }

    private void onclick() {
        start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    requestPermissions(permission,REQUEST_IMAGE_CODE);


                }
                 else{

                    createfolder(file_name);
                    onChooseImage();

                }
            }
        });

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,AlbumActivity.class));
            }
        });

        more_vert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu menu = new PopupMenu(MainActivity.this, more_vert);
                menu.getMenuInflater().inflate(R.menu.home_menu, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {

                            case R.id.rate_us:
                                Toast.makeText(MainActivity.this, "Rate US", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.share:
                                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.more:
                                Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.privacy_policy:
                                Toast.makeText(MainActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });

                menu.show();

            }
        });
    }

    public void onChooseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_IMAGE_CODE);
    }

    private void binding() {
        more_vert = findViewById(R.id.more_vert);
        album = findViewById(R.id.album);
        start = findViewById(R.id.start);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CODE) {

            uri = data.getData();

            Intent intent = new Intent(MainActivity.this, Image_cropActivity.class);
            startActivity(intent);

        }
    }

    private void createfolder(String file_name) {

        File file = Environment.getExternalStoragePublicDirectory("" + file_name);

        if (!file.exists()) {

            file.mkdir();

            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}