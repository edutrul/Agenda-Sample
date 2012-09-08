package com.agenda.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Agenda {
    private Persona []personas;
    public int contador;

    public Agenda() {
        personas = new Persona[50];
    }
    
    public void agregarPersona(Persona persona) {
        this.personas[contador++] = persona;
    }
    
    public int borrarPersona(int dni) {
        for (int i = 0; i < contador; i++) {
            if (this.personas[i].getDni() == dni) {
                this.personas[i].setActivo(true);
                return 1;
            }
        }
        return 0;
    }
    
    public int modificarPersona(int dni, Persona persona) {
        for (int i = 0; i < contador; i++) {
            if (this.personas[i].getDni() == dni) {
                this.personas[i] = persona;
                return 1;
            }
        }
        return 0;
    }
    
    public Persona buscarPersona(int dni) {
        for (int i = 0; i < contador; i++) {
            if (this.personas[i].getDni() == dni) {
                return this.personas[i];
            }
        }
        return null;
    }
    
    public String listarPersonas() {
        String registro = "";
        for (int i = 0; i < contador; i++) {
            if (this.personas[i].isActivo()) {
                registro += this.personas[i].toString();
            }
        }
        return registro;
    }
    
}
