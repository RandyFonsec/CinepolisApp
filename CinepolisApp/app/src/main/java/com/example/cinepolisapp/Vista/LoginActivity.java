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
import com.example.cinepolisapp.Utils.LoadingDialog;

public class LoginActivity extends AppCompatActivity {
    private Button btnInicio, btnRegistro;
    private EditText eTNombreUsuario, eTContrasenna;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            initUI();



        }
        // TODO : Mostrar advertencias
        private void initUI(){
            eTNombreUsuario = findViewById(R.id.ApellidoText2);
            eTContrasenna = findViewById(R.id.PasswordLoginText);
            btnInicio = findViewById(R.id.LoginButton);
            btnInicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciarSesion();
                }
            });
            btnRegistro = findViewById(R.id.LoginToRegisterButton);
        }

        private void iniciarSesion(){
            if(validarCampos()){
                comprobarCredenciales();
            }else{
                System.out.println("Error debes llenar todo");
            }
        }

        private boolean validarCampos(){
            if(eTNombreUsuario.getText().toString().isEmpty())
                return false;
            if(eTContrasenna.getText().toString().isEmpty())
                return false;

            return true;
        }

        private void comprobarCredenciales(){
            LoadingDialog ld = new LoadingDialog(LoginActivity.this);
            new AsyncTask<String, String, Cliente>() {
                @Override
                protected void onPreExecute(){
                    ld.startDialog();
                }
                @Override
                protected Cliente doInBackground(String... strings) {

                    String nombre = eTNombreUsuario.getText().toString();
                    String contrasenna = eTContrasenna.getText().toString();

                    Cliente cliente = ControladorAplicacion.getInstance().buscarCliente(nombre, contrasenna);

                    return cliente;
                }
                @Override
                protected void onPostExecute(Cliente result) {
                    ld.dismissDialog();
                    if(result!=null){
                        System.out.println("Bien son tus credenciales");
                    }else{
                        System.out.println("No son tus credenciales");
                    }
                }

            }.execute();

        }
}
