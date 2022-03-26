package com.example.cinepolisapp.Vista;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        // probarPeliculas();

        //probarAlimentos();

        probarFuncAlimentos();


    }

    public void probarFuncAlimentos() {

        new AsyncTask<String, String, List<Alimento>>() {
            @Override
            protected List<Alimento> doInBackground(String... strings) {
                AlimentoDAOImplementation i = AlimentoDAOImplementation.getInstance();
                //return (Pelicula)i.create(p);
                //Alimento al = (Alimento)i.create(alimento);
                //Alimento al = (Alimento)i.get(1);
                //alimento.setIdTipoAlimento(al.getIdTipoAlimento());
                //alimento.setEliminado(al.isEliminado());
                //Alimento al = (Alimento)i.update(alimento);
                //System.out.println(al.toString());

                /* List<Alimento> pelis = (List<Alimento>) i.getAllAvailableFood();
                System.out.println("Printing available food");
                for (Alimento a : pelis)
                    System.out.println(a.toString());
                return pelis; */

                List<Alimento> pelis = (List<Alimento>) i.getAllAvailableFoodFiltered(3);
                System.out.println("Printing available food");
                for (Alimento a : pelis)
                    System.out.println(a.toString());
                return pelis;

                //Pelicula peli = (Pelicula)i.get(2);
                //ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>)i.getAll();
                //for (Pelicula pelicula : peliculas)
                //    System.out.println(pelicula.toString());
                //return peliculas;


            }
            @Override
            protected void onPostExecute(List<Alimento> result) {
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
