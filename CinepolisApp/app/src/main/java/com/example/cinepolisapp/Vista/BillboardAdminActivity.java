package com.example.cinepolisapp.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;

public class BillboardAdminActivity extends AppCompatActivity {
    private Button btnVerPeliculas;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_billboard);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();

    }

    private void initUI(){
        btnVerPeliculas = findViewById(R.id.btnSeleccionarPelicula);
        btnVerPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), ListaPeliculasActivity.class);
                intent.putExtra("bandera",2);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }
}
