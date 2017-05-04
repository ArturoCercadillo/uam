package es.hazerta.uam;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ApartadoProfesores extends VerticalLayout {
	public ApartadoProfesores() {
		Label textoApartado = new Label("PROFESORES");
		Button botonNuevoAlumno = new Button("Nuevo Alumno");
		Button botonListadoAlumnos = new Button("Listado Alumnos");
		Button botonBuscarAlumno = new Button("Buscar Alumno");
		
		botonBuscarAlumno.setStyleName("botonLateral");
		botonListadoAlumnos.setStyleName("botonLateral");
		botonNuevoAlumno.setStyleName("botonLateral");
		textoApartado.setStyleName("textoApartado");
		
		addComponent(textoApartado);
		addComponent(botonBuscarAlumno);
		addComponent(botonListadoAlumnos);
		addComponent(botonNuevoAlumno);
	}
	
}
