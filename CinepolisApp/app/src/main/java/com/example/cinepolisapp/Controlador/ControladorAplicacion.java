package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Modelo.Actor;
import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Asiento;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Director;
import com.example.cinepolisapp.Modelo.Funcion;
import com.example.cinepolisapp.Modelo.Genero;
import com.example.cinepolisapp.Modelo.Horario;
import com.example.cinepolisapp.Modelo.Idioma;
import com.example.cinepolisapp.Modelo.Pelicula;

import java.util.List;

public class ControladorAplicacion {

    private static ControladorAplicacion singletonControllerInstance;
    private GestorClientes gestorClientes;
    private GestorPeliculas gestorPeliculas;
    private GestorAlimentos gestorAlimentos;
    private GestorCartelera gestorCartelera;
    private GestorAsientos gestorAsientos;
    private GestorUtils gestorUtils;

    private ControladorAplicacion() {
        gestorClientes = new GestorClientes();
        gestorPeliculas = new GestorPeliculas();
        gestorAlimentos = new GestorAlimentos();
        gestorCartelera = new GestorCartelera();
        gestorAsientos = new GestorAsientos();
        gestorUtils = new GestorUtils();
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

    public Cliente buscarCliente(long numeroCedula) {
        return gestorClientes.buscarCliente(numeroCedula);
    }

    public Pelicula agregarPelicula(Pelicula pelicula) {
        return gestorPeliculas.agregarPelicula(pelicula);
    }

    public Pelicula modificarPelicula(Pelicula pelicula) {
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

    public List<Pelicula> getPeliculasEnCartelera(){
        return gestorPeliculas.getPeliculasEnCartelera();
    }

    public List<Asiento> getAsientosDeFuncion(int idFuncion){
        return gestorAsientos.getAsientosDeFuncion(idFuncion);
    }

    public List obtenerDirectores() {
        return gestorUtils.obtenerDirectores();
    }

    public List<Idioma> obtenerIdiomas() {
        return gestorUtils.obtenerIdiomas();
    }

    public List<Actor> obtenerActores() {
        return gestorUtils.obtenerActores();
    }

    public List<Genero> obtenerGeneros() { return gestorUtils.obtenerGeneros(); }

    public int agregarActorXPelicula(int idPelicula, int idActor) {
        return gestorUtils.agregarActorXPelicula(idPelicula, idActor);
    }

    public int agregarGeneroXPelicula(int idPelicula, int idGenero) {
        return gestorUtils.agregarGeneroXPelicula(idPelicula, idGenero);
    }

    public int agregarIdiomaXPelicula(int idPelicula, int idIdioma) {
        return gestorUtils.agregarIdiomaXPelicula(idPelicula, idIdioma);
    }

    public List<Cliente> getClientes(){
        return gestorClientes.getClientes();
    }

    public boolean actualizarCliente(Cliente cliente){
        return gestorClientes.modificarCliente(cliente);
    }

    public List<Pelicula> getPeliculas(){
        return gestorPeliculas.getPeliculas();
    }

    public List<Horario> getHorariosDisponibles(int idSala, String fecha){
        return gestorUtils.getHorariosDisponibles(idSala, fecha);
    }

    public Funcion insertFuncion(int idHorario, int idSala, int idPelicula, String fecha){
        return gestorUtils.insertFuncion(idHorario, idSala, idPelicula, fecha);

    }

}
