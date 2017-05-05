package es.hazerta.uam;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Buscar extends Window {
	public Buscar(VerticalLayout infoLayout) {
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
		Button comenzar = new Button("Buscar");
		
		comenzar.addStyleName("btnComenzarPartida");
		comenzar.setWidth("150px");
		comenzar.addClickListener(e -> {
			infoLayout.removeAllComponents();
			Alumno alumno;
			try{
				alumno = new Alumno(dni.getValue(), nombre.getValue(), apellidos.getValue(), Integer.parseInt(mesNacimiento.getValue()), 0);
			}catch(NumberFormatException error){
				alumno = new Alumno(dni.getValue(), nombre.getValue(), apellidos.getValue(), -1, 0);
			}
			infoLayout.addComponent(new ApartadoAlumnos().dameVentana(alumno));
			closeMyCustomWindow();
		});
		
		botones.addComponent(comenzar);
		botones.addStyleName("botones");
		
		vl.addComponent(botones);
		
		setContent(vl);
	}
	private void closeMyCustomWindow(){
		   this.close();
	}
}
