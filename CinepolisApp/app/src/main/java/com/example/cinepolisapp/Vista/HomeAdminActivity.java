package com.example.cinepolisapp.Vista;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.google.android.material.tabs.TabLayout;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_peliculas);
        Auxiliares.asignarBotonesInferiores(this);


    }
}
