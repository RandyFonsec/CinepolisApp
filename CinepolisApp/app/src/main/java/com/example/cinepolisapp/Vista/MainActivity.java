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
                    cambiarTexto("No hay resultados\n.");
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
                    cambiarTexto("No hay resultados\n.");
                }

            }
            @Override
            protected void onPreExecute(){
                Toast.makeText(getApplicationContext(),"Iniciando consulta",Toast.LENGTH_SHORT).show();
            }
        }.execute();
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
        k.setNombre("Diego");
        k.setApellido1("Chayanne");
        k.setApellido2("N");
        k.setFechaNacimiento("1970/09/15");
        k.setCantidadVacunas(2);
        k.setContrasenna("patronesdediseñolover");
        k.setEdad(35);
        //k.setEliminado(0);
        k.setCorreo("dmora@gmail.com");
        System.out.println("Asignando " + k.getCorreo());

        new AsyncTask<String, String, Cliente>() {
            @Override
            protected Cliente doInBackground(String... strings) {
                ClienteDAOImpl i = ClienteDAOImpl.getInstance();
                Cliente client = (Cliente)i.create(k);
                //System.out.println("correo "+client.getCorreo());
                //System.out.println("eliminado "+client.isEliminado());
                //Cliente client = (Cliente)i.get("vsurak@gmail.com", "algoritmosheuristicos");
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