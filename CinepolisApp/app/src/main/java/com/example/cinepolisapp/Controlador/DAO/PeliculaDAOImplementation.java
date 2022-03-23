package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDAOImplementation implements DAORetrofit, DAO {
    public PeliculaDAOImplementation(){}

    @Override
    public Object create(Object object) {

        Pelicula pelicula = (Pelicula) object;

        Pelicula[] peliculaSalida = {null};
        boolean[] failure = {false};
        System.out.println(pelicula);
        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).create(
                pelicula.getTitulo(),
                pelicula.getAnnoPublicacion(),
                pelicula.getDuracion(),
                pelicula.getEdadRequerida(),
                pelicula.getPrecioEntrada(),
                pelicula.getIdDirector());
        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                //Do something (asignar user)
                peliculaSalida[0] = response.body();
                System.out.println("Exito");
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
                System.out.println("Fracaso");
            }
        });

        //Esperar respuesta
        while(peliculaSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return peliculaSalida[0];
    }

    @Override
    public Object update(Object object) {
        Pelicula pelicula = (Pelicula) object;

        Pelicula[] peliculaSalida = {null};
        boolean[] failure = {false};

        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).update(
                pelicula.getIdPelicula(),
                pelicula.getTitulo(),
                pelicula.getAnnoPublicacion(),
                pelicula.getDuracion(),
                pelicula.getEdadRequerida(),
                pelicula.getPrecioEntrada(),
                pelicula.getEliminada(),
                pelicula.getIdDirector());
        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                //Do something (asignar user)
                peliculaSalida[0] = response.body();

            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;

            }
        });

        //Esperar respuesta
        while(peliculaSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return peliculaSalida[0];
    }

    @Override
    public Object get(Object key) {

        Pelicula[] peliculaSalida = {null};
        boolean[] failure = {false};

        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).get((int) key);
        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                //Do something (asignar user)
                peliculaSalida[0] = response.body();
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(peliculaSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return peliculaSalida[0];
    }

    @Override
    public List<Pelicula> getAll() {

        final List<Pelicula>[] peliculas = new List[]{null};
        boolean[] failure = {false};

        Call<List<Pelicula>> call = retrofit.create(PeliculaRFInterface.class).getAll();
        call.enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                peliculas[0] = response.body();
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(peliculas[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return peliculas[0];
    }

    @Override
    public Object delete(Object key) {


        Pelicula[] peliculaSalida = {null};
        boolean[] failure = {false};
        Call<Pelicula> call = retrofit.create(PeliculaRFInterface.class).delete((int)key);
        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                //Do something (asignar user)
                peliculaSalida[0] = response.body();
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {
                //Do something (asignar failure)
                failure[0] = true;
            }
        });

        //Esperar respuesta
        while(peliculaSalida[0] == null && !failure[0]){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return peliculaSalida[0];
    }


}
