package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDAOImplementation implements DAORetrofit, DAO {

    private static PeliculaDAOImplementation singletonInstancePelicula;

    private PeliculaDAOImplementation(){}

    public static PeliculaDAOImplementation getInstance() {
        if (singletonInstancePelicula == null)
            singletonInstancePelicula = new PeliculaDAOImplementation();
        return singletonInstancePelicula;
    }

    @Override
    public Object create(Object object) {

        Pelicula pelicula = (Pelicula) object;

        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).create(
                pelicula.getTitulo(),
                pelicula.getAnnoPublicacion(),
                pelicula.getDuracion(),
                pelicula.getEdadRequerida(),
                pelicula.getPrecioEntrada(),
                pelicula.getIdDirector());
        Pelicula respuesta = null;
        try {
            Response<Pelicula> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }


        } catch (Exception e) {
        }


        return respuesta;
    }

    @Override
    public Object update(Object object) {
        Pelicula pelicula = (Pelicula) object;

        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).update(
                pelicula.getIdPelicula(),
                pelicula.getTitulo(),
                pelicula.getAnnoPublicacion(),
                pelicula.getDuracion(),
                pelicula.getEdadRequerida(),
                pelicula.getPrecioEntrada(),
                pelicula.getEliminada(),
                pelicula.getIdDirector());
        Pelicula respuesta = null;
        try {
            Response<Pelicula> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }


        } catch (Exception e) {
        }


        return respuesta;
    }

    @Override
    public Object get(Object key) {


        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).get((int) key);
        Pelicula respuesta = null;
        try {
            Response<Pelicula> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }


        } catch (Exception e) {
        }


        return respuesta;
    }

    @Override
    public List<Pelicula> getAll() {

        Call<List<Pelicula>> call = retrofit.create(PeliculaRFInterface.class).getAll();
        List<Pelicula> respuesta = null;
        try {
            Response<List<Pelicula>> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }


        } catch (Exception e) {
        }


        return respuesta;
    }

    @Override
    public Object delete(Object key) {


        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).delete((int)key);
        Pelicula respuesta = null;
        try {
            Response<Pelicula> response = null;
            response = call.execute();
            if(response.isSuccessful()){
                respuesta = response.body();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return respuesta;
    }


}
