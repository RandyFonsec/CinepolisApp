package com.example.cinepolisapp.Vista;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.DAO.AlimentoDAOImplementation;
import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Controlador.DAO.UtilDAOImplementation;
import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Alimento;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Asiento;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;



public class MainActivity extends AppCompatActivity {
    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        probarUtils();
        /*setContentView(R.layout.fragment_gestor_alimento);
        Alerta.showAlert(MainActivity.this, "Hola","Esto es una alerta");
        TabLayout t ;*/
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
        probarUtils();


    }

    public void probarUtils() {
        new AsyncTask<String, String, Integer>() {
            @Override
            protected Integer doInBackground(String... strings) {
                /*
                UtilDAOImplementation i = UtilDAOImplementation.getInstance();
                List<Director> dirs = i.getAllDirectors();
                for (Director dir: dirs) {
                    System.out.println(dir.toString());
                }
                return dirs;*/

                /*UtilDAOImplementation i = UtilDAOImplementation.getInstance();
                List<Idioma> idioms = i.getAllIdiomas();
                for (Idioma idiom: idioms) {
                    System.out.println(idiom.toString());
                }
                return idioms;*/

                /*UtilDAOImplementation i = UtilDAOImplementation.getInstance();
                List<Actor> actors = i.getAllActores();
                for (Actor actor: actors) {
                    System.out.println(actor.toString());
                }
                return actors;*/

                /*UtilDAOImplementation i = UtilDAOImplementation.getInstance();
                List<Genero> generos = i.getAllGeneros();
                for (Genero genero : generos) {
                    System.out.println(genero.toString());
                }
                return generos;*/

                PeliculaDAOImplementation i = PeliculaDAOImplementation.getInstance();
                Integer id = i.obtenerUltimoIdPelicula();
                System.out.println("Id: " + id);
                return id;

            }
            @Override
            protected void onPostExecute(Integer result) {
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
        setContentView(R.layout.fragment_gestor_peliculas);

        Auxiliares.asignarBotonesInferiores(this);


        }
}