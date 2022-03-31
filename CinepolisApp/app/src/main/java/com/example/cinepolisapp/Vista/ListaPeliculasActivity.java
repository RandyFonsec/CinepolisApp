package com.example.cinepolisapp.Vista;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.example.cinepolisapp.Utils.ListaClientesAdapter;
import com.example.cinepolisapp.Utils.ListaPeliculasAdapter;
import com.example.cinepolisapp.Utils.LoadingDialog;

import java.util.ArrayList;

public class ListaPeliculasActivity extends AppCompatActivity {
    private int bandera;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peliculas_disponibles);
        Auxiliares.asignarBotonesInferiores(this);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            this.bandera = parametros.getInt("bandera");
        }
        initUI();
        cargarLista();

    }

    private void initUI() {
    }

    public void cargarLista() {
        LoadingDialog ld = new LoadingDialog(ListaPeliculasActivity.this);
        new AsyncTask<String, String, ArrayList<Pelicula>>() {
            @Override
            protected void onPreExecute() {
                ld.startDialog();
            }

            @Override
            protected ArrayList<Pelicula> doInBackground(String... strings) {
                return (ArrayList<Pelicula>) ControladorAplicacion.getInstance().getPeliculas();
            }

            @Override
            protected void onPostExecute(ArrayList<Pelicula> result) {
                ld.dismissDialog();
                mostrar(result);

            }

        }.execute();

    }

    public void mostrar(ArrayList<Pelicula> peliculas){
        ListView listClientes = findViewById(R.id.listViewPeliculas);
        listClientes.setAdapter(new ListaPeliculasAdapter(this, peliculas));

        listClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pelicula pelicula = peliculas.get(i);
                Bundle bundle = new Bundle();
                Intent intent;
                if(bandera == 1)
                    intent = new Intent(getApplicationContext(), EditDeletePelicula.class);
                else
                    intent = new Intent(getApplicationContext(), ConfigFuncionActivity.class);
                bundle.putSerializable("Pelicula",pelicula);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                //overridePendingTransition(0, 0);
            }
        });
    }
}
