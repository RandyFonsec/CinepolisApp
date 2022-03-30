package com.example.cinepolisapp.Modelo;

public class Idioma {

    private int idIdioma;
    private String nombreIdioma;

    public Idioma(int idIdioma) {
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "idIdioma=" + idIdioma +
                ", nombreIdioma='" + nombreIdioma + '\'' +
                '}';
    }

}
