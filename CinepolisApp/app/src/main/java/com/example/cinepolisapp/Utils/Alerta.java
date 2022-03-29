package com.example.cinepolisapp.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Vista.AlimentoAdminActivity;
import com.example.cinepolisapp.Vista.BillboardAdminActivity;
import com.example.cinepolisapp.Vista.HomeAdminActivity;
import com.example.cinepolisapp.Vista.UsersAdminActivity;

public class Alerta {
    public static void showAlert(Context contexto, String titulo, String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle(titulo).setMessage(mensaje);
        AlertDialog alerta = builder.create();
        alerta.show();
    }


}
