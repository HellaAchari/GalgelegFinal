package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Start extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView1, textView2, textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView5);
        textView2 =findViewById(R.id.textView6);
        button =findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        Intent intent =getIntent();
        /*int forsøg = intent.getIntExtra("Forsøg", 0);
        textView.setText("Forsøg brugt:" + forsøg);*/
        //TODO: HVORFOR VIRKER DET IKKE?!
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
