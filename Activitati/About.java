package com.example.project.Activitati;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.Fragmente.about_info;
import com.example.project.Fragmente.about_rules;
import com.example.project.R;


public class About extends AppCompatActivity {
    Button btnInfo;
    Button btnRules;
    TextView clickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnRules = (Button) findViewById(R.id.buttonRules);
        clickme = (TextView) findViewById(R.id.tvShowMore);

        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInfo.setVisibility(View.VISIBLE);
            }
        });
    }

    public void ChangeFragment(View view){
        Fragment fragment;

        if(view == findViewById(R.id.buttonRules)){
            fragment = new about_rules();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            btnRules.setVisibility(View.INVISIBLE);
            ft.commit();
        }

        if(view == findViewById(R.id.buttonInfo)){
            fragment = new about_info();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            btnRules.setVisibility(View.VISIBLE);
            ft.commit();
        }
    }
}
