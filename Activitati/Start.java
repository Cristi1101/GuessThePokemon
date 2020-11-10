package com.example.project.Activitati;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;

public class Start extends AppCompatActivity {
    TextView vieti, timer, puncte, textcorect, textincorect;
    ImageView imagine;
    EditText text;
    Button btnCofirm;

    int intpuncte = 0;
    int intvieti = 3;
    int numargenerat = 0;

    String [] nume_pokemoni = {"beedrill", "caterpie", "charmander", "clefairy", "diglett", "ekans",
                                "gloom", "jigglypuff", "kakuna", "krabby", "mankey", "meowth", "nidoran", "paras", "pidgey",
                                "pikachu", "psyduck", "rattata", "sandshrew", "squirtle", "venonat", "vulpix", "zubat"};

    String [] imagini_pokemoni = {"img1", "img2", "img3", "img4", "img5", "img6", "img7", "img8", "img9", "img10", "img11", "img12",
                                "img13", "img14", "img15", "img16", "img17", "img18", "img19", "img20", "img21", "img22", "img23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        vieti = (TextView) findViewById(R.id.tvLives);
        timer = (TextView) findViewById(R.id.tvTimer);
        puncte = (TextView) findViewById(R.id.tvScore);
        imagine = (ImageView) findViewById(R.id.ivStart);
        text = (EditText) findViewById(R.id.editText);
        btnCofirm = (Button) findViewById(R.id.buttonConfirm);

        textcorect = (TextView) findViewById(R.id.tvCorect);
        textincorect = (TextView) findViewById(R.id.tvIncorect);

        establishImage(numargenerat);

        btnCofirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textconfirm = text.getText().toString().toLowerCase();
                if(textconfirm.equals(nume_pokemoni[numargenerat])){
                    textcorect.setVisibility(View.VISIBLE);
                    intpuncte = intpuncte + 1;
                    puncte.setText("SCORE: "+intpuncte);

                    if(intpuncte == 23){
                        youwin();
                    }else{
                        wait1();
                    }
                }
                else{
                    textincorect.setVisibility(View.VISIBLE);
                    intvieti = intvieti - 1;
                    vieti.setText("LIVES: "+intvieti);

                    if(intvieti == 0){
                        tryagain();
                    }
                    else {
                        wait2();
                    }
                }
            }
        });

    }

    void wait1(){ //daca e corect
        new CountDownTimer(1500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnCofirm.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                btnCofirm.setVisibility(View.VISIBLE);
                numargenerat = numargenerat + 1;
                establishImage(numargenerat);
                textcorect.setVisibility(View.INVISIBLE);
                text.setText("");
                text.setHint("type pokemon's name here");
            }
        }.start();
    }

    void wait2(){ //daca e incorect
        new CountDownTimer(1500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnCofirm.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btnCofirm.setVisibility(View.VISIBLE);
                textincorect.setVisibility(View.INVISIBLE);
                text.setText("");
                text.setHint("type pokemon's name here");
            }
        }.start();
    }

    void tryagain(){
        new CountDownTimer(1500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnCofirm.setVisibility(View.GONE);
                text.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "You Lost! Score: "+intpuncte, Toast.LENGTH_LONG).show();
                Intent revine_la_meniu = new Intent(Start.this, MainActivity.class);
                startActivity(revine_la_meniu);
            }
        }.start();
    }

    void youwin(){
        new CountDownTimer(1500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnCofirm.setVisibility(View.GONE);
                text.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "You Won! Score: "+intpuncte, Toast.LENGTH_LONG).show();
                Intent revine_la_meniu = new Intent(Start.this, MainActivity.class);
                startActivity(revine_la_meniu);
            }
        }.start();
    }

    void establishImage(int numar){
        int id = getResources().getIdentifier(imagini_pokemoni[numar], "mipmap", getPackageName());
        imagine.setImageResource(id);
    }
}
