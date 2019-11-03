package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tabt extends AppCompatActivity implements View.OnClickListener {
    TextView textView, textView2;
    Button button1, button2;
    Animation scaleAnimation, rotateAnimation;
    MediaPlayer lose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt);
        lose = MediaPlayer.create(Tabt.this,R.raw.losing);
        textView =findViewById(R.id.textView3);
        textView.setText("ØVV! Du tabte :-(");
        textView2 = findViewById(R.id.textView2);
        lose.start();
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Intent intent =getIntent();
        String tabtOrd = intent.getStringExtra("Ordet");
        textView2.setText(tabtOrd);
        textView.startAnimation(scaleAnimation);
        textView2.startAnimation(rotateAnimation);

    }

    @Override
    public void onClick(View v) {
        if(v == button1){
            Intent i = new Intent(this, Start.class);
            startActivity(i);
        }
        if (v==button2){
            Galgelogik galgelogik = new Galgelogik();
            galgelogik.nulstil();
            Intent i = new Intent(this, MainActivity.class);
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
                Toast.makeText(getApplicationContext(), "Der er ingen opdateringerne!", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

}
