package com.example.cinepolisapp.Vista;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Funcion;
import com.example.cinepolisapp.Modelo.Horario;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;

import java.util.ArrayList;

public class ConfigFuncionActivity extends AppCompatActivity {
    private Horario horario;
    private String fecha;
    private int idSala;
    private Pelicula pelicula;
    private EditText nombrePelicula;
    private Button btnAsignar;
    private EditText etFecha;
    private Spinner spinnerSala, spinnerHorario;

    protected void onCreate(Bundle savedInstanceState) {
        idSala = -1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion_funcion);
        Auxiliares.asignarBotonesInferiores(this);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            this.pelicula = (Pelicula) parametros.getSerializable("Pelicula");
        }
        initUI();
        fillSpinnerSalas();


    }

    private void initUI() {
        nombrePelicula = findViewById(R.id.NombrePeliculaConfig);

        nombrePelicula.setFocusable(false);
        nombrePelicula.setText(pelicula.getTitulo());

        etFecha = findViewById(R.id.FechaConfig);
        spinnerSala = findViewById(R.id.spinnerSala);
        spinnerHorario = findViewById(R.id.spinnerHorario);

        btnAsignar = findViewById(R.id.Asignar_Config_Funcion_btn);
        btnAsignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos())
                    agregarFuncion();
                else
                    Alerta.showAlert(ConfigFuncionActivity.this, "Error", "Debe suministar toda la información");
            }
        });


    }

    private void agregarFuncion() {
        new AsyncTask<String, String, Funcion>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Funcion doInBackground(String... strings) {
                return (Funcion) ControladorAplicacion.getInstance()
                        .insertFuncion(horario.getIdHorario(),
                                idSala,
                                pelicula.getIdPelicula(),
                                fecha);
            }

            @Override
            protected void onPostExecute(Funcion result) {
                if(result != null)
                    Alerta.showAlert(ConfigFuncionActivity.this, "Exito", "Funcion registrada");

                else
                    Alerta.showAlert(ConfigFuncionActivity.this, "Fallo", "No fue posible registrar la funcion");
            }

        }.execute();

    }

    private boolean validarCampos() {
        horario =(Horario) spinnerHorario.getSelectedItem();
        idSala = (int)spinnerSala.getSelectedItem();
        fecha = etFecha.getText().toString();
        if(horario == null || idSala == -1 || fecha.isEmpty())
            return false;

        return true;
    }

    private void fillSpinnerSalas(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=1; i<=3; i++) {
            arrayList.add(i);
        }
        spinnerSala.setPrompt("Elige una sala");
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSala.setAdapter(arrayAdapter);

        spinnerSala.setSelected(false);
        spinnerSala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!etFecha.getText().toString().isEmpty())
                    fillSpinner(arrayList.get(i), etFecha.getText().toString());
                else
                    Alerta.showAlert(ConfigFuncionActivity.this, "Error", "Debe ingresar una fecha");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void fillSpinner(int idSala, String fecha){
        new AsyncTask<String, String, ArrayList<Horario>>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected ArrayList<Horario> doInBackground(String... strings) {
                return (ArrayList<Horario>) ControladorAplicacion.getInstance().getHorariosDisponibles(idSala, fecha);
            }

            @Override
            protected void onPostExecute(ArrayList<Horario> result) {
                showSpinner(result);
            }

        }.execute();

    }

    private void showSpinner(ArrayList<Horario> horarios){
        if(horarios.isEmpty()){
            Alerta.showAlert(ConfigFuncionActivity.this, "Error", "Todos los horarios ocupados para esa fecha");
        }else{
            ArrayAdapter<Horario> arrayAdapterActors = new ArrayAdapter<Horario>(this,
                    android.R.layout.simple_spinner_item, horarios);
            arrayAdapterActors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerHorario.setAdapter(arrayAdapterActors);
            spinnerHorario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    System.out.println(horarios.get(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }
}
