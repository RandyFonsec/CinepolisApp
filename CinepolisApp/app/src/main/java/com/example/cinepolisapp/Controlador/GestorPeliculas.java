package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

public class GestorPeliculas {

    public GestorPeliculas() {}

    public Pelicula agregarPelicula(Pelicula pelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().create(pelicula);
        // return resultado != null;
        return resultado;
    }

    public boolean modificarPelicula(Pelicula pelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().update(pelicula);
        return resultado != null;
    }

    public boolean eliminarPelicula(int idPelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().delete(idPelicula);
        return resultado != null;
    }

    public List<Pelicula> getPeliculasEnCartelera(){
        List<Pelicula> peliculas = (List<Pelicula>) PeliculaDAOImplementation.getInstance().getPeliculasFromCartelera();
        return peliculas;
    }

    public int obtenerUltimoIdPelicula() {
        int id = PeliculaDAOImplementation.getInstance().obtenerUltimoIdPelicula();
        return id;
    }

}
