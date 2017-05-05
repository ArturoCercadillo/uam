package es.hazerta.uam;

public class Asignatura {
	private String descripcion;
	private String profesor;
	private int id;
	private double media;

	public Asignatura(String descripcion, String profesor, int id, double media) {
		super();
		this.descripcion = descripcion;
		this.profesor = profesor;
		this.id = id;
		this.media = media;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
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
