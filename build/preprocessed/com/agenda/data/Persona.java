package com.agenda.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Persona {
    private int dni;
    private String nombre;
    private String sexo;
    private boolean activo;

    public Persona(int dni, String nombre, String sexo, boolean isActivo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        this.activo = isActivo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean isActivo) {
        this.activo = isActivo;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
               "Dni: " + this.dni + "\n" +
               "Nombre: " + this.sexo;
    }
}
