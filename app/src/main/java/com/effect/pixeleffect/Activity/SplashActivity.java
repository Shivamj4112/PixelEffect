package com.effect.pixeleffect.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.effect.pixeleffect.R;


public class SplashActivity extends AppCompatActivity {

    TextView anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        anim = findViewById(R.id.anim);

        anim.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, android.R.anim.fade_in));

        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.blink);
        anim.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);

    }
}