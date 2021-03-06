package es.hazerta.uam.views;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.renderers.ButtonRenderer;

import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.logic.AlumnoLogic;
import es.hazerta.uam.windows.Añadir;
import es.hazerta.uam.windows.Borrar;
import es.hazerta.uam.windows.Buscar;

public class ApartadoAlumnos extends VerticalLayout {
	VerticalLayout infoLayout;

	public ApartadoAlumnos() {

		setSizeFull();

		VerticalSplitPanel vsplit = new VerticalSplitPanel();
		vsplit.setSplitPosition(92, Sizeable.UNITS_PERCENTAGE);
		vsplit.setSizeFull();
		vsplit.setResponsive(true);
		HorizontalLayout botonesLayout = dameBotones();
		infoLayout = dameVentana(null);

		vsplit.setFirstComponent(infoLayout);
		vsplit.setSecondComponent(botonesLayout);

		addComponent(vsplit);
	}

	public VerticalLayout dameVentana(Alumno al) {
		VerticalLayout infoLayout = new VerticalLayout();
		/*
		 * BeanItemContainer<Alumno> listaAlumnos = new
		 * BeanItemContainer<Alumno>(Alumno.class, new BBDD().obtenerAlumnos());
		 */
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos = new AlumnoLogic().obtenerAlumnos(al);

		Grid alumnos = new Grid();

		alumnos.addColumn("Id", Integer.class);
		alumnos.addColumn("Nombre", String.class);
		alumnos.addColumn("Apellidos", String.class);
		alumnos.addColumn("Dni", String.class);
		alumnos.addColumn("MesNacimiento", Integer.class);
		alumnos.addColumn("Acciones", String.class);

		for (Alumno alumno : listaAlumnos) {
			alumnos.addRow(alumno.getId(), alumno.getNombre(), alumno.getApellidos(), alumno.getDni(),
					alumno.getMesNacimiento(), "Editar");
		}

		/*
		 * GeneratedPropertyContainer gpc = new
		 * GeneratedPropertyContainer(listaAlumnos);
		 * gpc.addGeneratedProperty("editar", new
		 * PropertyValueGenerator<String>() {
		 * 
		 * @Override public String getValue(Item item, Object itemId, Object
		 * propertyId) { return "Editar"; // The caption }
		 * 
		 * @Override public Class<String> getType() { return String.class; } });
		 */

		alumnos.getColumn("Acciones").setRenderer(new ButtonRenderer(e -> {
			// int id = (int)
			// alumnos.getContainerDataSource().getItem(e.getItemId()).getItemProperty("id").getValue();
			Alumno alumno = new AlumnoLogic()
					.obtenerAlumno(alumnos.getContainerDataSource().getItem(e.getItemId()));
			infoLayout.removeAllComponents();
			System.out.println(alumno);
			infoLayout.addComponent(new EditarAlumno(alumno));
		}));

		/*
		 * for (Alumno alumno : listaAlumnos) {
		 * alumnos.addRow(alumno.getNombre(), alumno.getApellidos(),
		 * alumno.getBoton()); }
		 */

		/*
		 * alumnos.addSelectionListener(selectionEvent -> { // Java 8 // Get
		 * selection from the selection model Object selected =
		 * ((SingleSelectionModel)
		 * alumnos.getSelectionModel()).getSelectedRow();
		 * 
		 * if (selected != null) { Notification.show("Selected " +
		 * alumnos.getContainerDataSource().getItem(selected));
		 * System.out.println(alumnos.getContainerDataSource().getItem(selected)
		 * ); } else Notification.show("Nothing selected"); });
		 */

		alumnos.setStyleName("tabla");
		alumnos.setSizeFull();

		infoLayout.setSizeFull();
		infoLayout.setMargin(true);

		infoLayout.addComponent(alumnos);

		return infoLayout;
	}

	public HorizontalLayout dameBotones() {
		HorizontalLayout botonesLayout = new HorizontalLayout();
		HorizontalLayout botonesLayout2 = new HorizontalLayout();
		botonesLayout2.setSizeFull();
		Button botonNuevo = new Button("Añadir Alumno");
		Button botonBuscar = new Button("Buscar Alumno");
		Button botonBorrar = new Button("Borrar Alumno");

		botonNuevo.setStyleName("botonesOpciones");
		botonBuscar.setStyleName("botonesOpciones");
		botonBorrar.setStyleName("botonesOpciones");
		botonesLayout2.setStyleName("botonesLayout");

		botonNuevo.addClickListener(e -> {
			infoLayout.removeAllComponents();
			getUI().addWindow(new Añadir(infoLayout));
		});
		
		botonBuscar.addClickListener(e -> {
			infoLayout.removeAllComponents();
			getUI().addWindow(new Buscar(infoLayout));
		});
		
		botonBorrar.addClickListener(e -> {
			infoLayout.removeAllComponents();
			getUI().addWindow(new Borrar(infoLayout));
		});

		botonesLayout.addComponent(botonNuevo);
		botonesLayout.addComponent(botonBuscar);
		botonesLayout.addComponent(botonBorrar);
		botonesLayout2.addComponent(botonesLayout);

		return botonesLayout2;
	}
}
