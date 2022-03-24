package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;

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
        if (singletonControllerInstance == null) {
            singletonControllerInstance = new ControladorAplicacion();
        }
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



}
