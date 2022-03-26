package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Alimento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlimentoRFInterface {

    @FormUrlEncoded
    // URL del servicio php
    @POST("saveAlimento.php")
    public Call<Alimento> create(@Field("nombre") String nombre,
                                 @Field("cantidadDisponible") int cantidadDisponible,
                                 @Field("precio") double precio,
                                 @Field("idTipoAlimento") int idTipoAlimento);

    @FormUrlEncoded
    @POST("editAlimento.php")
    public Call<Alimento> update(@Field("idAlimento") int idAlimento,
                                 @Field("nombre") String nombre,
                                 @Field("cantidadDisponible") int cantidadDisponible,
                                 @Field("precio") double precio,
                                 @Field("eliminado") int eliminado,
                                 @Field("idTipoAlimento") int idTipoAlimento);

    @FormUrlEncoded
    @POST("deleteAlimento.php")
    public Call<Alimento> delete(@Field("idAlimento") int idAlimento);

    @GET("fetchAlimento.php")
    public Call<Alimento> get(@Query("idAlimento") int idAlimento);

    @GET("fetchAllAlimento.php")
    public Call<List<Alimento>> getAll();

    @GET("fetchAllAvailableFood.php")
    public Call<List<Alimento>> getAllAvailableFood();

    @GET("fetchAllAvailableFoodFiltered.php")
    public Call<List<Alimento>> getAllAvailableFoodFiltered(@Query("idTipoAlimento") int idTipoAlimento);

}
