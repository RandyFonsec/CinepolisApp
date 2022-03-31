package com.example.cinepolisapp.Vista;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.example.cinepolisapp.Utils.LoadingDialog;

import java.util.ArrayList;

public class AddMovieActivity extends AppCompatActivity {

    private EditText editTextTitulo, editTextAnno, editTextDuracion, editTextEdad, editTextPrecioEntrada;
    private Spinner spinnerDirectores, spinnerActores, spinnerIdiomas, spinnerGeneros;
    private Button btnAgregarPelicula;
    private String title, message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_pelicula);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();
        fillSpinners();
    }

    private void initUI() {
        editTextTitulo = findViewById(R.id.editTextTituloPelicula);
        editTextAnno = findViewById(R.id.editTextAnnoPelicula);
        editTextDuracion = findViewById(R.id.editTextDuracionPelicula);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextPrecioEntrada = findViewById(R.id.editTextPrecioEntrada);
        spinnerDirectores = findViewById(R.id.spinnerDirectores);
        spinnerActores = findViewById(R.id.spinnerActores);
        spinnerIdiomas = findViewById(R.id.spinnerIdiomas);
        spinnerGeneros = findViewById(R.id.spinnerGeneros);
        btnAgregarPelicula = findViewById(R.id.btnAgregarPelicula);
        btnAgregarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerMovie();
            }
        });
    }

    private void fillSpinners() {
        fillDirectorsSpinner();
        fillActorsSpinner();
        fillIdiomsSpinner();
        fillGenresSpinner();
    }

    private void fillDirectorsSpinner() {
        new AsyncTask<String, String, ArrayList<Director>>() {
            @Override
            protected void onPreExecute() {}
            @Override
            protected ArrayList<Director> doInBackground(String... strings) {
                return (ArrayList<Director>) ControladorAplicacion.getInstance().obtenerDirectores();
            }
            @Override
            protected void onPostExecute(ArrayList<Director> result) {
                showDirectorsSpinner(result);
            }

        }.execute();
    }

    private void showDirectorsSpinner(ArrayList<Director> directors) {
        ArrayAdapter<Director> arrayAdapterDirectores = new ArrayAdapter<Director>(this,
                android.R.layout.simple_spinner_item, directors);
        arrayAdapterDirectores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDirectores.setAdapter(arrayAdapterDirectores);
    }

    private void fillActorsSpinner() {
        new AsyncTask<String, String, ArrayList<Actor>>() {
            @Override
            protected void onPreExecute() {}
            @Override
            protected ArrayList<Actor> doInBackground(String... strings) {
                return (ArrayList<Actor>) ControladorAplicacion.getInstance().obtenerActores();
            }
            @Override
            protected void onPostExecute(ArrayList<Actor> result) {
                showActorsSpinner(result);
            }

        }.execute();
    }

    private void showActorsSpinner(ArrayList<Actor> actors) {
        ArrayAdapter<Actor> arrayAdapterActors = new ArrayAdapter<Actor>(this,
                android.R.layout.simple_spinner_item, actors);
        arrayAdapterActors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActores.setAdapter(arrayAdapterActors);
    }

    private void fillIdiomsSpinner() {
        new AsyncTask<String, String, ArrayList<Idioma>>() {
            @Override
            protected void onPreExecute() {}
            @Override
            protected ArrayList<Idioma> doInBackground(String... strings) {
                return (ArrayList<Idioma>) ControladorAplicacion.getInstance().obtenerIdiomas();
            }
            @Override
            protected void onPostExecute(ArrayList<Idioma> result) {
                showIdiomsSpinner(result);
            }

        }.execute();
    }

    private void showIdiomsSpinner(ArrayList<Idioma> idioms) {
        ArrayAdapter<Idioma> arrayAdapterIdioms = new ArrayAdapter<Idioma>(this,
                android.R.layout.simple_spinner_item, idioms);
        arrayAdapterIdioms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdiomas.setAdapter(arrayAdapterIdioms);
    }

    private void fillGenresSpinner() {
        new AsyncTask<String, String, ArrayList<Genero>>() {
            @Override
            protected void onPreExecute() {}
            @Override
            protected ArrayList<Genero> doInBackground(String... strings) {
                return (ArrayList<Genero>) ControladorAplicacion.getInstance().obtenerGeneros();
            }
            @Override
            protected void onPostExecute(ArrayList<Genero> result) {
                showGenresSpinner(result);
            }

        }.execute();
    }

    private void showGenresSpinner(ArrayList<Genero> genres) {
        ArrayAdapter<Genero> arrayAdapterIdioms = new ArrayAdapter<Genero>(this,
                android.R.layout.simple_spinner_item, genres);
        arrayAdapterIdioms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGeneros.setAdapter(arrayAdapterIdioms);
    }

    private void registerMovie() {
        if (validateData()) {
            comprobarRegistro();
        } else {
            Alerta.showAlert(AddMovieActivity.this, title, message);
        }
    }

    private boolean validateData() {
        if (editTextTitulo.getText().toString().isEmpty() ||
                editTextAnno.getText().toString().isEmpty() ||
                editTextDuracion.getText().toString().isEmpty() ||
                editTextEdad.getText().toString().isEmpty()) {
            title = "Error";
            message = "Debe llenar todos los espacios solicitados";
            return false;
        }
        /*try {
            long numeroCedula = Long.parseLong(editTextCedula.getText().toString());
            int edad = Integer.parseInt(editTextEdad.getText().toString());
        } catch (Exception e) {
            message = "La cédula y la edad deben ser valores numéricos";
            return false;
        }*/
        return true;
    }

    private void comprobarRegistro() {
        LoadingDialog ld = new LoadingDialog(AddMovieActivity.this);
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() {
                ld.startDialog();
            }
            @Override
            protected Boolean doInBackground(String... strings) {
                String titulo = editTextTitulo.getText().toString();
                int anno = Integer.parseInt(editTextAnno.getText().toString());
                float duracion = Float.parseFloat(editTextDuracion.getText().toString());
                int edad = Integer.parseInt(editTextEdad.getText().toString());
                float precioEntrada = Float.parseFloat(editTextPrecioEntrada.getText().toString());
                Director director = (Director) spinnerDirectores.getSelectedItem();
                Actor actor = (Actor) spinnerActores.getSelectedItem();
                Idioma idioma = (Idioma) spinnerIdiomas.getSelectedItem();
                Genero genero = (Genero) spinnerGeneros.getSelectedItem();

                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(titulo);
                pelicula.setAnnoPublicacion(anno);
                pelicula.setDuracion(duracion);
                pelicula.setEdadRequerida(edad);
                pelicula.setPrecioEntrada(precioEntrada);
                pelicula.setIdDirector(director.getIdDirector());

                Pelicula registrada;
                registrada = ControladorAplicacion.getInstance().agregarPelicula(pelicula);

                if (registrada != null) {
                    int actorXPelicula = ControladorAplicacion.getInstance().agregarActorXPelicula(
                            registrada.getIdPelicula(),
                            actor.getIdActor());
                    int generoXPelicula = ControladorAplicacion.getInstance().agregarGeneroXPelicula(
                            registrada.getIdPelicula(),
                            genero.getIdGenero());
                    int idiomaXPelicula = ControladorAplicacion.getInstance().agregarIdiomaXPelicula(
                            registrada.getIdPelicula(),
                            idioma.getIdIdioma());
                    if (actorXPelicula==1 && generoXPelicula==1 && idiomaXPelicula==1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean result) {
                ld.dismissDialog();
                if (result) {
                    title = "Éxito";
                    message = "La pelicula ha sido agregada exitosamente";
                    Alerta.showAlert(AddMovieActivity.this, title, message);
                } else {
                    title = "Error";
                    message = "La pelicula no ha podido ser agregada";
                    Alerta.showAlert(AddMovieActivity.this, title, message);
                }
            }

        }.execute();
    }



}
