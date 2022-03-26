package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

public class ControladorAplicacion {

    private static ControladorAplicacion singletonControllerInstance;
    private GestorClientes gestorClientes;
    private GestorPeliculas gestorPeliculas;
    private GestorAlimentos gestorAlimentos;
    private GestorCartelera gestorCartelera;

    private ControladorAplicacion() {
        gestorClientes = new GestorClientes();
        gestorPeliculas = new GestorPeliculas();
        gestorAlimentos = new GestorAlimentos();
        gestorCartelera = new GestorCartelera();
    }

    public static ControladorAplicacion getInstance() {
        if (singletonControllerInstance == null)
            singletonControllerInstance = new ControladorAplicacion();
        return singletonControllerInstance;
    }

    public boolean registrarCliente(Cliente cliente) {
        return gestorClientes.registrarCliente(cliente);
    }

    public Cliente buscarCliente(String correoElectronico, String contrasenna) {
        return gestorClientes.buscarCliente(correoElectronico, contrasenna);
    }

    public boolean agregarPelicula(Pelicula pelicula) {
        return gestorPeliculas.agregarPelicula(pelicula);
    }

    public boolean modificarPelicula(Pelicula pelicula) {
        return gestorPeliculas.modificarPelicula(pelicula);
    }

    public boolean eliminarPelicula(int idPelicula) {
        return gestorPeliculas.eliminarPelicula(idPelicula);
    }

    public boolean agregarAlimento(Alimento alimento) {
        return gestorAlimentos.agregarAlimento(alimento);
    }

    public boolean modificarAlimento(Alimento alimento) {
        return gestorAlimentos.modificarAlimento(alimento);
    }

    public boolean eliminarAlimento(int idAlimento) {
        return gestorAlimentos.eliminarAlimento(idAlimento);
    }

    public boolean modificarCliente(Cliente cliente) {
        return gestorClientes.modificarCliente(cliente);
    }

    public boolean eliminarCliente(int numeroCedula) {
        return gestorClientes.eliminarCliente(numeroCedula);
    }

    public List obtenerAlimentosDisponibles() {
        return gestorAlimentos.obtenerAlimentosDisponibles();
    }

    public List obtenerAlimentosDisponiblesFiltrados(int idTipoAlimento) {
        return gestorAlimentos.obtenerAlimentosDisponiblesFiltrados(idTipoAlimento);
    }

}
