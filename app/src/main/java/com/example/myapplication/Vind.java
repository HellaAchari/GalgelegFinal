package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Vind extends  AppCompatActivity {
    TextView textView, textView2;
    Animation scaleAnimation;
    Animation rotateAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt);
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView7);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Intent i = getIntent();
        String vinderOrd = i.getStringExtra("VinderOrdet");
        String antalForkerte = i.getStringExtra("AntalForkerte");
        textView2.setText(vinderOrd);
        textView2.startAnimation(scaleAnimation);
        textView.startAnimation(scaleAnimation);
        textView.setText("YAAAY WON: ");
        textView2.startAnimation(rotateAnimation);
    }
}
 //TODO: FIND UD AF HVORFOR DEN IKKE VIRKER
// TODO: VED VIND: START FORFRA OG "SE HIGHSCORE".
// TODO: Hvordan menuen er på hver aktivitet.
//TODO: Hvordan man får vinderbilledet til at blive antal af forkerte.