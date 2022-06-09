package com.effect.pixeleffect.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Effect.Effects;
import com.effect.pixeleffect.Multitouch.MultiTouchListener;
import com.effect.pixeleffect.R;
import com.effect.pixeleffect.adapter.Effect_3d_Adapter;
import com.effect.pixeleffect.adapter.Effect_Adapter;
import com.effect.pixeleffect.adapter.Filter_Adapter;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class PhotoEditingActivity extends AppCompatActivity {

    public static ImageView image, frame_3d;
    ImageView save;
    FrameLayout frame_layout;

    LinearLayout layout_filter, layout_3d, layout_effect, tools_color;
    LinearLayout tools_3d, tools_effect, tools_filter;

    RecyclerView bottom_Filter_effect, bottom_3d_effect, bottom_effect_effect, bottom_tools;

    int Hour, Minutes, Seconds;

//    int[] mode_image = new int[] {R.drawable.ic_3d,R.drawable.ic_effect,R.drawable.brush,R.drawable.ic_lenseflare,R.drawable.icon_edit,R.drawable.ic_text,
//                                  R.drawable.ic_sticker,R.drawable.ic_rotate,R.drawable.ic_flip};
//    String[] mode_text = new String[] {"3D","Effect","Color","Glare","Filter","Text","Sticker","Rotate","Flip"};

    String[] Filter_name = new String[]{"None", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F20", "F21", "F22"};

    int[] effect_3d_img = new int[]{R.drawable.effect_3d_1, R.drawable.effect_3d_2, R.drawable.effect_3d_3, R.drawable.effect_3d_4, R.drawable.effect_3d_5, R.drawable.effect_3d_6, R.drawable.effect_3d_7
            , R.drawable.effect_3d_8, R.drawable.effect_3d_9, R.drawable.effect_3d_10, R.drawable.effect_3d_11, R.drawable.effect_3d_12, R.drawable.effect_3d_13};


    int[] effect_effect = new int[]{R.drawable.pixel_1, R.drawable.pixel_02, R.drawable.pixel_2, R.drawable.pixel_03, R.drawable.pixel_3
            , R.drawable.pixel_04, R.drawable.pixel_4, R.drawable.pixel_05, R.drawable.pixel_06, R.drawable.pixel_6, R.drawable.pixel_7, R.drawable.pixel_8, R.drawable.pixel_9
            , R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21
            , R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28,
            R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33};

    public static void effects_3d(int i) {

        frame_3d.setImageResource(i);
    }

    public static void effects_effect(int i) {
        frame_3d.setImageResource(i);
    }

    public static void Filter(int position) {

        Log.e("TAG", "Filter: " + position);

        switch (position) {

            case 0:
                Effects.applyEffectNone(image);
                break;

            case 1:
                Effects.applyEffect1(image);
                break;

            case 2:
                Effects.applyEffect2(image);
                break;

            case 3:
                Effects.applyEffect3(image);
                break;

            case 4:
                Effects.applyEffect4(image);
                break;

            case 5:
                Effects.applyEffect5(image);
                break;

            case 6:
                Effects.applyEffect6(image);
                break;

            case 7:
                Effects.applyEffect7(image);
                break;

            case 8:
                Effects.applyEffect8(image);
                break;

            case 9:
                Effects.applyEffect9(image);
                break;

            case 10:
                Effects.applyEffect10(image);
                break;

            case 11:
                Effects.applyEffect11(image);
                break;

            case 12:
                Effects.applyEffect12(image);
                break;

            case 13:
                Effects.applyEffect13(image);
                break;

            case 14:
                Effects.applyEffect14(image);
                break;

            case 15:
                Effects.applyEffect15(image);
                break;

            case 16:
                Effects.applyEffect16(image);
                break;

            case 17:
                Effects.applyEffect17(image);
                break;

            case 18:
                Effects.applyEffect18(image);
                break;

            case 19:
                Effects.applyEffect19(image);
                break;

            case 20:
                Effects.applyEffect20(image);
                break;

            case 21:
                Effects.applyEffect21(image);
                break;

            case 22:
                Effects.applyEffect22(image);
                break;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editing);

        image = findViewById(R.id.imageView);
        frame_3d = findViewById(R.id.frame_3d);
        tools_3d = findViewById(R.id.tools_3d);

        tools_effect = findViewById(R.id.tools_effect);

        layout_filter = findViewById(R.id.layout_filter);
        layout_3d = findViewById(R.id.layout_3d);
        layout_effect = findViewById(R.id.layout_effect);
        tools_color = findViewById(R.id.tools_color);

        tools_filter = findViewById(R.id.tools_filter);
        frame_layout = findViewById(R.id.frame_layout);

        // TODO Recycle View bindings
//        bottom_tools = findViewById(R.id.bottom_tools);
        bottom_Filter_effect = findViewById(R.id.bottom_Filter_effect);
        bottom_3d_effect = findViewById(R.id.bottom_3d_effect);
        bottom_effect_effect = findViewById(R.id.bottom_effect_effect);

        save = findViewById(R.id.save);

//202011032


        image.setImageBitmap(Image_cropActivity.bitmap);

        image.setOnTouchListener(new MultiTouchListener());


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getimagecache();


            }
        });

        toolsClickandLongListener();

        // TODO Recycleview for bottom tools.
