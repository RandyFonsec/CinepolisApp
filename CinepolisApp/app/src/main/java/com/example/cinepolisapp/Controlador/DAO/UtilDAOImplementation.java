package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class UtilDAOImplementation implements DAORetrofit, UtilInterface {

    private static UtilDAOImplementation singletonInstanceUtils;

    private UtilDAOImplementation(){}

    public static UtilDAOImplementation getInstance() {
        if (singletonInstanceUtils == null)
            singletonInstanceUtils = new UtilDAOImplementation();
        return singletonInstanceUtils;
    }

    @Override
    public List getAllDirectors() {
        Call<List<Director>> call = retrofit.create(UtilRFInterface.class).getAllDirectores();
        List<Director> respuesta = null;
        try {
            Response<List<Director>> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public List getAllIdiomas() {
        Call<List<Idioma>> call = retrofit.create(UtilRFInterface.class).getAllIdiomas();
        List<Idioma> respuesta = null;
        try {
            Response<List<Idioma>> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public List getAllActores() {
        Call<List<Actor>> call = retrofit.create(UtilRFInterface.class).getAllActores();
        List<Actor> respuesta = null;
        try {
            Response<List<Actor>> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public List getAllGeneros() {
        Call<List<Genero>> call = retrofit.create(UtilRFInterface.class).getAllGeneros();
        List<Genero> respuesta = null;
        try {
            Response<List<Genero>> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object insertActorXMovie(Object idPelicula, Object idActor) {
        Call<Integer> call = retrofit.create(UtilRFInterface.class).insertActorXPelicula(
                (int)idPelicula,
                (int)idActor);
        Integer respuesta = 0;
        try {
            Response<Integer> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object insertGenreXMovie(Object idPelicula, Object idGenero) {
        Call<Integer> call = retrofit.create(UtilRFInterface.class).insertGeneroXPelicula(
                (int)idPelicula,
                (int)idGenero);
        Integer respuesta = 0;
        try {
            Response<Integer> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object insertIdiomXMovie(Object idPelicula, Object idIdioma) {
        Call<Integer> call = retrofit.create(UtilRFInterface.class).insertIdiomaXPelicula(
                (int)idPelicula,
                (int)idIdioma);
        Integer respuesta = 0;
        try {
            Response<Integer> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object delete(Object key) {
        return null;
    }
}