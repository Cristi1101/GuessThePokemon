package com.example.project.Activitati;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.Servicii.BackgroundSoundService;

public class MenuAfterLogin extends AppCompatActivity {

    Button btnPlay1, btnAnswers1, btnAbout1, btnHighscore, btnLogout;
    TextView textviewPikaSound1, textviewSquirtleSound1, textviewCharmanderSound1, textviewBulbasaurSound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_after_login);

        //Intent svc = new Intent(MainActivityAfterLogin.this, BackgroundSoundService.class);
        //startService(svc);

        final MediaPlayer pikachuSound = MediaPlayer.create(this, R.raw.pikachusound);
        final MediaPlayer bulbasaurSound = MediaPlayer.create(this, R.raw.bulbasaursound);
        final MediaPlayer squirtleSound = MediaPlayer.create(this, R.raw.squirtlesound);
        final MediaPlayer charmanderSound = MediaPlayer.create(this, R.raw.charmandersound);

        textviewPikaSound1 = (TextView) findViewById(R.id.tvSoundPikachuA);
        textviewSquirtleSound1 = (TextView) findViewById(R.id.tvSoundSquirtleA);
        textviewCharmanderSound1 = (TextView) findViewById(R.id.tvSoundCharmanderA);
        textviewBulbasaurSound1 = (TextView) findViewById(R.id.tvSoundBulbasaurA);


        btnPlay1 = (Button)findViewById(R.id.buttonStartGameA);
        btnAnswers1 = (Button)findViewById(R.id.buttonAnswersA);
        btnAbout1 = (Button)findViewById(R.id.buttonAboutA);
        btnHighscore = (Button)findViewById(R.id.buttonHighScoreA);
        btnLogout = (Button)findViewById(R.id.buttonLogOutA);

        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play_activity = new Intent(MenuAfterLogin.this, StartAfterLogin.class);
                startActivity(play_activity);

            }
        });

        btnAnswers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent answers_activity = new Intent(MenuAfterLogin.this, Answers.class);
                startActivity(answers_activity);

            }
        });

        btnAbout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(MenuAfterLogin.this, About.class);
                startActivity(about_activity);

            }
        });

        btnHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(MenuAfterLogin.this, HighScore.class);
                startActivity(about_activity);

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(MenuAfterLogin.this, MainActivity.class);
                startActivity(about_activity);

            }
        });

        textviewPikaSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent svc = new Intent(MenuAfterLogin.this, BackgroundSoundService.class);
                stopService(svc);
                Toast.makeText(getApplicationContext(), "Sound off. Tap on Bulbasaur to turn it on!", Toast.LENGTH_LONG).show();
                pikachuSound.start();


            }
        });

        textviewSquirtleSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squirtleSound.start();
            }
        });

        textviewCharmanderSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charmanderSound.start();
            }
        });

        textviewBulbasaurSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent svc = new Intent(MenuAfterLogin.this, BackgroundSoundService.class);
                startService(svc);
                Toast.makeText(getApplicationContext(), "Sound on. Tap on Pikachu to turn it off!", Toast.LENGTH_LONG).show();
                bulbasaurSound.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent svc = new Intent(MenuAfterLogin.this, BackgroundSoundService.class);
        stopService(svc);

    }

}
