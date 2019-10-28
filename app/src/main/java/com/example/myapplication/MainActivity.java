package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Galgelogik galgelogik = new Galgelogik();
    TextView textView, textView2, textView3;
    EditText editText;
    Button button;
    ImageView imageView;
    String indtastetBogstav;
    String ordet;
    Animation scaleAnimation, rotateAnimation;
    int score;
    String vinderOrdet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textVieww);
        textView.setText(galgelogik.getSynligtOrd());
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
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
        indtastetBogstav= editText.getText().toString();
        galgelogik.gætBogstav(indtastetBogstav);
        textView.setText(galgelogik.getSynligtOrd());
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
            ordet = galgelogik.getOrdet();
            Intent i = new Intent(this, Tabt.class);
            i.putExtra("Ordet", ordet);
            i.putExtra("AntalF", galgelogik.getAntalForkerteBogstaver());
            startActivity(i);
        }
        else if(galgelogik.erSpilletVundet()){
            vinderOrdet = galgelogik.getOrdet();
            Intent intent = new Intent(this, Vind.class);
            intent.putExtra("VinderOrdet", vinderOrdet);
            intent.putExtra("AntalForkerte", galgelogik.getAntalForkerteBogstaver());
            startActivity(intent);
        }
    }

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


    // TODO: Lav en taber/vinder skærm: Hvordan får jeg "synligt ord" og scoren(antal) forkerte med over?
    //TODO: Hvordan fjerner man keyboarded?
}