//        bottom_tools.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this,LinearLayoutManager.HORIZONTAL,false));
//        bottom_tools.setAdapter(new Adpater(PhotoEditingActivity.this,mode_image,mode_text));
    }

    private void getimagecache() {

        frame_layout.setDrawingCacheEnabled(true);
        frame_layout.buildDrawingCache();
        frame_layout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = frame_layout.getDrawingCache();
        save(bitmap);

    }

    private void save(Bitmap bitmap) {

        Calendar c = Calendar.getInstance();
        Hour = c.get(Calendar.HOUR_OF_DAY);
        Minutes = c.get(Calendar.MINUTE);
        Seconds = c.get(Calendar.SECOND);

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String time = Hour + "" + Minutes + "" + Seconds;
        String date = year + "" + (month + 1) + "" + day;


        // TODO Image save to store it privatly
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//
//
//            String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//
//            File file = new File(getExternalFilesDir(null)+"/"+"SastaEffect");
//            String filename = "IMG-" + date + "-" + time + ".jpg";
//            File myfile = new File(file, filename);
//
//            if (myfile.exists()) {
//
//                myfile.delete();
//            }
//
//
//            saveImage(bitmap, myfile);
//
//        }
//        else{

        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(root + "/Pictures/SastaEffect");
        String filename = "IMG-" + date + "-" + time + ".png";
        File myfile = new File(file, filename);

        if (myfile.exists()) {

            myfile.delete();
        }

        saveImage(bitmap, myfile);

//        }

    }

    private void saveImage(Bitmap bitmap, File myfile) {
        try {


            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(myfile)));

            frame_layout.setDrawingCacheEnabled(false);
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

                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);
                layout_3d.setVisibility(View.VISIBLE);
                bottom_3d_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                bottom_3d_effect.setAdapter(new Effect_3d_Adapter(PhotoEditingActivity.this, effect_3d_img));


            }
        });

        // Tools Effect Click event

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

                layout_filter.setVisibility(View.GONE);
                layout_3d.setVisibility(View.GONE);
                layout_effect.setVisibility(View.VISIBLE);

                bottom_effect_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                bottom_effect_effect.setAdapter(new Effect_Adapter(PhotoEditingActivity.this, effect_effect));
            }
        });

        tools_filter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(PhotoEditingActivity.this, "Filter", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        tools_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                colorpicker();
            }
        });

        tools_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout_3d.setVisibility(View.GONE);
                layout_filter.setVisibility(View.VISIBLE);
                layout_effect.setVisibility(View.GONE);
                bottom_Filter_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                bottom_Filter_effect.setAdapter(new Filter_Adapter(PhotoEditingActivity.this, Filter_name));

            }
        });


        // TODO crash id
        //d19790b223488150
    }

    private void colorpicker() {

        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {


                        frame_3d.setColorFilter(selectedColor);

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .build()
                .show();
    }
}