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
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.Modelo.TipoAlimento;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;
import com.example.cinepolisapp.Utils.LoadingDialog;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {

    private EditText editTextNombreAlimento, editTextPrecioAlimento, editTextCantidadAlimento;
    private Spinner spinnerTiposAlimento;
    private Button btnAgregarAlimento;
    private String title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_alimento);
        Auxiliares.asignarBotonesInferiores(this);
        initUI();
        fillTypeFoodSpinner();
    }

    private void initUI() {
        editTextNombreAlimento = findViewById(R.id.TextNombreAgregar);
        editTextPrecioAlimento = findViewById(R.id.TextPrecioAgregar);
        editTextCantidadAlimento = findViewById(R.id.TextCantidadAgregar);
        spinnerTiposAlimento = findViewById(R.id.spinnerTipoAlimento);
        btnAgregarAlimento = findViewById(R.id.btnAgregarAlimento);
        btnAgregarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFood();
            }
        });
    }

    private void fillTypeFoodSpinner() {
        new AsyncTask<String, String, ArrayList<TipoAlimento>>() {
            @Override
            protected void onPreExecute() {}
            @Override
            protected ArrayList<TipoAlimento> doInBackground(String... strings) {
                return (ArrayList<TipoAlimento>) ControladorAplicacion.getInstance().obtenerTiposAlimento();
            }
            @Override
            protected void onPostExecute(ArrayList<TipoAlimento> result) {
                showTypesFoodSpinner(result);
            }

        }.execute();
    }

    private void showTypesFoodSpinner(ArrayList<TipoAlimento> typesFood) {
        ArrayAdapter<TipoAlimento> arrayAdapterTiposAlimento = new ArrayAdapter<TipoAlimento>(this,
                android.R.layout.simple_spinner_item, typesFood);
        arrayAdapterTiposAlimento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposAlimento.setAdapter(arrayAdapterTiposAlimento);
    }

    private void addFood() {
        if (validateData()) {
            comprobarRegistro();
        } else {
            Alerta.showAlert(AddFoodActivity.this, title, message);
        }
    }

    private boolean validateData() {
        if (editTextNombreAlimento.getText().toString().isEmpty() ||
                editTextPrecioAlimento.getText().toString().isEmpty() ||
                editTextCantidadAlimento.getText().toString().isEmpty()) {
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
        LoadingDialog ld = new LoadingDialog(AddFoodActivity.this);
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() {
                ld.startDialog();
            }
            @Override
            protected Boolean doInBackground(String... strings) {
                String nombre = editTextNombreAlimento.getText().toString();
                int cantidad = Integer.parseInt(editTextCantidadAlimento.getText().toString());
                double precio = Double.parseDouble(editTextPrecioAlimento.getText().toString());
                TipoAlimento tipoAlimento = (TipoAlimento) spinnerTiposAlimento.getSelectedItem();

                Alimento alimento = new Alimento();
                alimento.setNombre(nombre);
                alimento.setCantidadDisponible(cantidad);
                alimento.setPrecio(precio);
                alimento.setIdTipoAlimento(tipoAlimento.getIdTipoAlimento());

                Boolean registrado;
                registrado = ControladorAplicacion.getInstance().agregarAlimento(alimento);
                return registrado;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                ld.dismissDialog();
                if (result) {
                    title = "Éxito";
                    message = "El alimento ha sido agregado exitosamente";
                    Alerta.showAlert(AddFoodActivity.this, title, message);
                } else {
                    title = "Error";
                    message = "El alimento no ha podido ser agregado";
                    Alerta.showAlert(AddFoodActivity.this, title, message);
                }
            }
        }.execute();
    }

}
