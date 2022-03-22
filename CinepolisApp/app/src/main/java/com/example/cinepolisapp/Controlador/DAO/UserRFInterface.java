package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserRFInterface {
    //TODO: Implementar de forma correcta, queda a modo de ejemplo
    @FormUrlEncoded
    @POST("save.php")
    public Call<User> create(@Field("id") int id, @Field("name") String name, @Field("email") String email);

    //Encoding
    @FormUrlEncoded
    //URL del servicio php
    @POST("edit.php")
    public Call<User> update(@Field("name") String name, @Field("email") String email);

    @FormUrlEncoded
    @POST("delete.php")
    public Call<User> delete(@Field("name") String name, @Field("email") String email);

    @GET("fetch.php")
    public Call<User> get(@Query("name") String name);

    @GET("fetchAll.php")
    public Call<List<User>> getAll();
}
