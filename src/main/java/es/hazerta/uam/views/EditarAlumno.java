package es.hazerta.uam.views;

import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.beans.Asignatura;
import es.hazerta.uam.beans.Nota;
import es.hazerta.uam.logic.AlumnoLogic;

public class EditarAlumno extends VerticalLayout {
	Alumno alumno;
	AlumnoLogic alController;

	public EditarAlumno(Alumno alumno) {
		this.alumno = alumno;
		this.alController = new AlumnoLogic();
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
		
		HorizontalLayout fila1 = new HorizontalLayout();
		HorizontalLayout fila2 = new HorizontalLayout();
		
		fila1.setStyleName("edicion_fila");
		fila2.setStyleName("edicion_fila");
		
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
			alController.actualizarAlumno(alumno); 
		});
		
		edicion.setSizeFull();

		fila1.addComponent(nombre);
		fila1.addComponent(apellidos);
		fila2.addComponent(dni);
		fila2.addComponent(mesNacimiento);
		edicion.addComponent(fila1);
		edicion.addComponent(fila2);
		edicion.addComponent(guardar);

		return edicion;
	}

	/**
	 * @return
	 */
	public VerticalSplitPanel dameAsignaturasProfesores() {
		VerticalSplitPanel asignaturasSplit = new VerticalSplitPanel();
		VerticalLayout asignaturas = new VerticalLayout();
//		BeanItemContainer<Asignatura> listaAsignaturas = new BeanItemContainer<Asignatura>(Asignatura.class,
//				new BBDD().obtenerAsignaturasAlumno(alumno.getId()));
//		Grid asignaturasGrid = new Grid(listaAsignaturas);
		Grid asignaturasGrid = new Grid();

//		asignaturasGrid.setColumnOrder("id", "descripcion", "profesor", "media");
		
		asignaturasGrid.addColumn("Asignatura", String.class);
		asignaturasGrid.addColumn("Media", Double.class);
		
		for(Asignatura asignatura : alController.obtenerAsignaturasAlumno(alumno.getId())){
			asignaturasGrid.addRow(asignatura.getDescripcion(), asignatura.getMedia());
		}

		asignaturas.setSizeFull();
		asignaturasGrid.setSizeFull();

		asignaturas.addComponent(asignaturasGrid);

		VerticalLayout nuevaAsignaturaLayout = new VerticalLayout();
		HorizontalLayout nuevaAsignaturaLayoutForm = new HorizontalLayout();
		
		Label titulo = new Label("Matricularme en otra asignatura");
		
		List<Asignatura> listaAsignaturasNoMatricula = alController.obtenerAsignaturasNoMatricula(alumno.getId());

		IndexedContainer asignaturasContenedor = new IndexedContainer();
		asignaturasContenedor.addContainerProperty("id", Integer.class, null);
		asignaturasContenedor.addContainerProperty("descripcion", String.class, null);
		
		int i = 0;
		for (Asignatura asignatura : listaAsignaturasNoMatricula) {
			Item item = asignaturasContenedor.addItem(i);
			item.getItemProperty("id").setValue(asignatura.getId());
			item.getItemProperty("descripcion").setValue(asignatura.getDescripcion());
			i++;
		}

		ComboBox select = new ComboBox();
		select.setContainerDataSource(asignaturasContenedor);
		select.setItemCaptionPropertyId("descripcion");
		
		Button matricular = new Button("Matricular");
		matricular.addClickListener(e -> {
			try {
				Item itemSelected = select.getContainerDataSource().getItem(select.getValue());
				Integer id = (Integer) itemSelected.getItemProperty("id").getValue();
				String descripcion = (String) itemSelected.getItemProperty("descripcion").getValue();
				alController.nuevaAsignaturaAlumno(alumno, new Asignatura(descripcion, "", id, 0));
			} catch (NullPointerException error) {
				System.out.println("null exception primera selector");
			}
		});
		
		nuevaAsignaturaLayout.setStyleName("nuevaAsignaturaLayout");
		nuevaAsignaturaLayoutForm.setStyleName("nuevaAsignaturaLayoutForm");
		
		nuevaAsignaturaLayout.addComponent(titulo);
		nuevaAsignaturaLayoutForm.addComponent(select);
		nuevaAsignaturaLayoutForm.addComponent(matricular);
		nuevaAsignaturaLayout.addComponent(nuevaAsignaturaLayoutForm);
		//asignaturas.addComponent(nuevaAsignaturaLayout);
		
		asignaturasSplit.setSplitPosition(70, Sizeable.UNITS_PERCENTAGE);
		asignaturasSplit.setFirstComponent(asignaturas);
		asignaturasSplit.setSecondComponent(nuevaAsignaturaLayout);
		
		return asignaturasSplit;

	}

	public VerticalLayout dameNotas() {
		VerticalLayout notas = new VerticalLayout();
		BeanItemContainer<Nota> listaNotas = new BeanItemContainer<Nota>(Nota.class,
				alController.obtenerNotasAlumno(alumno.getId()));
		Grid notasGrid = new Grid(listaNotas);

		notasGrid.setColumnOrder("asignatura", "profesor", "descripcion", "nota");
		notas.setSizeFull();
		notasGrid.setSizeFull();

		notas.addComponent(notasGrid);
		return notas;

	}
}
