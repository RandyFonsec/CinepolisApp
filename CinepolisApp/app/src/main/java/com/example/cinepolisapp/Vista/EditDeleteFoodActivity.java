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

public class EditDeleteFoodActivity extends AppCompatActivity {

    private EditText editTextNombreAlimento, editTextPrecioAlimento, editTextCantidadAlimento;
    private Spinner spinnerTiposAlimento;
    private Button btnEditarAlimento, btnEliminarAlimento;
    private String title, message;
    private Alimento alimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_alimento);
        Auxiliares.asignarBotonesInferiores(this);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null) {
            this.alimento = (Alimento) parametros.getSerializable("Alimento");
        }
        initUI();
        fillTypeFoodSpinner();
    }

    private void initUI() {
        editTextNombreAlimento = findViewById(R.id.TextNombreEditar);
        editTextCantidadAlimento = findViewById(R.id.TextCantidadEditar);
        editTextPrecioAlimento = findViewById(R.id.TextPrecioEditar);
        spinnerTiposAlimento = findViewById(R.id.spinnerEditTipoAlimento);
        // spinnerTiposAlimento.setSelection(alimento);
        btnEditarAlimento = findViewById(R.id.btnActualizarAlimento);
        btnEliminarAlimento = findViewById(R.id.btnEliminarAlimento);
        btnEditarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateFood();
            }
        });
        btnEliminarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFood();
            }
        });

        editTextNombreAlimento.setText(alimento.getNombre().toString());
        editTextCantidadAlimento.setText(String.valueOf(alimento.getCantidadDisponible()));
        editTextPrecioAlimento.setText(String.valueOf(alimento.getPrecio()));
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

    private void updateFood() {
        if (validateData()) {
            comprobarActualizacion();
        } else {
            Alerta.showAlert(EditDeleteFoodActivity.this, title, message);
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

    private void comprobarActualizacion() {
        LoadingDialog ld = new LoadingDialog(EditDeleteFoodActivity.this);
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

                Alimento alimentoAct = new Alimento();
                alimentoAct.setIdAlimento(alimento.getIdAlimento());
                alimentoAct.setNombre(nombre);
                alimentoAct.setCantidadDisponible(cantidad);
                alimentoAct.setPrecio(precio);
                alimentoAct.setIdTipoAlimento(tipoAlimento.getIdTipoAlimento());

                Boolean actualizado;
                actualizado = ControladorAplicacion.getInstance().modificarAlimento(alimentoAct);
                return actualizado;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                ld.dismissDialog();
                if (result) {
                    title = "Éxito";
                    message = "El alimento ha sido actualizado exitosamente";
                    Alerta.showAlert(EditDeleteFoodActivity.this, title, message);
                } else {
                    title = "Error";
                    message = "El alimento no ha podido ser actualizado";
                    Alerta.showAlert(EditDeleteFoodActivity.this, title, message);
                }
            }

        }.execute();
    }

    public void deleteFood() {
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() { }

            @Override
            protected Boolean doInBackground(String... strings) {
                return ControladorAplicacion.getInstance().eliminarAlimento((int) alimento.getIdAlimento());
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if(result) {
                    Alerta.showAlert(EditDeleteFoodActivity.this, "Éxito","El alimento ha sido eliminado exitosamente");
                    initUI();
                } else {
                    Alerta.showAlert(EditDeleteFoodActivity.this,"Error", "No fue posible eliminar el alimento");
                }
            }
        }.execute();
    }

}
