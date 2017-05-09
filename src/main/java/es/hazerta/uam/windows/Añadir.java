package es.hazerta.uam.windows;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.logic.AlumnoLogic;
import es.hazerta.uam.views.ApartadoAlumnos;

public class Añadir extends Window {
	public Añadir(VerticalLayout infoLayout) {
		setWidth("176px");
		center();
		setResizable(false);
		setClosable(false);

		VerticalLayout vl = new VerticalLayout();

		vl.setMargin(true);

		TextField nombre = new TextField("Nombre");
		TextField apellidos = new TextField("Apellidos");
		TextField dni = new TextField("DNI");
		TextField mesNacimiento = new TextField("Mes de Nacimiento");

		nombre.setWidth("150px");
		apellidos.setWidth("150px");
		dni.setWidth("150px");
		mesNacimiento.setWidth("150px");

		vl.addComponent(nombre);
		vl.addComponent(apellidos);
		vl.addComponent(dni);
		vl.addComponent(mesNacimiento);

		HorizontalLayout botones = new HorizontalLayout();
		Button añadir = new Button("Añadir");

		añadir.addStyleName("btnComenzarPartida");
		añadir.setWidth("150px");
		añadir.addClickListener(e -> {
			infoLayout.removeAllComponents();
			Alumno alumno;
			try {
				alumno = new Alumno(dni.getValue(), nombre.getValue(), apellidos.getValue(),
						Integer.parseInt(mesNacimiento.getValue()), 0);
			} catch (NumberFormatException error) {
				alumno = null;
				Notification.show("Error de introducción");
			}
			if (alumno != null) {
				new AlumnoLogic().nuevoAlumno(alumno);
				infoLayout.addComponent(new ApartadoAlumnos().dameVentana(null));
				closeMyCustomWindow();
			}
		});

		botones.addComponent(añadir);
		botones.addStyleName("botones");

		vl.addComponent(botones);

		setContent(vl);
	}

	private void closeMyCustomWindow() {
		this.close();
	}
}
