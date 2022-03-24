package com.example.cinepolisapp.Modelo;

public class Pelicula {

    private int idPelicula;
    private String titulo;
    private int annoPublicacion;
    private double duracion;
    private int edadRequerida;
    private double precioEntrada;
    private int eliminada;
    private int idDirector;

    public Pelicula() {
    }

    public int getIdPelicula() { return idPelicula; }

    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnnoPublicacion() { return annoPublicacion; }

    public void setAnnoPublicacion(int annoPublicacion) { this.annoPublicacion = annoPublicacion; }

    public double getDuracion() { return duracion; }

    public void setDuracion(double duracion) { this.duracion = duracion ;}

    public int getEdadRequerida() { return edadRequerida; }

    public void setEdadRequerida(int edadRequerida) { this.edadRequerida = edadRequerida; }

    public double getPrecioEntrada() { return precioEntrada; }

    public void setPrecioEntrada(double precioEntrada) { this.precioEntrada = precioEntrada; }

    public int getEliminada() { return eliminada; }

    public void setEliminada(int eliminada) { this.eliminada = eliminada; }

    public int getIdDirector() { return idDirector; }

    public void setIdDirector(int idDirector) { this.idDirector = idDirector; }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", annoPublicacion=" + annoPublicacion +
                ", duracion=" + duracion +
                ", edadRequerida=" + edadRequerida +
                ", precioEntrada=" + precioEntrada +
                ", eliminada=" + eliminada +
                ", idDirector=" + idDirector +
                '}';
    }

}
