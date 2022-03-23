package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;

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

        Cliente u = (Cliente) object;

        Cliente[] userSalida = {null};
        boolean[] failure = {false};
        System.out.println(u);
        Call<Cliente> call = retrofit.create(UserRFInterface.class).create(u.getNumeroCedula(),
                u.getNombre(),
                u.getApellido1(),
                u.getApellido2(),
                u.getCorreo(),
                u.getEdad(),
                u.getFechaNacimiento(),
                u.getCantidadVacunas(),
                u.getContrasenna());
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                //Do something (asignar user)
                userSalida[0] = response.body();
                System.out.println("Exito");
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
                System.out.println("fracaso");
            }
        });

        //Esperar respuesta
        while(userSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userSalida[0];
    }

    @Override
    public Object update(Object object) {
        Cliente u = (Cliente) object;

        Cliente[] userSalida = {null};
        boolean[] failure = {false};

        Call<Cliente> call = retrofit.create(UserRFInterface.class).update(u.getNumeroCedula(),
                u.getNombre(),
                u.getApellido1(),
                u.getApellido2(),
                u.getCorreo(),
                u.getEdad(),
                u.getFechaNacimiento(),
                u.getCantidadVacunas(),
                u.isEliminado(),
                u.getContrasenna());
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                //Do something (asignar user)
                userSalida[0] = response.body();

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;

            }
        });

        //Esperar respuesta
        while(userSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userSalida[0];
    }

    @Override
    public Object get(Object key) {

        Cliente[] userSalida = {null};
        boolean[] failure = {false};

        Call<Cliente> call = retrofit.create(UserRFInterface.class).get((int) key);
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                //Do something (asignar user)
                userSalida[0] = response.body();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(userSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userSalida[0];
    }

    @Override
    public List<Cliente> getAll() {

        final List<Cliente>[] clientes = new List[]{null};
        boolean[] failure = {false};

        Call<List<Cliente>> call = retrofit.create(UserRFInterface.class).getAll();
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                clientes[0] = response.body();
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(clientes[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return clientes[0];
    }

    @Override
    public Object delete(Object key) {


        Cliente[] userSalida = {null};
        boolean[] failure = {false};

        Call<Cliente> call = retrofit.create(UserRFInterface.class).delete((int)key);
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                //Do something (asignar user)
                userSalida[0] = response.body();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(userSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userSalida[0];
    }
}
