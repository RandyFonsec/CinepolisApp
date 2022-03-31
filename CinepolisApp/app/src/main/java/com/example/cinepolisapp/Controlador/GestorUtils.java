package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.UtilDAOImplementation;
import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Funcion;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Horario;
import com.example.cinepolisapp.Modelo.Idioma;

import java.lang.reflect.AccessibleObject;
import java.util.List;

import okhttp3.internal.Util;

public class GestorUtils {

    public GestorUtils() { }

    public List<Director> obtenerDirectores() {
        List<Director> directores = UtilDAOImplementation.getInstance().getAllDirectors();
        return directores;
    }

    public List<Idioma> obtenerIdiomas() {
        List<Idioma> idiomas = UtilDAOImplementation.getInstance().getAllIdiomas();
        return idiomas;
    }

    public List<Actor> obtenerActores() {
        List<Actor> actores = UtilDAOImplementation.getInstance().getAllActores();
        return actores;
    }

    public List<Genero> obtenerGeneros() {
        List<Genero> generos = UtilDAOImplementation.getInstance().getAllGeneros();
        return generos;
    }

    public int agregarActorXPelicula(int idPelicula, int idActor) {
        Integer resultado = (Integer) UtilDAOImplementation.getInstance().insertActorXMovie(idPelicula, idActor);
        return resultado.intValue();
    }

    public int agregarGeneroXPelicula(int idPelicula, int idGenero) {
        Integer resultado = (Integer) UtilDAOImplementation.getInstance().insertGenreXMovie(idPelicula, idGenero);
        return resultado.intValue();
    }

    public int agregarIdiomaXPelicula(int idPelicula, int idIdioma) {
        Integer resultado = (Integer) UtilDAOImplementation.getInstance().insertIdiomXMovie(idPelicula, idIdioma);
        return resultado.intValue();
    }

    public List<Horario> getHorariosDisponibles(int idSala, String fecha){
        List<Horario> horarios = (List<Horario>) UtilDAOImplementation.getInstance().getHorariosDisponibles(idSala, fecha );
        return horarios;
    }

    public Funcion insertFuncion(int idHorario, int idSala, int idPelicula, String fecha){
        Funcion funcion = (Funcion) UtilDAOImplementation.getInstance().insertFuncion(idHorario, idSala, idPelicula, fecha);
        return funcion;
    }
}
