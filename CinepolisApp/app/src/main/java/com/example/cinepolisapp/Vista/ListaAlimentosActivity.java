package com.example.cinepolisapp.Vista;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.example.cinepolisapp.Utils.ListaAlimentosAdapter;
import com.example.cinepolisapp.Utils.ListaClientesAdapter;
import com.example.cinepolisapp.Utils.LoadingDialog;

import java.util.ArrayList;

public class ListaAlimentosActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alimentos);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();
        cargarLista();
    }

    private void initUI() {}

    public void cargarLista() {
        LoadingDialog ld = new LoadingDialog(ListaAlimentosActivity.this);
        new AsyncTask<String, String, ArrayList<Alimento>>() {
            @Override
            protected void onPreExecute() {
                ld.startDialog();
            }

            @Override
            protected ArrayList<Alimento> doInBackground(String... strings) {
                return (ArrayList<Alimento>) ControladorAplicacion.getInstance().obtenerAlimentosDisponibles();
            }

            @Override
            protected void onPostExecute(ArrayList<Alimento> result) {
                ld.dismissDialog();
                mostrar(result);

            }

        }.execute();

    }

    public void mostrar(ArrayList<Alimento> alimentos) {
        ListView listAlimentos = findViewById(R.id.listaAlimentos);
        listAlimentos.setAdapter(new ListaAlimentosAdapter(this, alimentos));

        listAlimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Alimento alimento = alimentos.get(i);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(), EditDeleteFoodActivity.class);
                bundle.putSerializable("Alimento", alimento);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }

}
