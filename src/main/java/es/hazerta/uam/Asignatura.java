package es.hazerta.uam;

public class Asignatura {
	private String descripcion;
	private String profesor;
	private int id;

	public Asignatura(String descripcion, String profesor, int id) {
		super();
		this.descripcion = descripcion;
		this.profesor = profesor;
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
