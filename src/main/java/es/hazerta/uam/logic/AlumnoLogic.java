package es.hazerta.uam.logic;

import java.util.List;

import com.vaadin.data.Item;

import es.hazerta.uam.bbdd.BBDD;
import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.beans.Asignatura;
import es.hazerta.uam.beans.Nota;



public class AlumnoLogic {
	private BBDD bbdd;
	public AlumnoLogic() {
		bbdd = new BBDD();
	}
	public Alumno obtenerAlumno(Item item){
		int id = (int) item.getItemProperty("Id").getValue();
		String dni = (String) item.getItemProperty("Dni").getValue();
		String nombre = (String) item.getItemProperty("Nombre").getValue();
		String apellidos = (String) item.getItemProperty("Apellidos").getValue();
		int mesNacimiento = (int) item.getItemProperty("MesNacimiento").getValue();
		
		return new Alumno(dni, nombre, apellidos, mesNacimiento, id);
	}
	public List<Alumno> obtenerAlumnos(Alumno alumno){
		return bbdd.obtenerAlumnos(alumno);
	}
	public void actualizarAlumno(Alumno alumno){
		bbdd.actualizarAlumno(alumno);
	}
	public void nuevaAsignaturaAlumno(Alumno alumno, Asignatura asignatura){
		bbdd.nuevaAsignaturaAlumno(alumno, asignatura);
	}
	public List<Asignatura> obtenerAsignaturasAlumno(int alumno) {
		return bbdd.obtenerAsignaturasAlumno(alumno);
	}
	public List<Asignatura> obtenerAsignaturasNoMatricula(int alumno) {
		return bbdd.obtenerAsignaturasNoMatricula(alumno);
	}
	public List<Nota> obtenerNotasAlumno(int alumno){
		return bbdd.obtenerNotasAlumno(alumno);
	}
	public void nuevoAlumno(Alumno alumno){
		bbdd.nuevoAlumno(alumno);
	}
	public void borrarAlumno(int alumno){
		bbdd.borrarAlumno(alumno);
	}
}
