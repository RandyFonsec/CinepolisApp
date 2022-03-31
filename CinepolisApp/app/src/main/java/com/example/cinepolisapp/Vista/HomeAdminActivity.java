package com.example.cinepolisapp.Vista;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Horario;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gestor_peliculas);
        Auxiliares.asignarBotonesInferiores(this);

        test();
    }
    public void test(){
        new AsyncTask<String, String, ArrayList<Horario>>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected ArrayList<Horario> doInBackground(String... strings) {
                return (ArrayList<Horario>)ControladorAplicacion.getInstance().getHorariosDisponibles(1, "2022/03/25");
            }

            @Override
            protected void onPostExecute(ArrayList<Horario> result) {

            }

        }.execute();
    }

}
