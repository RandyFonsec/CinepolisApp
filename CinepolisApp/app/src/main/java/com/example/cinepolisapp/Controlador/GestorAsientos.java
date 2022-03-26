package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.AsientosDAOImplementation;
import com.example.cinepolisapp.Modelo.Asiento;

import java.util.List;

public class GestorAsientos {


    public GestorAsientos(){}


    public List<Asiento> getAsientosDeFuncion(int idFuncion){

        return (List<Asiento>)AsientosDAOImplementation.getInstance().get(idFuncion);
    }
}
