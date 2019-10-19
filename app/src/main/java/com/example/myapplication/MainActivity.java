package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    String indtastetBogstav;
    Animation scaleAnimation, rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(galgelogik.getSynligtOrd());
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        editText.setOnClickListener(this);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
    }
    @Override
    public void onClick(View view) {
        if(view == button){
        galgelogik.nulstil();
    }
        textView.setText(galgelogik.getSynligtOrd());
        indtastetBogstav= editText.getText().toString();
        galgelogik.gætBogstav(indtastetBogstav);
        textView2.setText(galgelogik.getBrugteBogstaver().toString());
        editText.setText("");
        billedeSkift();
        tabtEllerVundet();
        errorMessage();
    }

    public void errorMessage(){
        if (indtastetBogstav.length() > 1){
            editText.setError("Kun et bogstav!");
            editText.setText("");
        }
        else if (galgelogik.getAntalForkerteBogstaver() == 6){
            editText.setError("Gætter du forkert, taber du!");
            editText.setText("");
        }
    }
    public void tabtEllerVundet(){
        if (galgelogik.erSpilletTabt()){
            textView.setText(galgelogik.getOrdet());
            textView.startAnimation(scaleAnimation);
            textView2.setText("ØVVV! Du tabte!");
            textView2.startAnimation(rotateAnimation);
        }
        else if(galgelogik.erSpilletVundet()){
            textView.setText(galgelogik.getOrdet());
            textView.startAnimation(scaleAnimation);
            textView2.setText("Yaaay du vandt med, " + galgelogik.getAntalForkerteBogstaver() + ", fejl!");
            textView2.startAnimation(rotateAnimation);
        }
    }

    // Har fået error til halvt virke med rigtige bogstaver og med dobbeltbogstaver.
    //TODO: Se om du kan få skærmbillede 2 til at virke
    // TODO: Start forfra til at virke (check!)
    // TODO: Hjælpe-skærm
    //TODO musik når man har vundet eller tabt
    //TODO: Andre billeder.

    public void billedeSkift(){
        int forkertebogstaver = galgelogik.getAntalForkerteBogstaver();
        switch (forkertebogstaver){
            case 0:
                imageView.setImageResource(R.drawable.galge);
                break;
            case 1:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.forkert6);
                break;
            default:
        }


    }
}
