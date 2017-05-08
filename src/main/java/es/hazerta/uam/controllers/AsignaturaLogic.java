package es.hazerta.uam.controllers;

import com.vaadin.data.Item;

import es.hazerta.uam.beans.Alumno;

public class AsignaturaLogic {
	public AsignaturaLogic() {
		// TODO Auto-generated constructor stub
	}
	public Alumno obtenerAlumno(Item item){
		int id = (int) item.getItemProperty("Id").getValue();
		String dni = (String) item.getItemProperty("Dni").getValue();
		String nombre = (String) item.getItemProperty("Nombre").getValue();
		String apellidos = (String) item.getItemProperty("Apellidos").getValue();
		int mesNacimiento = (int) item.getItemProperty("MesNacimiento").getValue();
		
		return new Alumno(dni, nombre, apellidos, mesNacimiento, id);
	}
}
