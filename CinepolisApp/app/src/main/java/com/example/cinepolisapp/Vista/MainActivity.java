package com.example.cinepolisapp.Vista;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;



public class MainActivity extends AppCompatActivity {
    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_peliculas);

        Auxiliares.asignarBotonesInferiores(this);


        }
}