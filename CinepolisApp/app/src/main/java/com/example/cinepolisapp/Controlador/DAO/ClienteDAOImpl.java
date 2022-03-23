package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteDAOImpl implements DAORetrofit, DAO {
    public ClienteDAOImpl(){}

    @Override
    public Object create(Object object) {

        Cliente user = (Cliente) object;

        Call<Cliente> call = retrofit.create(UserRFInterface.class).create(user.getNumeroCedula(),
                user.getNombre(),
                user.getApellido1(),
                user.getApellido2(),
                user.getCorreo(),
                user.getEdad(),
                user.getFechaNacimiento(),
                user.getCantidadVacunas(),
                user.getContrasenna());


        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
    public Object update(Object object) {
        Cliente user = (Cliente) object;


        Call<Cliente> call = retrofit.create(UserRFInterface.class).update(user.getNumeroCedula(),
                user.getNombre(),
                user.getApellido1(),
                user.getApellido2(),
                user.getCorreo(),
                user.getEdad(),
                user.getFechaNacimiento(),
                user.getCantidadVacunas(),
                user.isEliminado(),
                user.getContrasenna());

        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
    public Object get(Object key) {


        Call<Cliente> call = retrofit.create(UserRFInterface.class).get((int) key);
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
    public List<Cliente> getAll() {


        Call<List<Cliente>> call = retrofit.create(UserRFInterface.class).getAll();

        List<Cliente> respuesta = null;
        try {
            Response<List<Cliente>> response = null;
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
    public Object delete(Object key) {



        Call<Cliente> call = retrofit.create(UserRFInterface.class).delete((int)key);
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
