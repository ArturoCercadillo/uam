package es.hazerta.uam;

public class Alumno {
	private String dni;
	private String nombre;
	private String apellidos;
	private int mesNacimiento;
	private int id;
	private String editar;
	
	public Alumno(String dni, String nombre, String apellidos, int mesNacimiento,int id) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mesNacimiento = mesNacimiento;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public int getMesNacimiento() {
		return mesNacimiento;
	}
	public void setMesNacimiento(int mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mesNacimiento="
				+ mesNacimiento + "]";
	}
	
	
}
