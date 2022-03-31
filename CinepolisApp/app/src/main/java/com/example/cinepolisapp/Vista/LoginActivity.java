package com.example.cinepolisapp.Vista;

import android.content.Intent;
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
import com.example.cinepolisapp.Utils.LoadingDialog;

public class LoginActivity extends AppCompatActivity {
    private final String userAdmin = "admin";
    private final String userContra = "admin";
    private Button btnInicio, btnRegistro;
    private EditText eTCorreo, eTContrasenna;
    private String title, message;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            initUI();
        }

        // TODO : Mostrar advertencias
        private void initUI(){
            eTCorreo = findViewById(R.id.EmailLoginText);
            eTContrasenna = findViewById(R.id.PasswordLoginText);
            btnInicio = findViewById(R.id.LoginButton);
            btnInicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciarSesion();
                }
            });
            btnRegistro = findViewById(R.id.LoginToRegisterButton);
            btnRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

        private void iniciarSesion(){
            if(validarCampos()) {
                if(eTCorreo.getText().toString().equals(userAdmin) && eTContrasenna.getText().toString().equals(userContra))
                    iniciarAdmin();
                else
                    comprobarCredenciales();
            }else{
                Alerta.showAlert(LoginActivity.this, title, message);
            }
        }

    private void iniciarAdmin() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getApplicationContext(), GestorPeliculasActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean validarCampos() {
            if (eTCorreo.getText().toString().isEmpty() ||
                eTContrasenna.getText().toString().isEmpty()) {
                title = "Error";
                message = "Debe llenar todos los espacios solicitados";
                return false;
            }
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
                    String correo = eTCorreo.getText().toString();
                    String contrasenna = eTContrasenna.getText().toString();
                    Cliente cliente = ControladorAplicacion.getInstance().buscarCliente(correo, contrasenna);
                    return cliente;
                }
                @Override
                protected void onPostExecute(Cliente result) {
                    ld.dismissDialog();
                    if (result != null) {
                        System.out.println("Inicio de sesión exitoso");
                    } else {
                        title = "Error";
                        message = "Sus credenciales de inicio de sesión no son correctas";
                        Alerta.showAlert(LoginActivity.this, title, message);
                    }
                }
            }.execute();
        }
}
