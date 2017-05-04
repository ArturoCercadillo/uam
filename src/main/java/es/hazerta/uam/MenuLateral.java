package es.hazerta.uam;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class MenuLateral extends VerticalLayout {
	public MenuLateral() {

		setStyleName("menuLateral");
		setMargin(true);
		setSizeFull();
		
		addComponent(new ApartadoAlumnos());
		addComponent(new ApartadoAsignaturas());
		addComponent(new ApartadoProfesores());
	}
}
