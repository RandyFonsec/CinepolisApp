package com.example.cinepolisapp.Vista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;

public class ConfigFuncionActivity extends AppCompatActivity {

    private Pelicula pelicula;
    private EditText nombrePelicula;
    private Button btnAsignar;
    private Spinner spinnerSala, spinnerHorario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion_funcion);
        Auxiliares.asignarBotonesInferiores(this);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            this.pelicula = (Pelicula) parametros.getSerializable("Pelicula");
        }
        initUI();


    }

    private void initUI() {
        nombrePelicula = findViewById(R.id.NombrePeliculaConfig);

        nombrePelicula.setFocusable(false);
        nombrePelicula.setText(pelicula.getTitulo());

        spinnerSala = findViewById(R.id.spinnerSala);
        spinnerHorario = findViewById(R.id.spinnerHorario);

        btnAsignar = findViewById(R.id.Asignar_Config_Funcion_btn);


    }
}
