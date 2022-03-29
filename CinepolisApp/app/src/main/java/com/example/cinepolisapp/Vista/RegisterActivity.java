package com.example.cinepolisapp.Vista;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.Controlador.ControladorAplicacion;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Utils.LoadingDialog;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegistrar;
    private EditText editTextCedula, editTextNombre, editTextPrimerApellido, editTextSegundoApellido,
            editTextCorreo, editTextEdad, editTextFechaNacimiento;
    private Spinner spinnerCantidadVacunas;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initUI();
        fillSpinner();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private void initUI() {
        editTextCedula = findViewById(R.id.CedulaText);
        editTextNombre = findViewById(R.id.NombreText);
        editTextPrimerApellido = findViewById(R.id.ApellidoText1);
        editTextSegundoApellido = findViewById(R.id.ApellidoText2);
        editTextCorreo = findViewById(R.id.EmailText);
        editTextEdad = findViewById(R.id.EdadText);
        editTextFechaNacimiento = findViewById(R.id.FechaNacimientoText);
        editTextFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.FechaNacimientoText:
                        showDatePickerDialog();
                }
            }
        });
        spinnerCantidadVacunas = findViewById(R.id.EsquemaVacunacionSpinner);
        btnRegistrar = findViewById(R.id.RegisterButton);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void fillSpinner() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<=2; i++) {
            arrayList.add(i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCantidadVacunas.setAdapter(arrayAdapter);
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                setYear(year);
                setMonth(month+1);
                setDay(day);
                editTextFechaNacimiento.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private String generatePassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = capitalLetters.toLowerCase();
        String numbers = "0123456789";
        String options = capitalLetters + lowercaseLetters + numbers;
        final int range = options.length();
        final int length = 8;
        String password = "";
        for (int i = 0; i < length; i++) {
            int randomPosition = (int)(Math.random() * range);
            password += (options.charAt(randomPosition));
        }
        return password;
    }

    private void registerUser() {
        if (validateData()) {
            comprobarRegistro();
        } else {
            System.out.println("Datos incorrectos");
        }
    }

    private boolean validateData() {
        if (editTextCedula.getText().toString().isEmpty() ||
            editTextNombre.getText().toString().isEmpty() ||
            editTextPrimerApellido.getText().toString().isEmpty() ||
            editTextSegundoApellido.getText().toString().isEmpty() ||
            editTextCorreo.getText().toString().isEmpty() ||
            editTextEdad.getText().toString().isEmpty()) {
            return false;
        }
        // TODO: 3/26/2022 Validar tipos de datos
        return true;
    }

    private void comprobarRegistro() {
        LoadingDialog ld = new LoadingDialog(RegisterActivity.this);
        new AsyncTask<String, String, Boolean>() {
            @Override
            protected void onPreExecute() {
                ld.startDialog();
            }

            @Override
            protected Boolean doInBackground(String... strings) {
                long numeroCedula = Long.parseLong(editTextCedula.getText().toString());
                String nombre = editTextNombre.getText().toString();
                String primerApellido = editTextPrimerApellido.getText().toString();
                String segundoApellido = editTextSegundoApellido.getText().toString();
                String correoElectronico = editTextCorreo.getText().toString();
                int edad = Integer.parseInt(editTextEdad.getText().toString());
                String contrasenna = generatePassword();
                String fechaNacimiento = getYear() + "/" + getMonth() + "/" + getDay();
                int cantidadVacunas = Integer.parseInt(spinnerCantidadVacunas.getSelectedItem().toString());
                Cliente cliente = new Cliente();
                cliente.setNumeroCedula(numeroCedula);
                cliente.setNombre(nombre);
                cliente.setApellido1(primerApellido);
                cliente.setApellido2(segundoApellido);
                cliente.setCorreo(correoElectronico);
                cliente.setEdad(edad);
                cliente.setCantidadVacunas(cantidadVacunas);
                cliente.setFechaNacimiento(fechaNacimiento);
                cliente.setContrasenna(contrasenna);
                Boolean registrado = ControladorAplicacion.getInstance().registrarCliente(cliente);
                return registrado;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                ld.dismissDialog();
                if (result) {
                    System.out.println("El cliente ha sido registrado exitosamente");
                } else {
                    System.out.println("Error al registrar el cliente");
                }
            }

        }.execute();
    }

}
