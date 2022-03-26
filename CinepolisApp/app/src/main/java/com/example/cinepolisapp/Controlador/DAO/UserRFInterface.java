package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserRFInterface {

    // Encoding
    @FormUrlEncoded
    // URL del servicio php
    @POST("saveCliente.php")
    public Call<Cliente> create(@Field("numeroCedula") long numeroCedula,
                                @Field("nombre") String nombre,
                                @Field("apellido1") String apellido1,
                                @Field("apellido2") String apellido2,
                                @Field("correo") String correo,
                                @Field("edad")int edad,
                                @Field("fecha") String fechaNacimiento,
                                @Field("vacunas")int cantidadVacunas,
                                @Field("contrasenna")String contrasenna);

    @FormUrlEncoded
    @POST("editCliente.php")
    public Call<Cliente> update(@Field("numeroCedula") long numeroCedula,
                                @Field("nombre") String nombre,
                                @Field("apellido1") String apellido1,
                                @Field("apellido2") String apellido2,
                                @Field("correo") String correo,
                                @Field("edad")int edad,
                                @Field("fecha")String fechaNacimiento,
                                @Field("vacunas")int cantidadVacunas,
                                @Field("eliminado") int eliminado,
                                @Field("contrasenna")String contrasenna);

    @FormUrlEncoded
    @POST("deleteCliente.php")
    public Call<Cliente> delete(@Field("numeroCedula") long numeroCedula);

    @GET("fetchCliente.php")
    public Call<Cliente> get(@Query("numeroCedula") long numeroCedula);

    @GET("fetchClienteLogin.php")
    public Call<Cliente> get(@Query("correo") String correo,
                             @Query("contrasenna") String contrasenna);

    @GET("fetchAllCliente.php")
    public Call<List<Cliente>> getAll();
}