package com.example.cinepolisapp.Modelo;

public class Asiento {
    private int ocupado;
    private int idFuncion;
    private int idAsientoXFuncion;

    public Asiento(){

    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdAsientoXFuncion() {
        return idAsientoXFuncion;
    }

    public void setIdAsientoXFuncion(int idAsientoXFuncion) {
        this.idAsientoXFuncion = idAsientoXFuncion;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "ocupado=" + ocupado +
                ", idFuncion=" + idFuncion +
                ", idAsientoXFuncion=" + idAsientoXFuncion +
                '}';
    }
}
