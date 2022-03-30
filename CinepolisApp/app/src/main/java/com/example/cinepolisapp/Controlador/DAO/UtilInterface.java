package com.example.cinepolisapp.Controlador.DAO;

import java.util.List;

public interface UtilInterface<T> {

    List<T> getAllDirectors();
    List<T> getAllIdiomas();
    List<T> getAllActores();
    List<T> getAllGeneros();
    Object insertActorXMovie(Object idPelicula, Object idActor);
    Object insertGenreXMovie(Object idPelicula, Object idGenero);
    Object insertIdiomXMovie(Object idPelicula, Object idIdioma);

}