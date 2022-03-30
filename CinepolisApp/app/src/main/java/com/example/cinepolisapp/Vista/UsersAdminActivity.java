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

public class UsersAdminActivity extends AppCompatActivity {
    private Button cargarClientes;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_users);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();

    }

    private void initUI(){
        cargarClientes =findViewById(R.id.button6);
        cargarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), ListaClientesActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }
}
