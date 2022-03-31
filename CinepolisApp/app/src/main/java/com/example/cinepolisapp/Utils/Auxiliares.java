package com.example.cinepolisapp.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinepolisapp.R;
import com.example.cinepolisapp.Vista.AlimentoAdminActivity;
import com.example.cinepolisapp.Vista.BillboardAdminActivity;
import com.example.cinepolisapp.Vista.GestorPeliculasActivity;
import com.example.cinepolisapp.Vista.HomeAdminActivity;
import com.example.cinepolisapp.Vista.UsersAdminActivity;

public class Auxiliares {
    public static void asignarBotonesInferiores(AppCompatActivity appCompat){
        appCompat.findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(appCompat, UsersAdminActivity.class);
                intent.putExtras(bundle);
                appCompat.startActivity(intent);
                appCompat.finish();
                appCompat.overridePendingTransition(0, 0);
            }
        });
        appCompat.findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(appCompat, AlimentoAdminActivity.class);
                intent.putExtras(bundle);
                appCompat.startActivity(intent);
                appCompat.finish();

                appCompat.overridePendingTransition(0, 0);
            }
        });
        appCompat.findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(appCompat, BillboardAdminActivity.class);
                intent.putExtras(bundle);
                appCompat.startActivity(intent);
                appCompat.finish();
                appCompat.overridePendingTransition(0, 0);
            }
        });
        appCompat.findViewById(R.id.button15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(appCompat, GestorPeliculasActivity.class);
                intent.putExtras(bundle);
                appCompat.startActivity(intent);
                appCompat.finish();
                appCompat.overridePendingTransition(0, 0);
            }
        });

    }
}
