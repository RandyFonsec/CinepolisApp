package com.example.cinepolisapp.Modelo;

public class Genero {

    int idGenero;
    String nombreGenero;

    public Genero() {
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombre) {
        this.nombreGenero = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", nombre='" + nombreGenero + '\'' +
                '}';
    }

}
