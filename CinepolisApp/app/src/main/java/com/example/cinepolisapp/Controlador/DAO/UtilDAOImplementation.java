package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Director;

import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.Modelo.TipoAlimento;

import com.example.cinepolisapp.Modelo.Funcion;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Horario;
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
    public List getAllTypesFood() {
        Call<List<TipoAlimento>> call = retrofit.create(UtilRFInterface.class).getAllTypesFood();
        List<TipoAlimento> respuesta = null;
        try {
            Response<List<TipoAlimento>> response = null;
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
    public List<Horario> getHorariosDisponibles(Object idSala, Object horario){
        Call<List<Horario>> call = retrofit.create(UtilRFInterface.class).getHorariosDisponibles(
                (String)horario,
                (int)idSala);
        List<Horario> respuesta = null;
        try {
            Response<List<Horario>> response = null;
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
    public Object insertFuncion(Object idHorario, Object idSala, Object idPelicula, Object fecha){
        Call<Funcion> call = retrofit.create(UtilRFInterface.class).insertFuncion(
                (int)idHorario,
                (int)idSala,
                (int)idPelicula,
                (String) fecha);
        Funcion respuesta = null;
        try {
            Response<Funcion> response = null;
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
