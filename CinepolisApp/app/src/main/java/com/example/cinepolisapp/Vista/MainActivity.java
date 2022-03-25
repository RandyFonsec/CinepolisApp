package com.example.cinepolisapp.Vista;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
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

        probarPeliculas();


    }

    public void probarPeliculas() {
        Pelicula p = new Pelicula();
        // p.setIdPelicula(7); Para el edit
        p.setTitulo("Las desventuras de mi tía");
        p.setAnnoPublicacion(2025);
        p.setDuracion(3);
        p.setEdadRequerida(18);
        p.setPrecioEntrada(20000);
        p.setIdDirector(1);
        new AsyncTask<String, String, Pelicula>() {
            @Override
            protected Pelicula doInBackground(String... strings) {
                PeliculaDAOImplementation i = PeliculaDAOImplementation.getInstance();
                //return (Pelicula)i.create(p);
                return (Pelicula)i.delete(4);
                //Pelicula peli = (Pelicula)i.get(2);
                //ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>)i.getAll();
                //for (Pelicula pelicula : peliculas)
                //    System.out.println(pelicula.toString());
                //return peliculas;


            }
            @Override
            protected void onPostExecute(Pelicula result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    //System.out.println(result.getTitulo());
                    System.out.println("POSTEXECUTE");
                }
                else{
                    cambiarTexto("No hay resultados\n.");
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public void probar() {

        //Para pruebas
        Cliente k = new Cliente();

        k.setNumeroCedula(15230);
        System.out.println("Cedula " + k.getNumeroCedula());
        k.setNombre("Rodrigo");
        k.setApellido1("Nuñez");
        k.setApellido2("N");
        k.setFechaNacimiento("1970/09/15");
        k.setCantidadVacunas(2);
        k.setContrasenna("algoritmosheuristicos");
        k.setEdad(41);
        //k.setEliminado(0);
        k.setCorreo("vsurak@gmail.com");
        System.out.println("Asignando " + k.getCorreo());

        new AsyncTask<String, String, Cliente>() {
            @Override
            protected Cliente doInBackground(String... strings) {
                ClienteDAOImpl i = ClienteDAOImpl.getInstance();
                //Cliente client = (Cliente)i.create(1205);
                //System.out.println("correo "+client.getCorreo());
                //System.out.println("eliminado "+client.isEliminado());
                Cliente client = (Cliente)i.get("vsurak@gmail.com", "algoritmosheuristicos");
                System.out.println("correo "+client.getCorreo());
                System.out.println("eliminado "+client.isEliminado());
                System.out.println(client);
                return client;
            }
            @Override
            protected void onPostExecute(Cliente result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    System.out.println(result.toString());
                }
                else{
                    cambiarTexto("No hay resultados\n.");
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();

    }

    public void testPelicula() {
        Pelicula p;
        p = new Pelicula();
        p.setTitulo("Marcelenda y la niña");
        p.setAnnoPublicacion(2022);
        p.setDuracion(2.5);
        p.setEdadRequerida(18);
        p.setPrecioEntrada(100000);
        p.setEliminada(0);
        p.setIdDirector(4);

        new AsyncTask<String, String, ArrayList<Pelicula>>() {
            @Override
            protected ArrayList<Pelicula> doInBackground(String... strings) {
                PeliculaDAOImplementation i = PeliculaDAOImplementation.getInstance();
                 //return (Pelicula)i.create(p);
                //return (Pelicula)i.delete(2);
                //Pelicula peli = (Pelicula)i.get(2);
                ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>)i.getAll();
                for (Pelicula pelicula : peliculas)
                    System.out.println(pelicula.toString());
                return peliculas;


            }
            @Override
            protected void onPostExecute(ArrayList<Pelicula> result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    //System.out.println(result.getTitulo());
                    System.out.println("POSTEXECUTE");
                }
                else{
                    cambiarTexto("No hay resultados\n.");
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public void tests() {
        //Para pruebas
        Cliente a,b,c ;
        a = new Cliente();

        a.setNumeroCedula(333);
        a.setNombre("Ivannia");
        a.setApellido1("Cerdas");
        a.setApellido2("Quesada");
        a.setFechaNacimiento("1979/07/15");
        a.setCantidadVacunas(1);
        a.setContrasenna("vvv");
        a.setEdad(67);
        //a.setEliminado(0);
        a.setCorreo("estrtucturasmm.com");
        a.setIdCliente(1);

        new AsyncTask<String, String, Cliente>() {
            @Override
            protected Cliente doInBackground(String... strings) {
                ClienteDAOImpl i = ClienteDAOImpl.getInstance();


                return (Cliente)i.create(a);
        }
            @Override
            protected void onPostExecute(Cliente result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    System.out.println(result.getNombre());
                }
                else{
                    cambiarTexto("No hay resultados\n.");
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public void cambiarTexto(String text){
        System.out.println(text);
    }
}