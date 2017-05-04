package es.hazerta.uam;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.renderers.ButtonRenderer;

public class ApartadoAlumnos extends VerticalLayout {
	VerticalLayout infoLayout;
	public ApartadoAlumnos() {

		setSizeFull();

		VerticalSplitPanel vsplit = new VerticalSplitPanel();
		vsplit.setSplitPosition(92, Sizeable.UNITS_PERCENTAGE);
		vsplit.setSizeFull();
		vsplit.setResponsive(true);
		HorizontalLayout botonesLayout = dameBotones();
		infoLayout = dameVentana();

		vsplit.setFirstComponent(infoLayout);
		vsplit.setSecondComponent(botonesLayout);

		addComponent(vsplit);
	}

	public VerticalLayout dameVentana() {
		VerticalLayout infoLayout = new VerticalLayout();
		BeanItemContainer<Alumno> listaAlumnos =
			    new BeanItemContainer<Alumno>(Alumno.class, new BBDD().obtenerAlumnos());
		Grid alumnos = new Grid(listaAlumnos);

//		alumnos.addColumn("Nombre", String.class);
//		alumnos.addColumn("Apellidos", String.class);
//		alumnos.addColumn("Edición", Button.class);
		GeneratedPropertyContainer gpc =
			    new GeneratedPropertyContainer(listaAlumnos);
				gpc.addGeneratedProperty("nombre", new PropertyValueGenerator<String>() {

			    @Override
			    public String getValue(Item item, Object itemId,
			                           Object propertyId) {
			        return "Nombre"; // The caption
			    }

			    @Override
			    public Class<String> getType() {
			        return String.class;
			    }
			});

		alumnos.getColumn("nombre").setRenderer(new ButtonRenderer(e -> {
			//int id = (int) alumnos.getContainerDataSource().getItem(e.getItemId()).getItemProperty("id").getValue();
			Alumno alumno = new AlumnoController().obtenerAlumno(alumnos.getContainerDataSource().getItem(e.getItemId()));
			infoLayout.removeAllComponents();
			System.out.println(alumno);
			infoLayout.addComponent(new EditarAlumno(alumno));
		}));

		/*for (Alumno alumno : listaAlumnos) {
			alumnos.addRow(alumno.getNombre(), alumno.getApellidos(), alumno.getBoton());
		}*/

		/*alumnos.addSelectionListener(selectionEvent -> { // Java 8
			// Get selection from the selection model
			Object selected = ((SingleSelectionModel) alumnos.getSelectionModel()).getSelectedRow();

			if (selected != null) {
				Notification.show("Selected " + alumnos.getContainerDataSource().getItem(selected));
				System.out.println(alumnos.getContainerDataSource().getItem(selected));
			} else
				Notification.show("Nothing selected");
		});*/

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

		botonNuevo.setStyleName("botonesOpciones");
		botonBuscar.setStyleName("botonesOpciones");
		botonesLayout2.setStyleName("botonesLayout");

		botonesLayout.addComponent(botonNuevo);
		botonesLayout.addComponent(botonBuscar);
		botonesLayout2.addComponent(botonesLayout);

		return botonesLayout2;
	}
}
