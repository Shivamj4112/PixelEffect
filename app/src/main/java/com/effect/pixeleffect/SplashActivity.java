package com.effect.pixeleffect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


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
            }
        },4000);

    }
}