package es.hazerta.uam;

import java.io.File;

import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class VistaGeneral extends VerticalLayout {
	VerticalLayout ventanaPrincipal;

	public VistaGeneral() {
		ventanaPrincipal = new VerticalLayout();
		ventanaPrincipal.setSizeFull();
		setSizeFull();
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		// VerticalLayout menuLateral = new VerticalLayout();

		hsplit.setFirstComponent(getLateral());
		hsplit.setSecondComponent(ventanaPrincipal);
		hsplit.setSizeFull();

		hsplit.setSplitPosition(250, Sizeable.UNITS_PIXELS);
		hsplit.setResponsive(true);
		addComponent(hsplit);
		// setMargin(true);
	}

	public VerticalLayout getLateral(){
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/classes/uam-logo.png"));
		
		VerticalLayout menuLateral = new VerticalLayout();
		Button alumnos = new Button("Alumnos");
		Button asignaturas = new Button("Asignaturas");
		Button profesores = new Button("Profesores");
		Image imagen = new Image(null,resource);
		
		alumnos.setStyleName("botonLateral");
		asignaturas.setStyleName("botonLateral");
		profesores.setStyleName("botonLateral");
		imagen.setWidth("100px");
		imagen.setStyleName("logoPrincipal");
		
		Panel panel = new Panel();
		VerticalLayout botones = new VerticalLayout();
		
		botones.addComponent(imagen);
		botones.addComponent(alumnos);
		botones.addComponent(asignaturas);
		botones.addComponent(profesores);
		botones.setComponentAlignment(imagen, Alignment.TOP_CENTER);
		
		panel.setContent(botones);
		
		menuLateral.addComponent(botones);
		menuLateral.setStyleName("menuLateral");
		menuLateral.setMargin(true);
		menuLateral.setSizeFull();
		
		alumnos.addClickListener(e -> {	
		ventanaPrincipal.removeAllComponents();
		ventanaPrincipal.addComponent(new ApartadoAlumnos());
		});
		
		asignaturas.addClickListener(e -> {	
			ventanaPrincipal.removeAllComponents();
			ventanaPrincipal.addComponent(new ApartadoAsignaturas());
			});
		
		profesores.addClickListener(e -> {	
			ventanaPrincipal.removeAllComponents();
			ventanaPrincipal.addComponent(new ApartadoProfesores());
			});

		return menuLateral;
}
}
