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

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                String text= "Boton presionado "+String.valueOf(cont)+" veces";
                Toast.makeText(context, text, duration).show();
                testPelicula();
                //tests();

            }
        });


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

        new AsyncTask<String, String, Pelicula>() {
            @Override
            protected Pelicula doInBackground(String... strings) {
                PeliculaDAOImplementation i = PeliculaDAOImplementation.getInstance();
                 //return (Pelicula)i.create(p);
                //return (Pelicula)i.delete(2);
                Pelicula peli = (Pelicula)i.get(2);
                System.out.println(peli.toString());
                return peli;


            }
            @Override
            protected void onPostExecute(Pelicula result) {
                if(result != null) {
                    //idT.setText(result.getId());
                    //eM.setText(result.getEmail());
                    System.out.println(result.getTitulo());
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
        a.setEliminado(false);
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