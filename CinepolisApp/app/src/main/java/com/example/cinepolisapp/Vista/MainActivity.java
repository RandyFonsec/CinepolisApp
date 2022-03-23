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
import com.example.cinepolisapp.Modelo.Cliente;
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
                tests();

            }
        });


    }

    public void tests() {
        //Para pruebas
        Cliente a,b,c ;
        a = new Cliente();
        a.setNumeroCedula(111);
        a.setNombre("Maria");
        a.setApellido1("AP2");
        a.setApellido2("AP3");
        a.setFechaNacimiento("2001/12/10");
        a.setCantidadVacunas(3);
        a.setContrasenna("qqq");
        a.setEdad(22);
        a.setEliminado(false);
        a.setCorreo("ad@sda.com");
        a.setIdCliente(1);

        new AsyncTask<String, String, Cliente>() {
            @Override
            protected Cliente doInBackground(String... strings) {
                ClienteDAOImpl i = new ClienteDAOImpl();
                return (Cliente)i.delete(111);

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