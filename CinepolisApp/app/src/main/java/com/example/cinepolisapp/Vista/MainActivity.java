package com.example.cinepolisapp.Vista;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.DAO.AlimentoDAOImplementation;
import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Alimento;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Asiento;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peliculas_disponibles);
        TabLayout t ;

        }
}