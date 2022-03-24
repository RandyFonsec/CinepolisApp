package com.example.cinepolisapp.Modelo;

public class Cliente {

    private int idCliente;
    private int numeroCedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private int edad;
    private String fechaNacimiento;
    private int cantidadVacunas;
    private boolean eliminado;
    private String contrasenna;

    public Cliente() {}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantidadVacunas() {
        return cantidadVacunas;
    }

    public void setCantidadVacunas(int cantidadVacunas) {
        this.cantidadVacunas = cantidadVacunas;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", numeroCedula=" + numeroCedula +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", cantidadVacunas=" + cantidadVacunas +
                ", eliminado=" + eliminado +
                ", contrasenna='" + contrasenna + '\'' +
                '}';
    }
}
