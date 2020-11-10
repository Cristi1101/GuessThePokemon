package com.example.project.Activitati;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.R;

public class HighScore extends AppCompatActivity {
    TextView tv_score, tv_tip;
    Button reset;

    int lastScore;
    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        tv_score = (TextView) findViewById(R.id.tvScore);
        tv_tip = (TextView) findViewById(R.id.tvTip);
        reset = (Button) findViewById(R.id.buttonReset);

        //load scores
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);

        //replace if there is a highscore
        if(lastScore > best3){
            best3 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();
        }

        if(lastScore > best2){
            int temp = best2;
            best2 = lastScore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();
        }

        if(lastScore > best1){
            int temp = best1;
            best1 = lastScore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();
        }

        if(lastScore >= 10 || best1 >= 10 || best2 >= 10 || best3 >= 10){
            tv_tip.setVisibility(View.VISIBLE);
        }
        //display
        tv_score.setText("LAST SCORE: "+ lastScore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear().commit();

                tv_score.setText("LAST SCORE: 0" + "\n" +
                        "BEST1: 0" + "\n" +
                        "BEST2: 0" + "\n" +
                        "BEST3: 0");

            }
        });
    }
}
