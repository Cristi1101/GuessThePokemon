package com.example.project.Activitati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;
import com.example.project.Servicii.BackgroundSoundService;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnAnswers, btnAbout, btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent svc = new Intent(MainActivity.this, BackgroundSoundService.class);
        startService(svc);


        btnPlay = (Button)findViewById(R.id.buttonStartGame);
        btnAnswers = (Button)findViewById(R.id.buttonAnswers);
        btnAbout = (Button)findViewById(R.id.buttonAbout);
        btnLogin = (Button)findViewById(R.id.buttonLogin);
        btnRegister = (Button)findViewById(R.id.buttonRegister);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play_activity = new Intent(MainActivity.this, Start.class);
                startActivity(play_activity);

            }
        });

        btnAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent answers_activity = new Intent(MainActivity.this, Answers.class);
                startActivity(answers_activity);

            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(MainActivity.this, About.class);
                startActivity(about_activity);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_activity = new Intent(MainActivity.this, Login.class);
                startActivity(login_activity);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_activity = new Intent(MainActivity.this, Register.class);
                startActivity(login_activity);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent svc = new Intent(MainActivity.this, BackgroundSoundService.class);
        stopService(svc);

    }
}
