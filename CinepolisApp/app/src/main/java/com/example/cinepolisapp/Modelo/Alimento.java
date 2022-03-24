package com.example.cinepolisapp.Modelo;

public class Alimento {

    private int idAlimento;
    private String nombre;
    private int cantidadDisponible;
    private double precio;
    private boolean eliminado;
    private int idTipoAlimento;

    public Alimento() {}

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public int getIdTipoAlimento() {
        return idTipoAlimento;
    }

    public void setIdTipoAlimento(int idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }

}
