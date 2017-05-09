package es.hazerta.uam.windows;

import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.logic.AlumnoLogic;
import es.hazerta.uam.views.ApartadoAlumnos;

public class Borrar extends Window {
	AlumnoLogic alController;
	public Borrar(VerticalLayout infoLayout) {
		alController = new AlumnoLogic();
		setWidth("176px");
		center();
		setResizable(false);
		setClosable(false);
		
		VerticalLayout vl = new VerticalLayout();
		
		vl.setMargin(true);
		
		List<Alumno> listaAlumnos = alController.obtenerAlumnos(null);

		IndexedContainer alumnoContenedor = new IndexedContainer();
		alumnoContenedor.addContainerProperty("id", Integer.class, null);
		alumnoContenedor.addContainerProperty("nombre", String.class, null);
		
		int i = 0;
		for (Alumno alumno : listaAlumnos) {
			Item item = alumnoContenedor.addItem(i);
			item.getItemProperty("id").setValue(alumno.getId());
			item.getItemProperty("nombre").setValue(alumno.getNombre()+" "+alumno.getApellidos());
			i++;
		}

		ComboBox select = new ComboBox();
		select.setContainerDataSource(alumnoContenedor);
		select.setItemCaptionPropertyId("nombre");
		
		Button borrar = new Button("Borrar");
		
		borrar.addClickListener(e -> {
			try {
				Item itemSelected = select.getContainerDataSource().getItem(select.getValue());
				Integer id = (Integer) itemSelected.getItemProperty("id").getValue();
				alController.borrarAlumno(id);
				infoLayout.removeAllComponents();
				infoLayout.addComponent(new ApartadoAlumnos().dameVentana(null));
				closeMyCustomWindow();
			} catch (NullPointerException error) {
				System.out.println("null exception primera selector");
			}
		});
		
		select.setWidth("150px");
		borrar.addStyleName("btnComenzarPartida");
		
		vl.addComponent(select);
		vl.addComponent(borrar);
		
		setContent(vl);
	}
	private void closeMyCustomWindow(){
		   this.close();
	}
}
