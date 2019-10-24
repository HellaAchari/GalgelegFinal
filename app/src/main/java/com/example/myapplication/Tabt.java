package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Tabt extends AppCompatActivity {
    TextView textView, textView2;
    Animation scaleAnimation, rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt);
        textView =findViewById(R.id.textView25);
        textView.setText("ØVV! Du tabte :-(");
        textView2 = findViewById(R.id.textView2);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Intent intent =getIntent();
        String tabtOrd = intent.getStringExtra("Ordet");
        textView2.setText(tabtOrd);
        textView.startAnimation(scaleAnimation);
        textView2.startAnimation(rotateAnimation);

    }


}
