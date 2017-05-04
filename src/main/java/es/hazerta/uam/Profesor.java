package es.hazerta.uam;

public class Profesor {
	private String nombre;
	private String apellidos;
	private int despacho;
	private int id;

	public Profesor(String nombre, String apellidos, int despacho, int id) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDespacho() {
		return despacho;
	}

	public void setDespacho(int despacho) {
		this.despacho = despacho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
