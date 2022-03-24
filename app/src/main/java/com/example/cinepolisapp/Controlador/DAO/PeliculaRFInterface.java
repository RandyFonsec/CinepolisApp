package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PeliculaRFInterface {

    //TODO: Implementar de forma correcta, queda a modo de ejemplo
    @FormUrlEncoded
    @POST("savePelicula.php")
    public Call<Pelicula> create(@Field("titulo") String titulo,
                                 @Field("annoPublicacion") int annoPublicacion,
                                 @Field("duracion") double duracion,
                                 @Field("edadRequerida") int edadRequerida,
                                 @Field("precioEntrada") double precioEntrada,
                                 @Field("idDirector") int idDirector);

    //Encoding
    @FormUrlEncoded
    //URL del servicio php
    @POST("editPelicula.php")
    public Call<Pelicula> update(@Field("idPelicula") int idPelicula,
                                 @Field("titulo") String titulo,
                                 @Field("annoPublicacion") int annoPublicacion,
                                 @Field("duracion") double duracion,
                                 @Field("edadRequerida") int edadRequerida,
                                 @Field("precioEntrada") double precioEntrada,
                                 @Field("eliminada") int eliminada,
                                 @Field("idDirector") int idDirector);

    @FormUrlEncoded
    @POST("deletePelicula.php")
    public Call<Pelicula> delete(@Field("idPelicula") int idPelicula);

    @GET("fetchPelicula.php")
    public Call<Pelicula> get(@Query("idPelicula") int idPelicula);

    @GET("fetchAllPelicula.php")
    public Call<List<Pelicula>> getAll();

}
