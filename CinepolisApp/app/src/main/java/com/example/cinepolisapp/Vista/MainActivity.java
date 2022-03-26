package com.example.cinepolisapp.Vista;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Asiento;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;

import java.util.ArrayList;
import java.util.List;


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

        test();
        }
        public void test(){

            new AsyncTask<String, String, List<Asiento>>() {
                @Override
                protected List<Asiento> doInBackground(String... strings) {
                    ControladorAplicacion c = ControladorAplicacion.getInstance();
                    List<Asiento>pelis = c.getAsientosDeFuncion(1);
                    return pelis;
                }
                @Override
                protected void onPostExecute(List<Asiento> result) {
                    if(result!=null){
                        for (Asiento peli: result) {
                            System.out.println(peli);
                        }
                    }

                }
                @Override
                protected void onPreExecute(){
                    Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
                }
            }.execute();
        }

        }
