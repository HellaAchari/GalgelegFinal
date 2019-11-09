package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.Collections;


public class Start extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView1, textView2, textView;
    ArrayList<Integer> highscore = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView1 = findViewById(R.id.textView5);
        textView2 =findViewById(R.id.textView6);
        button =findViewById(R.id.button2);
        button.setOnClickListener(this);
        ListView listView = findViewById(R.id.highscore);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, highscore);
        listView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void highscoreLise(){
        //TODO: FÅ LISTEN TIL AT VIRKE:
        Intent intent = getIntent();
        int antalFejl = intent.getIntExtra("antalforkerte",0);
        System.out.println(antalFejl);
        for ( int i=0; i < 5; i++){
            highscore.add(antalFejl);
            i++;
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
