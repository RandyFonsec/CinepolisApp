package com.example.cinepolisapp.Vista;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cinepolisapp.R;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("It works");
        Log.d("Alert:","It works");

        cont = 0;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        TabLayout tabLayoutGestion = findViewById(R.id.tabLayout);
        TabLayout.Tab TabMovies = tabLayoutGestion.getTabAt(0);
        FrameLayout FrameLayoutGestion = findViewById(R.id.frameLayoutGestion);
        Button btn = findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.view_gestor);
            }
        });
    }

}