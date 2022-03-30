package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Asiento;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UtilRFInterface {

    @GET("fetchAsientosDeFuncion.php")
    public Call<List<Asiento>> getAsientosFuncion(@Query("idFuncion") int idFuncion);

    @GET("fetchAllDirectores.php")
    public Call<List<Director>> getAllDirectores();

    @GET("fetchAllIdiomas.php")
    public Call<List<Idioma>> getAllIdiomas();

    @GET("fetchAllActores.php")
    public Call<List<Actor>> getAllActores();

    @GET("fetchAllGeneros.php")
    public Call<List<Genero>> getAllGeneros();

    @FormUrlEncoded
    @POST("saveActorXPelicula.php")
    public Call<Integer> insertActorXPelicula(@Field("idPelicula") int idPelicula,
                                         @Field("idActor") int idActor);

    @FormUrlEncoded
    @POST("saveGeneroXPelicula.php")
    public Call<Integer> insertGeneroXPelicula(@Field("idPelicula") int idPelicula,
                                         @Field("idGenero") int idGenero);

    @FormUrlEncoded
    @POST("saveIdiomaXPelicula.php")
    public Call<Integer> insertIdiomaXPelicula(@Field("idPelicula") int idPelicula,
                                         @Field("idIdioma") int idIdioma);

}
