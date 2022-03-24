package com.example.cinepolisapp.Controlador;

import com.example.cinepolisapp.Controlador.DAO.ClienteDAOImpl;
import com.example.cinepolisapp.Modelo.Cliente;

public class GestorClientes {

    public GestorClientes() {}

    public boolean registrarCliente(Cliente cliente) {
        Cliente resultado = (Cliente) ClienteDAOImpl.getInstance().create(cliente);
        return resultado != null ? true : false;
    }

    public Cliente buscarCliente(String correoElectronico, String contrasenna) {
        return (Cliente) ClienteDAOImpl.getInstance().get(correoElectronico, contrasenna);
    }

}
