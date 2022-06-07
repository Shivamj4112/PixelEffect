package com.effect.pixeleffect.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.R;
import com.effect.pixeleffect.adapter.Effect_Adapter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class PhotoEditingActivity extends AppCompatActivity {

    ImageView imageView, save;

    LinearLayout effect_layout;
    LinearLayout tools_3d, tools_effect;

    RecyclerView bottom_effect, bottom_tools;

    int Hour, Minutes, Seconds;

    String file_name = "SastaEffct";

//    int[] mode_image = new int[] {R.drawable.ic_3d,R.drawable.ic_effect,R.drawable.brush,R.drawable.ic_lenseflare,R.drawable.icon_edit,R.drawable.ic_text,
//                                  R.drawable.ic_sticker,R.drawable.ic_rotate,R.drawable.ic_flip};
//    String[] mode_text = new String[] {"3D","Effect","Color","Glare","Filter","Text","Sticker","Rotate","Flip"};


    int[] Filter_img = new int[]{R.drawable.effect_photo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editing);

        imageView = findViewById(R.id.imageView);
        tools_3d = findViewById(R.id.tools_3d);
        tools_effect = findViewById(R.id.tools_effect);

        effect_layout = findViewById(R.id.effect_layout);

        // TODO Recycle View bindings
//        bottom_tools = findViewById(R.id.bottom_tools);
        bottom_effect = findViewById(R.id.bottom_effect);
        save = findViewById(R.id.save);

//202011032


        imageView.setImageBitmap(Image_cropActivity.bitmap);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveImage();;

            }
        });

        toolsClickandLongListener();

        // TODO Recycleview for bottom tools.
//        bottom_tools.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this,LinearLayoutManager.HORIZONTAL,false));
//        bottom_tools.setAdapter(new Adpater(PhotoEditingActivity.this,mode_image,mode_text));
    }

    private void saveImage() {

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        imageView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = imageView.getDrawingCache();
        save(bitmap);

    }

    private void save(Bitmap bitmap) {

        Calendar c = Calendar.getInstance();
        Hour = c.get(Calendar.HOUR_OF_DAY);
        Minutes = c.get(Calendar.MINUTE);
        Seconds = c.get(Calendar.SECOND);

        String time = Hour + "" + Minutes + "" + Seconds;

        Calendar ca = Calendar.getInstance();
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int month = ca.get(Calendar.MONTH);
        int year = ca.get(Calendar.YEAR);
        String date = year + "" + (month + 1) + "" + day;


        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String root = Environment.getExternalStorageDirectory()+"/SastaEffect";
        File file = new File(root + "/SastaEffect");
        String filename = "IMG-" + date + "-" + time + ".jpg";
        File myfile = new File(file, filename);


//        createfolder(file_name);

        if (myfile.exists()) {

            myfile.delete();
        }

        try {


            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

            imageView.setDrawingCacheEnabled(false);
        } catch (Exception e) {

            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    private void toolsClickandLongListener() {

        // 3d Tools Click event

        tools_3d.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(PhotoEditingActivity.this, "3D", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        tools_3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                effect_layout.setVisibility(View.VISIBLE);
                bottom_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                bottom_effect.setAdapter(new Effect_Adapter(PhotoEditingActivity.this, Filter_img));


            }
        });

        // 3d Tools Click event

        tools_effect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(PhotoEditingActivity.this, "Effect", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        tools_effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PhotoEditingActivity.this, "Effect Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


}