package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Vind extends  AppCompatActivity implements View.OnClickListener {
    TextView textView, textView1, textView2;
    Button button, button1;
    Animation scaleAnimation;
    Animation rotateAnimation;
    Galgelogik galgelogik = new Galgelogik();
    int score;
    MediaPlayer vind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt);
        vind = MediaPlayer.create(Vind.this, R.raw.winning);
        textView2 = findViewById(R.id.textView2);
        //textView1 = findViewById(R.id.textView4);
        textView = findViewById(R.id.textView3);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Intent i = getIntent();
        String vinderOrd = i.getStringExtra("VinderOrdet");
        String antalFejl = i.getStringExtra("AntalFejl");
        textView2.setText(vinderOrd);
        textView2.startAnimation(scaleAnimation);
        textView.startAnimation(scaleAnimation);
        textView.setText("YAAAY du vandt med: " + antalFejl +" fejl!");
        textView2.startAnimation(rotateAnimation);
        vind.start();
        button = findViewById(R.id.button1);
        button.setOnClickListener(this);
        button1 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == button){
            Intent i = new Intent(this, Start.class);
            startActivity(i);
        }
        else if (v == button1){
            Intent i = new Intent (this, MainActivity.class);
            startActivity(i);
        }
    }
}


// TODO: Highscore og score.
//TODO: Hvordan man får vinderbilledet til at blive antal af forkerte.