package com.example.cinepolisapp.Modelo;

public class Id {

    int idPelicula;

    public Id() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public String toString() {
        return "Id{" +
                "idPelicula=" + idPelicula +
                '}';
    }

}
