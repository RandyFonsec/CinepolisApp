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
        setContentView(R.layout.fragment_gestor_alimento);
        Alerta.showAlert(MainActivity.this, "Hola","Esto es una alerta");
        TabLayout t ;
        t.
/*
        Spinner spinner = findViewById(R.id.EsquemaVacunacionSpinner);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        System.out.println("It works");
        Log.d("Alert:","It works");

        cont = 0;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;


        //probarAlimentos();*/


    }

    public void probarAlimentos() {
        //Alimento alimento = new Alimento();
        //alimento.setEliminado(0);
        //alimento.setIdAlimento(1);
        //alimento.setNombre("Agua");
        //alimento.setCantidadDisponible(100);
        //alimento.setPrecio(850.55);
       // alimento.setIdTipoAlimento(2);
        new AsyncTask<String, String, Alimento>() {
            @Override
            protected Alimento doInBackground(String... strings) {
                AlimentoDAOImplementation i = AlimentoDAOImplementation.getInstance();
                //return (Pelicula)i.create(p);
                //Alimento al = (Alimento)i.create(alimento);
                //Alimento al = (Alimento)i.get(1);
                //alimento.setIdTipoAlimento(al.getIdTipoAlimento());
                //alimento.setEliminado(al.isEliminado());
                //Alimento al = (Alimento)i.create(alimento);
                Alimento al = (Alimento)i.delete(1);
                System.out.println(al.toString());
                return al;
                //Pelicula peli = (Pelicula)i.get(2);
                //ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>)i.getAll();
                //for (Pelicula pelicula : peliculas)
                //    System.out.println(pelicula.toString());
                //return peliculas;


            }
            @Override
            protected void onPostExecute(Alimento result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    //System.out.println(result.getTitulo());
                    System.out.println("POSTEXECUTE");
                }
                else{
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
        }
