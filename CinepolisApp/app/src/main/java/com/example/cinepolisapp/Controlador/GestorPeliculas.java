package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Pelicula;

public class GestorPeliculas {

    public GestorPeliculas() {}

    public boolean agregarPelicula(Pelicula pelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().create(pelicula);
        return resultado != null ? true : false;
    }

    public boolean modificarPelicula(Pelicula pelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().update(pelicula);
        return resultado != null ? true : false;
    }

    public boolean eliminarPelicula(int idPelicula) {
        Pelicula resultado = (Pelicula) PeliculaDAOImplementation.getInstance().delete(idPelicula);
        return resultado != null ? true : false;
    }

}
