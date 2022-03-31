package com.example.cinepolisapp.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;

public class GestorPeliculasActivity extends AppCompatActivity {

    private Button btnAgregarPelicula;
    private Button btnModificarEliminarPelicula;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_peliculas);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();
    }

    private void initUI(){
        btnModificarEliminarPelicula = findViewById(R.id.button4);
        btnModificarEliminarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), ListaPeliculasActivity.class);

                intent.putExtra("bandera", 1);

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
        btnAgregarPelicula = findViewById(R.id.btnGestionAgregarPelicula);
        btnAgregarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), AddMovieActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }

}
