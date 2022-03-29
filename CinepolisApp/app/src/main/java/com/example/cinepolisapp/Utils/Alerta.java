package com.example.cinepolisapp.Utils;

import android.app.AlertDialog;
import android.content.Context;

public class Alerta {
    public static void showAlert(Context contexto, String titulo, String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle(titulo).setMessage(mensaje);
        AlertDialog alerta = builder.create();
        alerta.show();
    }
}
