package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.AlimentoDAOImplementation;
import com.example.cinepolisapp.Controlador.DAO.PeliculaDAOImplementation;
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

public class GestorAlimentos {

    public GestorAlimentos() {}

    public boolean agregarAlimento(Alimento alimento) {
        Alimento resultado = (Alimento) AlimentoDAOImplementation.getInstance().create(alimento);
        return resultado != null ? true : false;
    }

    public boolean modificarAlimento(Alimento alimento) {
        Alimento resultado = (Alimento) AlimentoDAOImplementation.getInstance().update(alimento);
        return resultado != null ? true : false;
    }

    public boolean eliminarAlimento(int idAlimento) {
        Alimento resultado = (Alimento) AlimentoDAOImplementation.getInstance().delete(idAlimento);
        return resultado != null ? true : false;
    }

    public List<Alimento> obtenerAlimentosDisponibles() {
        List<Alimento> alimentos = AlimentoDAOImplementation.getInstance().getAllAvailableFood();
        return alimentos;
    }

    public List<Alimento> obtenerAlimentosDisponiblesFiltrados(int idTipoAlimento) {
        List<Alimento> alimentos = AlimentoDAOImplementation.getInstance().getAllAvailableFoodFiltered(idTipoAlimento);
        return alimentos;
    }

}
