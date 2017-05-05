package es.hazerta.uam;

import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class EditarAlumno extends VerticalLayout {
	Alumno alumno;

	public EditarAlumno(Alumno alumno) {
		this.alumno = alumno;
		setSizeFull();
		HorizontalLayout fila1 = new HorizontalLayout();
		HorizontalLayout fila2 = new HorizontalLayout();

		fila1.setSizeFull();
		fila2.setSizeFull();

		fila1.addComponent(dameEdicion());
		fila1.addComponent(dameAsignaturasProfesores());

		// fila2.addComponent(dameProfesores());
		fila2.addComponent(dameNotas());

		addComponent(fila1);
		addComponent(fila2);

	}

	public VerticalLayout dameEdicion() {
		VerticalLayout edicion = new VerticalLayout();
		TextField nombre = new TextField("Nombre");
		TextField apellidos = new TextField("Apellidos");
		TextField dni = new TextField("DNI");
		TextField mesNacimiento = new TextField("Mes de Nacimiento");
		Button guardar = new Button("Guardar");

		nombre.setValue(alumno.getNombre());
		apellidos.setValue(alumno.getApellidos());
		dni.setValue(alumno.getDni());
		mesNacimiento.setValue(Integer.toString(alumno.getMesNacimiento()));
		guardar.addClickListener(e -> {
			alumno = new Alumno(dni.getValue(), nombre.getValue(), apellidos.getValue(),
					Integer.parseInt(mesNacimiento.getValue()), alumno.getId());
			new BBDD().actualizarAlumno(alumno);
		});

		edicion.setSizeFull();

		edicion.addComponent(nombre);
		edicion.addComponent(apellidos);
		edicion.addComponent(dni);
		edicion.addComponent(mesNacimiento);
		edicion.addComponent(guardar);

		return edicion;
	}

	/**
	 * @return
	 */
	public VerticalLayout dameAsignaturasProfesores() {
		VerticalLayout asignaturas = new VerticalLayout();
		BeanItemContainer<Asignatura> listaAsignaturas = new BeanItemContainer<Asignatura>(Asignatura.class,
				new BBDD().obtenerAsignaturasAlumno(alumno.getId()));
		Grid asignaturasGrid = new Grid(listaAsignaturas);
		
		asignaturasGrid.setColumnOrder("id", "descripcion","profesor","media");
		
		asignaturas.setSizeFull();
		asignaturasGrid.setSizeFull();

		asignaturas.addComponent(asignaturasGrid);
		
		HorizontalLayout nuevaAsignaturaLayout = new HorizontalLayout();
		BeanItemContainer<Asignatura> listaAsignaturasNoMatricula =
			    new BeanItemContainer<Asignatura>(Asignatura.class, new BBDD().obtenerAsignaturasNoMatricula(alumno.getId()));
		//List<Asignatura> listaAsignaturasNoMatricula = new BBDD().obtenerAsignaturasNoMatricula(alumno.getId());
		ComboBox select = new ComboBox("My Select", listaAsignaturasNoMatricula);
		select.setItemCaptionPropertyId("descripcion");
		select.addFocusListener(e -> {
			Notification.show(select.getValue().toString());
		});
		nuevaAsignaturaLayout.addComponent(select);
		asignaturas.addComponent(nuevaAsignaturaLayout);
		
		return asignaturas;

	}

	public VerticalLayout dameNotas() {
		VerticalLayout notas = new VerticalLayout();
		BeanItemContainer<Nota> listaNotas = new BeanItemContainer<Nota>(Nota.class,
				new BBDD().obtenerNotasAlumno(alumno.getId()));
		Grid notasGrid = new Grid(listaNotas);

		notasGrid.setColumnOrder("asignatura","profesor","descripcion","nota");
		notas.setSizeFull();
		notasGrid.setSizeFull();

		notas.addComponent(notasGrid);
		return notas;

	}
}
