package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jinatonic.confetti.CommonConfetti;

public class Vind extends  AppCompatActivity implements View.OnClickListener {
    TextView textView, textView2;
    Button button, button1;
    Animation scaleAnimation;
    Animation rotateAnimation;
    int score;
    MediaPlayer vind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind);
        vind = MediaPlayer.create(Vind.this, R.raw.winning);
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView3);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Intent i = getIntent();
        String vinderOrd = i.getStringExtra("VinderOrdet");
        int antalFejl = i.getIntExtra("AntalFejl",-1);

        final ViewGroup container = findViewById(R.id.vinderSkærmBillede);

        textView2.setText(vinderOrd);
        textView2.startAnimation(scaleAnimation);
        textView.startAnimation(scaleAnimation);
        textView.setText("YAY! Du vandt med: " + antalFejl +" fejl!");
        score = antalFejl;
        textView2.startAnimation(rotateAnimation);
        vind.start();
        button = findViewById(R.id.button1);
        button.setOnClickListener(this);
        button1 = findViewById(R.id.button2);
        button1.setOnClickListener(this);

        final Handler confetti = new Handler();

        Runnable runnableConfetti = new Runnable() {
            @Override
            public void run() {
                CommonConfetti.rainingConfetti(container, new int[] { Color.RED,Color.MAGENTA}).infinite();
            }
        };
        confetti.postDelayed(runnableConfetti,100);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_hjælp:
                Intent i = new Intent(this, Help.class );
                startActivity(i);
                break;
            case R.id.action_setting:
                Toast.makeText(getApplicationContext(), "Setting er valgt(gør intet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_update:
                Toast.makeText(getApplicationContext(), "Gå til spillet for at hente et ord!", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}