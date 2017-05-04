package es.hazerta.uam;

public class Nota {
	private int nota;
	private String asignatura;
	private String profesor;
	private String descripcion;

	public Nota(int nota, String asignatura, String profesor, String descripcion) {
		super();
		this.nota = nota;
		this.asignatura = asignatura;
		this.profesor = profesor;
		this.descripcion = descripcion;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
