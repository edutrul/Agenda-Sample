/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.mobile;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import com.agenda.data.*;

/**
 * @author Administrador
 */
public class MidletAgenda extends MIDlet implements CommandListener{
    
    private List menu;
    private Display display;
    private Command btnSalir;
    private Command btnGuardar;
    private Form formListarPersonas;
    private Form formAgregarPersonas;
    private Agenda agenda;
    private TextField txtfieldDni;
    private TextField txtfieldNombre;
    private Alert alerta;
    
    public MidletAgenda() {
        this.agenda = new Agenda();
        this.menu = new List("Menu: Agenda", List.IMPLICIT);
        this.menu.insert(0, "Listar contacto", null);
        this.menu.insert(1, "Agregar contacto", null);
        this.menu.insert(2, "Modificar contacto", null);
        this.menu.insert(3, "Buscar contacto", null);
        this.menu.insert(4, "Eliminar contacto", null);
        this.formListarPersonas = new Form("Lista de contactos");
        this.formAgregarPersonas = new Form("Agregar contacto");
        this.txtfieldDni = new TextField("DNI", "", 8, TextField.NUMERIC);
        this.txtfieldNombre = new TextField("Nombres", "", 40, TextField.ANY);
        this.btnSalir = new Command("Salir", Command.EXIT, 4);
        this.btnGuardar = new Command("Guardar", Command.OK, 3);
        this.menu.addCommand(btnSalir);
        this.menu.setCommandListener(this);
        this.display = Display.getDisplay(this);
    }
    
    public void startApp() {
        display.setCurrent(this.menu);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if ((c == List.SELECT_COMMAND) && (d == menu)) {
	    switch(menu.getSelectedIndex()) {
                case 0: formListarContactos();
                        display.setCurrent(this.formListarPersonas);
                    break;
                case 1: formAgregarContactos();
                        display.setCurrent(this.formAgregarPersonas);
                    break;
                case 2: break;
           }
	}
 	if (c == btnSalir) {
            destroyApp(false);
            notifyDestroyed();
    	}
        
        if (c == this.btnGuardar) {
            Persona personaGuardar;
            personaGuardar = new Persona(Integer.parseInt(String.valueOf(this.txtfieldDni.getString())), 
                                         String.valueOf(this.txtfieldNombre.getString()), "M", true);
            this.agenda.agregarPersona(personaGuardar);
            this.alerta = new Alert("Menu principal");
            this.alerta.setTimeout(3000);
            this.display.setCurrent(alerta, menu);
        }
        
    }
    
    public void formListarContactos() {
        this.agenda.agregarPersona(new Persona(46083350, "Eduardo Telaya", "M", true));
        this.agenda.agregarPersona(new Persona(46083351, "Cristhian Huamancayo", "M", true));
        this.formListarPersonas.append(new StringItem("Contactos", this.agenda.listarPersonas()));
    }
    
    public void formAgregarContactos() {
        this.formAgregarPersonas.append(this.txtfieldDni);
        this.formAgregarPersonas.append(this.txtfieldNombre);
        this.formAgregarPersonas.addCommand(this.btnGuardar);
        this.formAgregarPersonas.setCommandListener(this);
    }
}
