package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Asiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UtilRFInterface {

    @GET("fetchAsientosDeFuncion.php")
    public Call<List<Asiento>> getAsientosFuncion(@Query("idFuncion") int idFuncion);
}
