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
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.effect.pixeleffect.Effect.Effects;
import com.effect.pixeleffect.Multitouch.MultiTouchListener;
import com.effect.pixeleffect.R;
import com.effect.pixeleffect.adapter.Effect_Adapter;
import com.effect.pixeleffect.adapter.Filter_Adapter;
import com.effect.pixeleffect.adapter.Sticker_Adapter;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class PhotoEditingActivity extends AppCompatActivity {

    public static ImageView image, glare, back, frame_3d;
    ImageView save, img_1, img_2, img_3, img_4, img_5, img_6;
    FrameLayout frame_layout;
    RelativeLayout sticker;

    LinearLayout layout_filter, layout_effect, tools_color;
    LinearLayout tools_3d, tools_effect, tools_filter, tools_glare, tools_rotate, tools_flip, tools_flip_vertical, tools_sticker;

    RecyclerView bottom_Filter_effect, bottom_effect_effect, recycle_sticker;

    int Hour, Minutes, Seconds;
    int i = 0;
    int j = 0;
    int _3d = 0;
    int effect = 0;
    int _glare = 0;
    int filter = 0;

    String[] Filter_name = new String[]{"None", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F20", "F21", "F22"};

    int[] effect_3d_img = new int[]{R.drawable.effect_3d_1, R.drawable.effect_3d_2, R.drawable.effect_3d_3, R.drawable.effect_3d_4, R.drawable.effect_3d_5, R.drawable.effect_3d_6, R.drawable.effect_3d_7
            , R.drawable.effect_3d_8, R.drawable.effect_3d_9, R.drawable.effect_3d_10, R.drawable.effect_3d_11, R.drawable.effect_3d_12, R.drawable.effect_3d_13};


    int[] effect_effect = new int[]{R.drawable.pixel_1, R.drawable.pixel_02, R.drawable.pixel_2, R.drawable.pixel_03, R.drawable.pixel_3
            , R.drawable.pixel_04, R.drawable.pixel_4, R.drawable.pixel_05, R.drawable.pixel_06, R.drawable.pixel_6, R.drawable.pixel_7, R.drawable.pixel_8, R.drawable.pixel_9
            , R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21
            , R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28,
            R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33};

    int[] effect_glare = new int[]{R.drawable.flare_01, R.drawable.flare_02, R.drawable.flare_03, R.drawable.flare_04, R.drawable.flare_05, R.drawable.flare_06};

    int[] sticker_array1 = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9
            , R.drawable.a10, R.drawable.a12, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20, R.drawable.a21
            , R.drawable.a22, R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a28, R.drawable.a29, R.drawable.a30, R.drawable.a32, R.drawable.a34
            , R.drawable.a35, R.drawable.a36};

    int[] sticker_array2 = new int[]{R.drawable.monster_01, R.drawable.monster_02, R.drawable.monster_03, R.drawable.monster_04, R.drawable.monster_05
            , R.drawable.monster_06, R.drawable.monster_07, R.drawable.monster_08, R.drawable.monster_09, R.drawable.monster_10, R.drawable.monster_11, R.drawable.monster_12
            , R.drawable.monster_13, R.drawable.monster_14, R.drawable.monster_15, R.drawable.monster_16, R.drawable.monster_17, R.drawable.monster_18, R.drawable.monster_19
            , R.drawable.monster_20, R.drawable.monster_21, R.drawable.monster_22, R.drawable.monster_23, R.drawable.monster_24, R.drawable.monster_25};


    int[] sticker_array3 = new int[]{R.drawable.l7, R.drawable.l8, R.drawable.l9, R.drawable.l10, R.drawable.l11, R.drawable.l12, R.drawable.l13, R.drawable.l14
            , R.drawable.l15, R.drawable.l16, R.drawable.l17, R.drawable.l18, R.drawable.l19, R.drawable.l20, R.drawable.l21, R.drawable.l22, R.drawable.l23, R.drawable.l24
            , R.drawable.l25, R.drawable.l26, R.drawable.l27, R.drawable.l28, R.drawable.l35, R.drawable.l36, R.drawable.l37, R.drawable.l38, R.drawable.l39, R.drawable.l40
            , R.drawable.l42};

    int[] sticker_array4 = new int[]{R.drawable.wedding01, R.drawable.wedding02, R.drawable.wedding03, R.drawable.wedding04, R.drawable.wedding05, R.drawable.wedding06
            , R.drawable.wedding07, R.drawable.wedding08, R.drawable.wedding09, R.drawable.wedding10, R.drawable.wedding11, R.drawable.wedding12, R.drawable.wedding13
            , R.drawable.wedding14, R.drawable.wedding15, R.drawable.wedding16, R.drawable.wedding17, R.drawable.wedding18, R.drawable.wedding19, R.drawable.wedding20
            , R.drawable.wedding21, R.drawable.wedding22};

    int[] sticker_array5 = new int[]{R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9
            , R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15, R.drawable.s16, R.drawable.s17, R.drawable.s18, R.drawable.s19
            , R.drawable.s20};

    int[] sticker_array6 = new int[]{R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9
            , R.drawable.b10, R.drawable.b12, R.drawable.b14, R.drawable.b15, R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20};

    public static void effects_glare(int i) {

        glare.setImageResource(i);

    }

    public static void effects_3d(int i) {

        frame_3d.setImageResource(i);
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

        bindings();

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


    }

    private void bindings() {
        image = findViewById(R.id.imageView);
        glare = findViewById(R.id.glare);
        frame_3d = findViewById(R.id.frame_3d);
        tools_3d = findViewById(R.id.tools_3d);
        sticker = findViewById(R.id.sticker);
        back = findViewById(R.id.back);
        recycle_sticker = findViewById(R.id.recycle_sticker);

        tools_effect = findViewById(R.id.tools_effect);
        tools_glare = findViewById(R.id.tools_glare);
        tools_rotate = findViewById(R.id.tools_rotate);
        tools_flip = findViewById(R.id.tools_flip);
        tools_flip_vertical = findViewById(R.id.tools_flip_vertical);
        tools_sticker = findViewById(R.id.tools_sticker);

        layout_filter = findViewById(R.id.layout_filter);
        layout_effect = findViewById(R.id.layout_effect);

        tools_filter = findViewById(R.id.tools_filter);
        frame_layout = findViewById(R.id.frame_layout);
        tools_color = findViewById(R.id.tools_color);

        bottom_Filter_effect = findViewById(R.id.bottom_Filter_effect);
        bottom_effect_effect = findViewById(R.id.bottom_effect_effect);

        save = findViewById(R.id.save);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        img_6 = findViewById(R.id.img_6);
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

                if (_3d == 1) {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.GONE);

                    _3d = 0;
                } else {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.VISIBLE);

                    bottom_effect_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    bottom_effect_effect.setAdapter(new Effect_Adapter(PhotoEditingActivity.this, effect_3d_img));

                    _3d++;
                }

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

                if (effect == 1) {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.GONE);

                    effect = 0;
                } else {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.VISIBLE);

                    bottom_effect_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    bottom_effect_effect.setAdapter(new Effect_Adapter(PhotoEditingActivity.this, effect_effect));

                    effect++;
                }
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

        tools_glare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (_glare == 1) {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.GONE);

                    _glare = 0;
                } else {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.VISIBLE);

                    bottom_effect_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    bottom_effect_effect.setAdapter(new Effect_Adapter(PhotoEditingActivity.this, effect_glare));

                    _glare++;
                }

            }
        });

        tools_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (filter == 1) {

                    layout_filter.setVisibility(View.GONE);
                    layout_effect.setVisibility(View.GONE);


                    filter = 0;

                } else {


                    layout_filter.setVisibility(View.VISIBLE);
                    layout_effect.setVisibility(View.GONE);


                    bottom_Filter_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    bottom_Filter_effect.setAdapter(new Filter_Adapter(PhotoEditingActivity.this, Filter_name));

                    filter++;

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sticker.setVisibility(View.GONE);
            }
        });

        tools_sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array1));

                sticker.setVisibility(View.VISIBLE);
            }
        });

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array1));

                sticker.setVisibility(View.VISIBLE);
            }
        });
        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array2));

                sticker.setVisibility(View.VISIBLE);
            }
        });
        img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array3));

                sticker.setVisibility(View.VISIBLE);
            }
        });
        img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array4));

                sticker.setVisibility(View.VISIBLE);
            }
        });
        img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array5));

                sticker.setVisibility(View.VISIBLE);
            }
        });
        img_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                layout_filter.setVisibility(View.GONE);
                layout_effect.setVisibility(View.GONE);


                recycle_sticker.setLayoutManager(new GridLayoutManager(PhotoEditingActivity.this, 3));
                recycle_sticker.setAdapter(new Sticker_Adapter(PhotoEditingActivity.this, sticker_array6));

                sticker.setVisibility(View.VISIBLE);
            }
        });

        tools_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Rotate();

            }
        });

        tools_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rotateY();

            }
        });

        tools_flip_vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rotateX();
            }
        });


        // TODO crash id
        //d19790b223488150
    }

    private void rotateX() {

        int[] angle = new int[]{180, 0};

        image.setRotationX(angle[j]);
        j++;

        if (j == 2) {
            j = 0;
        }
    }

    private void rotateY() {
        int[] angle = new int[]{180, 0};

        image.setRotationY(angle[j]);
        j++;

        if (j == 2) {
            j = 0;
        }
    }

    private void Rotate() {
        int[] angle = new int[]{90, 180, 270, 360};

        image.setRotation(angle[i]);
        i++;

        if (i == 4) {
            i = 0;
        }
    }
}