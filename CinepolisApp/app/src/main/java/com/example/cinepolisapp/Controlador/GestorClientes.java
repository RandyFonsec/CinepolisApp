package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Modelo.Cliente;

import java.util.List;

public class GestorClientes {

    public GestorClientes() {}

    public boolean registrarCliente(Cliente cliente) {
        Cliente resultado = (Cliente) ClienteDAOImpl.getInstance().create(cliente);
        return resultado != null ? true : false;
    }

    public Cliente buscarCliente(String correoElectronico, String contrasenna) {
        return (Cliente) ClienteDAOImpl.getInstance().get(correoElectronico, contrasenna);
    }

    public Cliente buscarCliente(long numeroCedula) {
        return (Cliente) ClienteDAOImpl.getInstance().get(numeroCedula);
    }

    public boolean modificarCliente(Cliente cliente) {
        Cliente resultado = (Cliente) ClienteDAOImpl.getInstance().update(cliente);
        return resultado != null ? true : false;
    }

    public boolean eliminarCliente(int numeroCedula) {
        Cliente resultado = (Cliente) ClienteDAOImpl.getInstance().delete(numeroCedula);
        return resultado != null ? true : false;
    }

    public List<Cliente> getClientes(){
        return ClienteDAOImpl.getInstance().getAll();
    }

}
