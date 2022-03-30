package com.example.cinepolisapp.Vista;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.Alerta;
import com.example.cinepolisapp.Utils.Auxiliares;

public class EditarEliminarClienteActivity extends AppCompatActivity {
    //TODO: Corregir fechas,poner spinner
    private EditText etCedula, etNombre,etApellido1,etApellido2,etCorreo, etEdad,etFechaNacimiento,etEsquema;
    private Button btnAgregar,btnEliminar;
    private Cliente cliente;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_eliminar_cliente);

        Auxiliares.asignarBotonesInferiores(this);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            this.cliente = (Cliente) parametros.getSerializable("Cliente");
        }

        initUI();

    }

    private void initUI(){
        etCedula = findViewById(R.id.editTextNumber);
        etCedula.setFocusable(false);
        etNombre = findViewById(R.id.editTextTextPersonName);
        etApellido1= findViewById(R.id.editTextTextPersonName2);
        etApellido2= findViewById(R.id.editTextTextPersonName3);
        etCorreo = findViewById(R.id.editTextTextEmailAddress);
        etEdad = findViewById(R.id.editTextNumber2);
        etFechaNacimiento = findViewById(R.id.editTextDate);
        //etEsquema = findViewById(R.id.);
        etCedula.setText(String.valueOf(cliente.getNumeroCedula()));
        etNombre.setText(cliente.getNombre());
        etApellido1.setText(cliente.getApellido1());
        etApellido2.setText(cliente.getApellido2());
        etCorreo.setText(cliente.getCorreo());
        etEdad.setText(String.valueOf(cliente.getEdad()));
        etFechaNacimiento.setText(cliente.getFechaNacimiento());

        btnAgregar = findViewById(R.id.actualizar_Peliculas_btn2);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarEspacios())
                    actualizarCliente();
                else
                    Alerta.showAlert(EditarEliminarClienteActivity.this, "Error","Debe ingresar todos los datos");
            }
        });
        btnEliminar = findViewById(R.id.eliminar_Peliculas_btn);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCliente();
            }
        });
    }

    private boolean validarEspacios(){
        if (etNombre.getText().toString().isEmpty() ||
                etApellido1.getText().toString().isEmpty() ||
                etApellido2.getText().toString().isEmpty() ||
                etCorreo.getText().toString().isEmpty() ||
                etEdad.getText().toString().isEmpty() ||
                etFechaNacimiento.getText().toString().isEmpty()) {
            return false;
        }
        try {
            long numeroCedula = Long.parseLong(etEdad.getText().toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void actualizarCliente(){
        cliente.setNombre(etNombre.getText().toString());
        cliente.setApellido1(etApellido1.getText().toString());
        cliente.setApellido2(etApellido2.getText().toString());
        cliente.setCorreo(etCorreo.getText().toString());
        cliente.setEdad(Integer.parseInt(etEdad.getText().toString()));
        cliente.setFechaNacimiento(etFechaNacimiento.getText().toString());

        procesarActualizacion();
    }

    public void procesarActualizacion(){
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Boolean doInBackground(String... strings) {

                return ControladorAplicacion.getInstance().actualizarCliente(cliente);
            }

            @Override
            protected void onPostExecute(Boolean result) {

                if(result){
                    Alerta.showAlert(EditarEliminarClienteActivity.this, "Éxito","Cliente actualizado exitosamente");
                    initUI();
                }else{
                    Alerta.showAlert(EditarEliminarClienteActivity.this,"Error", "No fue posible actualizar el cliente");
                }

            }

        }.execute();
    }

    public void eliminarCliente(){
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Boolean doInBackground(String... strings) {

                return ControladorAplicacion.getInstance().eliminarCliente((int) cliente.getNumeroCedula());
            }

            @Override
            protected void onPostExecute(Boolean result) {

                if(result){
                    Alerta.showAlert(EditarEliminarClienteActivity.this, "Éxito","Cliente eliminado exitosamente");
                    initUI();
                }else{
                    Alerta.showAlert(EditarEliminarClienteActivity.this,"Error", "No fue posible eliminar el cliente");
                }

            }

        }.execute();
    }
}
