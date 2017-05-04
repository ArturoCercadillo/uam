package es.hazerta.uam;

import com.vaadin.data.Item;

public class AlumnoController {
	public AlumnoController() {
		// TODO Auto-generated constructor stub
	}
	public Alumno obtenerAlumno(Item item){
		int id = (int) item.getItemProperty("id").getValue();
		String dni = (String) item.getItemProperty("dni").getValue();
		String nombre = (String) item.getItemProperty("nombre").getValue();
		String apellidos = (String) item.getItemProperty("apellidos").getValue();
		int mesNacimiento = (int) item.getItemProperty("mesNacimiento").getValue();
		
		return new Alumno(dni, nombre, apellidos, mesNacimiento, id);
	}
}
