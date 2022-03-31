package com.example.cinepolisapp.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.google.android.material.tabs.TabLayout;

public class AlimentoAdminActivity extends AppCompatActivity {

    private Button btnAgregarAlimento;
    private Button btnModificarEliminarAlimento;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_alimento);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();
    }

    private void initUI(){
        btnModificarEliminarAlimento = findViewById(R.id.button8);
        btnModificarEliminarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), ListaAlimentosActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
        btnAgregarAlimento = findViewById(R.id.button7);
        btnAgregarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), AddFoodActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }


}
