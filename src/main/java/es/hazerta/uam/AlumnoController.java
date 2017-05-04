package es.hazerta.uam;

import com.vaadin.data.Item;

public class AlumnoController {
	public AlumnoController() {
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
