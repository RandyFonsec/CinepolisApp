package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDAOImpl implements DAORetrofit, DAO {
    //TODO: Desarrollar, esto queda de ejemplo

    @Override
    public Object create(Object object) {
        User u = (User) object;
        User[] userSalida = {null};
        boolean failure = false;
        Call<User> call = retrofit.create(UserRFInterface.class).create();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //Do something (asignar user)
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //Do something (asignar failure)
            }
        });

        //Esperar respuesta
        while(userSalida == null || !failure){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userSalida;
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
    public List<Object> getAll() {
        return null;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }
}
