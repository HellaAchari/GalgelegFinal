package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help extends AppCompatActivity implements View.OnClickListener {
    TextView tx;
    Button buttonnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        tx = findViewById(R.id.textViewUpdate);
        buttonnn = findViewById(R.id.button);
        buttonnn.setOnClickListener(this);
        tx.setText("Har du problemer med at ....");
    }
    @Override
    public void onClick(View v) {
        finish();
        }
}
