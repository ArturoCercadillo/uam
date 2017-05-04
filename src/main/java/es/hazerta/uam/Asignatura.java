package es.hazerta.uam;

public class Asignatura {
	private String descripcion;
	private int profesor;
	private int id;

	public Asignatura(String descripcion, int profesor, int id) {
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

	public int getProfesor() {
		return profesor;
	}

	public void setProfesor(int profesor) {
		this.profesor = profesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
