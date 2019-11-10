package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;


public class Start extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView1, textView2, textView;
    ArrayList<Integer> highscore = new ArrayList<>(10);
    int antalFejl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView6);
        textView = findViewById(R.id.textVieww);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this);
        //Listview
        ListView listView = findViewById(R.id.highscore);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, highscore);
        listView.setAdapter(adapter);

        //TODO: VIRKER IKKE? GEMME LOKALT VIRKER IKKE
        Intent intent = getIntent();
        antalFejl = intent.getIntExtra("antalforkerte", 0);
        textView.setText("Sidste score: "+ antalFejl);

        //TODO: FÅ LISTEN TIL AT VIRKE:VIRKER STADIG IKKE!
        System.out.println(antalFejl);
        sethighScore();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void sethighScore(){
        for (int i = 0; i < 5; i++) {
            highscore.add(antalFejl);}

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

    }public void savedata(){
        SharedPreferences sharedPreferences = getSharedPreferences("high score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(highscore);
        editor.putString("Highscore", json);
        editor.apply();
    }


}
