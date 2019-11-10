package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Update extends AppCompatActivity implements View.OnClickListener {
    TextView tx;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        tx = findViewById(R.id.textViewUpdate);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        tx.setText("Har du problemer med at ....");
    }
    @Override
    public void onClick(View v) {
        /*new AsyncTask() {
            String url;
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    url ="https://da.wikipedia.org/wiki/Google_Android" ;
                    InputStream inputStream = new URL(url).openStream();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return e;
                }
                return null;
            }
            @Override
            protected void onPostExecute(Object wikipedialæsning) {
                tx.setText("Læs!:/n" + url);
            }
        }.execute();*/
    }
}
