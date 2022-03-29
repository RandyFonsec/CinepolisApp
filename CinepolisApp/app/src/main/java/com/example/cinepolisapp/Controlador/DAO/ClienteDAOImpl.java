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

    private static ClienteDAOImpl singletonInstanceCliente;

    private ClienteDAOImpl(){}

    public static ClienteDAOImpl getInstance() {
        if (singletonInstanceCliente == null)
            singletonInstanceCliente = new ClienteDAOImpl();
        return singletonInstanceCliente;
    }

    @Override
    public Object create(Object object) {
        Cliente user = (Cliente) object;
        System.out.println("LOOKING FOR");
        System.out.println(user.toString());
        System.out.println(user.getCorreo());
        System.out.println(user.isEliminado());
        Call<Cliente> call = retrofit.create(UserRFInterface.class).create(
                user.getNumeroCedula(),
                user.getNombre(),
                user.getApellido1(),
                user.getApellido2(),
                user.getCorreo(),
                user.getEdad(),
                user.getFechaNacimiento(),
                user.getCantidadVacunas(),
                user.getContrasenna()
        );
        System.out.println("Call " + call);
        System.out.println(user.getCorreo());
        System.out.println(user.isEliminado());
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
                System.out.println("Resp on create 54 " + respuesta);
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Object update(Object object) {
        Cliente user = (Cliente) object;
        Call<Cliente> call = retrofit.create(UserRFInterface.class).update(
                user.getNumeroCedula(),
                user.getNombre(),
                user.getApellido1(),
                user.getApellido2(),
                user.getCorreo(),
                user.getEdad(),
                user.getFechaNacimiento(),
                user.getCantidadVacunas(),
                user.isEliminado(),
                user.getContrasenna()
        );
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
        Call<Cliente> call = retrofit.create(UserRFInterface.class).get((long) key);
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
            response = call.execute();
            if(response.isSuccessful()) {
                respuesta = response.body();
                System.out.println("Body response resp on get 100 " + respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Object get(Object correoElectronico, Object contrasenna) {
        Call<Cliente> call = retrofit.create(UserRFInterface.class).get((String) correoElectronico, (String) contrasenna);
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
    public List<Cliente> getAll() {
        Call<List<Cliente>> call = retrofit.create(UserRFInterface.class).getAll();
        List<Cliente> respuesta = null;
        try {
            Response<List<Cliente>> response = null;
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
        Call<Cliente> call = retrofit.create(UserRFInterface.class).delete((int)key);
        Cliente respuesta = null;
        try {
            Response<Cliente> response = null;
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
