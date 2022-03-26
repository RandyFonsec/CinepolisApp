package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Alimento;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AlimentoDAOImplementation implements DAORetrofit, DAO, FilteredFoodInterface {

    private static AlimentoDAOImplementation singletonInstanceAlimento;

    private AlimentoDAOImplementation() {}

    public static AlimentoDAOImplementation getInstance() {
        if (singletonInstanceAlimento == null)
            singletonInstanceAlimento = new AlimentoDAOImplementation();
        return singletonInstanceAlimento;
    }

    @Override
    public Object create(Object object) {
        Alimento alimento = (Alimento) object;
        Call<Alimento> call = retrofit.create(AlimentoRFInterface.class).create(
                alimento.getNombre(),
                alimento.getCantidadDisponible(),
                alimento.getPrecio(),
                alimento.getIdTipoAlimento()
        );
        Alimento respuesta = null;
        try {
            Response<Alimento> response = null;
            response = call.execute();
            if (response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object update(Object object) {
        Alimento alimento = (Alimento) object;
        Call<Alimento> call = retrofit.create(AlimentoRFInterface.class).update(
                alimento.getIdAlimento(),
                alimento.getNombre(),
                alimento.getCantidadDisponible(),
                alimento.getPrecio(),
                alimento.isEliminado(),
                alimento.getIdTipoAlimento()
        );
        Alimento respuesta = null;
        try {
            Response<Alimento> response = null;
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
    public Object get(Object key) {
        Call<Alimento> call = retrofit.create(AlimentoRFInterface.class).get((int) key);
        Alimento respuesta = null;
        try {
            Response<Alimento> response = null;
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
    public List getAll() {
        Call<List<Alimento>> call = retrofit.create(AlimentoRFInterface.class).getAll();
        List<Alimento> respuesta = null;
        try {
            Response<List<Alimento>> response = null;
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
    public List getAllAvailableFood() {
        Call<List<Alimento>> call = retrofit.create(AlimentoRFInterface.class).getAllAvailableFood();
        List<Alimento> respuesta = null;
        try {
            Response<List<Alimento>> response = null;
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
    public List getAllAvailableFoodFiltered(Object key) {
        Call<List<Alimento>> call = retrofit.create(AlimentoRFInterface.class).getAllAvailableFoodFiltered((int) key);
        List<Alimento> respuesta = null;
        try {
            Response<List<Alimento>> response = null;
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
    public Object delete(Object key) {
        Call<Alimento> call = retrofit.create(AlimentoRFInterface.class).delete((int)key);
        Alimento respuesta = null;
        try {
            Response<Alimento> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }



}
