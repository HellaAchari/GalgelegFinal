package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Galgelogik galgelogik = new Galgelogik();
    TextView textView, textView2;
    EditText editText;
    Button button;
    ImageView imageView;
    String indtastetBogstav = editText.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(galgelogik.getSynligtOrd());
        textView2 = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        editText.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        galgelogik.gætBogstav(indtastetBogstav);
        billedeSkift();
        textView2.setText(galgelogik.getBrugteBogstaver().toString());
    }

    public void billedeSkift(){
        switch (galgelogik.getAntalForkerteBogstaver()){
            case 0:
                imageView.setImageResource(R.drawable.galge);
            case 1:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert3);
            case 4:
                imageView.setImageResource(R.drawable.forkert4);
            case 5:
                imageView.setImageResource(R.drawable.forkert5);
            case 6:
                imageView.setImageResource(R.drawable.forkert6);
            case 7:
            default:
                imageView.setImageResource(R.drawable.galge);
        }
    }
}
