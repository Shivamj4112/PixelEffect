package com.effect.pixeleffect.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.effect.pixeleffect.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView more_vert, image;
    LinearLayout album, start;
    public static Uri uri;
    final int REQUEST_IMAGE_CODE = 10;
    String file_name = "SastaEffect";
    TextView apps;

    private static final String TAG = MainActivity.class.getSimpleName();

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

                    isStoragePermissionGranted1();

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
        apps = findViewById(R.id.apps);
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

    //  TODO create folder for android 11+ devices
//    private File createfolder1(String file_name) {
//
//        File file = new File(getExternalFilesDir(null)+"/"+file_name);
//
//        if (!file.exists()) {
//
//            file.mkdir();
//            Toast.makeText(this, "f1 success", Toast.LENGTH_SHORT).show();
//
//        } else {
//            Toast.makeText(this, "f1 Fail", Toast.LENGTH_SHORT).show();
//        }
//
//        return file;
//    }

    private void createfolder2(String file_name) {

        File file = new File(Environment.getExternalStorageDirectory(), "/Pictures" + "/" + file_name);

        if (!file.exists()) {

            file.mkdir();

        } else {
            Toast.makeText(this, "Welcome Back", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isStoragePermissionGranted1() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.v("Ssss", "Permission is granted");

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

//                    createfolder1(file_name); // TODO create folder for android 11+ devices
                createfolder2(file_name);
                onChooseImage();
                requestPermissions(permission, REQUEST_IMAGE_CODE);

//                }
//                else{
//
//                    createfolder2(file_name);
//                    onChooseImage();
//                }


                return true;
            } else {

                Log.v("Ssss", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Ssss", "Permission is granted");

            createfolder2(file_name);
            onChooseImage();

            return true;
        }
    }
}