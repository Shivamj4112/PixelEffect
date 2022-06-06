package com.effect.pixeleffect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoEditingActivity extends AppCompatActivity {

    ImageView imageView,save;

    LinearLayout effect_layout;
    LinearLayout tools_3d,tools_effect;

    RecyclerView bottom_effect,bottom_tools;

    int[] mode_image = new int[] {R.drawable.ic_3d,R.drawable.ic_effect,R.drawable.brush,R.drawable.ic_lenseflare,R.drawable.icon_edit,R.drawable.ic_text,
                                  R.drawable.ic_sticker,R.drawable.ic_rotate,R.drawable.ic_flip};
    String[] mode_text = new String[] {"3D","Effect","Color","Glare","Filter","Text","Sticker","Rotate","Flip"};

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

        imageView.setImageBitmap(Image_cropActivity.imageuri);
//        imageView.setImageURI(uri);
//        imageView.setImageBitmap(MainActivity.uri);
//        imageView.setImageURI(Image_cropActivity.uri);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




        toolsClickandLongListener();

        // TODO Recycleview for bottom tools.
//        bottom_tools.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this,LinearLayoutManager.HORIZONTAL,false));
//        bottom_tools.setAdapter(new Adpater(PhotoEditingActivity.this,mode_image,mode_text));
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
          bottom_effect.setLayoutManager(new LinearLayoutManager(PhotoEditingActivity.this, LinearLayoutManager.HORIZONTAL,false));
        bottom_effect.setAdapter(new Adpater(PhotoEditingActivity.this,mode_image,mode_text));


            }
        });

        // 3d Tools Click event

        tools_effect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(PhotoEditingActivity.this, "3D", Toast.LENGTH_SHORT).show();
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