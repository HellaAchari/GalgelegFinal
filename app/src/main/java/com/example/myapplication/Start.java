package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;


public class Start extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView1, textView2, textView;
    EditText editText;
    ArrayList<String> navneAfBrugere = new ArrayList<>();
    int start;
    ArrayAdapter adapter;
    String fåNavn;
    Gson gson = new Gson();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Type navneHistorik = new TypeToken<ArrayList<String>>(){}.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView6);
        textView = findViewById(R.id.textVieww);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this);
        editText = findViewById(R.id.editText);
        editText.setOnClickListener(this);


        //Listview
        ListView listView = findViewById(R.id.names);

        sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String navne = sharedPreferences.getString("Navne","null");

        if(!navne.equals("null")){
            navneAfBrugere = gson.fromJson(navne,navneHistorik);

        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, navneAfBrugere);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        SharedPreferences sharedPreferences = getSharedPreferences("sidste_Score",MODE_PRIVATE);
        start = sharedPreferences.getInt("sidsteScore", 0);
        textView.setText("Sidste score: "+ start);
    }

    @Override
    public void onClick(View v) {
        fåNavn = editText.getText().toString();
        if (navneAfBrugere.size()<10&&fåNavn.length()<12 && fåNavn.length()!=0){
            navneAfBrugere.add(fåNavn);
            Collections.sort(navneAfBrugere);
            editText.setText("");
            editor.putString("Navne", gson.toJson(navneAfBrugere, navneHistorik));
            editor.apply();
                if (button==v){
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        }
         else{
            navneAfBrugere.remove(0);
            }
        if (fåNavn.length() >12){
            editText.setError("For langt et navn!");
            editText.setText("");
        }
        else if (fåNavn.length() == 0 ){
            editText.setError("Indtast et navn, tak! ");
            editText.setText("");
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
