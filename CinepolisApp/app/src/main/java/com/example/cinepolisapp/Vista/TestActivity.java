package com.example.cinepolisapp.Vista;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.example.cinepolisapp.Utils.ListaClientesAdapter;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Auxiliares.asignarBotonesInferiores(this);
        /*ArrayList<Cliente> clientes = (ArrayList<Cliente>)ControladorAplicacion.getInstance().getClientes();
        ListView listClientes = findViewById(R.id.listaTest);
        listClientes.setAdapter(new ListaClientesAdapter(TestActivity.this, clientes));

        listClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cliente c = clientes.get(i);
                System.out.println(c);
            }
        });*/
    test();

    }

    public void test() {
        new AsyncTask<String, String, ArrayList<Cliente>>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected ArrayList<Cliente> doInBackground(String... strings) {
                return (ArrayList<Cliente>)ControladorAplicacion.getInstance().getClientes();
            }

            @Override
            protected void onPostExecute(ArrayList<Cliente> result) {

                mostrar(result);

            }

        }.execute();

    }

    public void mostrar(ArrayList<Cliente> clientes ){
        ListView listClientes = findViewById(R.id.listaClientes);
        listClientes.setAdapter(new ListaClientesAdapter(this, clientes));

        listClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cliente c = clientes.get(i);
                System.out.println(c);
            }
        });
    }
}
