package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Asiento;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AsientosDAOImplementation implements DAO, DAORetrofit {
    private static AsientosDAOImplementation instance;

    private AsientosDAOImplementation(){}

    public static AsientosDAOImplementation getInstance(){
        if(instance == null)
            instance = new AsientosDAOImplementation();
        return instance;

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
        Call<List<Asiento>> call = retrofit.create(UtilRFInterface.class).getAsientosFuncion((int)key);
        List<Asiento> respuesta = null;
        try {
            Response<List<Asiento>> response = null;
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
    public List getAll() {
        return null;
    }

    @Override
    public Object delete(Object key) {
        return null;
    }
}
