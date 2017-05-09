package es.hazerta.uam.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Notification;

import es.hazerta.uam.beans.Alumno;
import es.hazerta.uam.beans.Asignatura;
import es.hazerta.uam.beans.Nota;
import es.hazerta.uam.beans.Profesor;
import es.hazerta.uam.utils.Constantes;

public class BBDD {
	Connection conn;

	public BBDD() {
		// TODO Auto-generated constructor stub
		
	}

	public List<Alumno> obtenerAlumnos(Alumno alumno) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "";
			boolean where = false;
			if (alumno == null)
				SQL = "SELECT * FROM alumnos";
			else {
				SQL = "SELECT * FROM alumnos ";
				if (alumno.getNombre() != "") {
					SQL += "WHERE nombre like '%" + alumno.getNombre() + "%' ";
					where = true;
				}
				if (alumno.getApellidos() != "")
					if (where)
						SQL += "AND apellidos like '%" + alumno.getApellidos() + "%' ";
					else {
						SQL += "WHERE apellidos like '%" + alumno.getApellidos() + "%' ";
						where = true;
					}
				if (alumno.getDni() != "")
					if (where)
						SQL += "AND dni like '%" + alumno.getDni() + "%' ";
					else {
						SQL += "WHERE dni like '%" + alumno.getDni() + "%' ";
						where = true;
					}
				if (alumno.getMesNacimiento() > 0)
					if (where)
						SQL += "AND mes_nacimiento = " + alumno.getMesNacimiento();
					else {
						SQL += "WHERE mes_nacimiento = " + alumno.getMesNacimiento();
					}
			}
			System.out.println(SQL);
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery(SQL);
			while (rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int mesNacimiento = rs.getInt("mes_nacimiento");
				int id = rs.getInt("id");
				alumnos.add(new Alumno(dni, nombre, apellidos, mesNacimiento, id));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

	public void actualizarAlumno(Alumno alumno) {
		Notification.show("Actualizamos");
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "update alumnos set dni = ?, nombre = ?, apellidos = ?, mes_nacimiento = ? where id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(SQL);
			preparedStmt.setString(1, alumno.getDni());
			preparedStmt.setString(2, alumno.getNombre());
			preparedStmt.setString(3, alumno.getApellidos());
			preparedStmt.setInt(4, alumno.getMesNacimiento());
			preparedStmt.setInt(5, alumno.getId());
			conn.setAutoCommit(true);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
	}

	public List<Asignatura> obtenerAsignaturasAlumno(int alumno) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		if (alumno != 0) {
			try {
				Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				/*
				 * String SQL = "SELECT *, avg(calificacion) media"; SQL +=
				 * "FROM asignaturas"; SQL +=
				 * "inner join alumnos_has_asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura "
				 * ; SQL +=
				 * "inner join profesores on asignaturas.profesor = profesores.id "
				 * ; SQL +=
				 * "left join notas on asignaturas.id = notas.asignatura and alumnos_has_asignaturas.alumno = notas.alumno "
				 * ; SQL += "where alumnos_has_asignaturas.alumno=" + alumno;
				 * SQL += "group by asignaturas.descripcion";
				 */

				String SQL = "SELECT *, avg(calificacion) media ";
				SQL += "FROM alumnos ";
				SQL += "inner join alumnos_has_asignaturas on alumnos_has_asignaturas.alumno = alumnos.id ";
				SQL += "inner join asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura ";
				SQL += "inner join profesores on asignaturas.profesor = profesores.id ";
				SQL += "left join notas on notas.alumno = alumnos.id and notas.asignatura = asignaturas.id ";
				SQL += "WHERE alumnos.id=" + alumno;
				SQL += " GROUP BY asignaturas.id ORDER BY media desc";

				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(SQL);
				while (rs.next()) {
					String descripcion = rs.getString("descripcion");
					String profesor = rs.getString("nombre") + " " + rs.getString("apellidos");
					int id = rs.getInt("id");
					double media = rs.getFloat("media");
					asignaturas.add(new Asignatura(descripcion, profesor, id, media));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return asignaturas;
	}

	public List<Profesor> obtenerProfesoresAlumno(int alumno) {
		List<Profesor> profesores = new ArrayList<Profesor>();
		if (alumno != 0) {
			try {
				Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				String SQL = "SELECT * FROM profesores inner join asignaturas on profesores.id = profesor inner join alumnos_has_asignaturas on asignaturas.id = asignatura where alumno="
						+ alumno;
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(SQL);
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellidos");
					int despacho = rs.getInt("despacho");
					int id = rs.getInt("id");
					profesores.add(new Profesor(nombre, apellidos, despacho, id));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return profesores;
	}

	public List<Nota> obtenerNotasAlumno(int alumno) {
		List<Nota> notas = new ArrayList<Nota>();
		if (alumno != 0) {
			try {
				Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				String SQL = "SELECT * FROM universidad.notas inner join alumnos on alumno = alumnos.id inner join asignaturas on asignatura = asignaturas.id inner join profesores on asignaturas.profesor = profesores.id where notas.alumno="
						+ alumno;
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(SQL);
				while (rs.next()) {
					String descripcion = rs.getString("notas.descripcion");
					String asignatura = rs.getString("asignaturas.descripcion");
					String profesor = rs.getString("profesores.nombre") + " " + rs.getString("profesores.apellidos");
					int nota = rs.getInt("calificacion");
					notas.add(new Nota(nota, asignatura, profesor, descripcion));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return notas;
	}

	public List<Asignatura> obtenerAsignaturasNoMatricula(int alumno) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		if (alumno != 0) {
			try {
				Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				/*
				 * String SQL = "SELECT *, avg(calificacion) media"; SQL +=
				 * "FROM asignaturas"; SQL +=
				 * "inner join alumnos_has_asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura "
				 * ; SQL +=
				 * "inner join profesores on asignaturas.profesor = profesores.id "
				 * ; SQL +=
				 * "left join notas on asignaturas.id = notas.asignatura and alumnos_has_asignaturas.alumno = notas.alumno "
				 * ; SQL += "where alumnos_has_asignaturas.alumno=" + alumno;
				 * SQL += "group by asignaturas.descripcion";
				 */
				
				String SQL = "SELECT * ";
				SQL += "FROM asignaturas ";
				SQL += "WHERE asignaturas.id!=any(";
				SQL += "SELECT asignatura from alumnos_has_asignaturas where alumno=" + alumno+")";

				System.out.println(SQL);

				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(SQL);
				while (rs.next()) {
					String descripcion = rs.getString("descripcion");
					String profesor = rs.getString("profesor");
					int id = rs.getInt("id");
					double media = 0;
					asignaturas.add(new Asignatura(descripcion, profesor, id, media));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(asignaturas);
		return asignaturas;
	}
	public void nuevaAsignaturaAlumno(Alumno alumno, Asignatura asignatura) {
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "INSERT INTO alumnos_has_asignaturas (alumno, asignatura) VALUES (?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(SQL);
			preparedStmt.setInt(1, alumno.getId());
			preparedStmt.setInt(2, asignatura.getId());
			conn.setAutoCommit(true);
			preparedStmt.executeUpdate();
			conn.close();
			Notification.show("Enhorabuena, ahora estás matriculado en "+asignatura.getDescripcion());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
	}
	public boolean login(String user, String pass) {
		if (esAlumno(user, pass))
			return true;
		else
			return esProfesor(user, pass);
		
	}
	public boolean esAlumno(String user, String pass){
		boolean sw = false;
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "SELECT * FROM alumnos where nombre='"+user+"'";
			System.out.println(SQL);
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery(SQL);
			while (rs.next()) {
				if (pass.equals(rs.getString("dni")))
					sw=true;
			}
			if (!sw){
				SQL = "SELECT * FROM profesores where nombre='"+user+"'";
				System.out.println(SQL);
				sentencia = conn.createStatement();
				rs = sentencia.executeQuery(SQL);
				while (rs.next()) {
					if (pass.equals(rs.getString("despacho")))
						sw=true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw;
	}
	public boolean esProfesor(String user, String pass){
		boolean sw = false;
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "SELECT * FROM profesores where nombre='"+user+"'";
			System.out.println(SQL);
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery(SQL);
			while (rs.next()) {
				if (pass.equals(rs.getString("despacho")))
					sw=true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw;
	}
	public boolean nuevoAlumno(Alumno alumno){
		boolean sw = true;
			try {
				Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				String SQL = "insert into alumnos (dni, nombre, apellidos, mes_nacimiento) values (?,?,?,?)";
				PreparedStatement preparedStmt = conn.prepareStatement(SQL);
				preparedStmt.setString(1, alumno.getDni());
				preparedStmt.setString(2, alumno.getNombre());
				preparedStmt.setString(3, alumno.getApellidos());
				preparedStmt.setInt(4, alumno.getMesNacimiento());
				conn.setAutoCommit(true);
				int numeroDeFilasAfectadas = preparedStmt.executeUpdate();
				conn.close();
				if (numeroDeFilasAfectadas!=1){
					sw=false;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sw=false;
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
				sw=false;
			}
		return sw;
	}
	public void borrarAlumno(int alumno){
		borrarAlumnoAsignaturas(alumno);
		borrarAlumnoNotas(alumno);
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
				conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
				String SQL = "DELETE FROM alumnos where id="+alumno;
				PreparedStatement preparedStmt = conn.prepareStatement(SQL);
				preparedStmt.executeUpdate();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error SQL: " + e.getMessage());
			}
	}
	public void borrarAlumnoNotas(int alumno){
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "DELETE FROM notas where alumno="+alumno;
			PreparedStatement preparedStmt = conn.prepareStatement(SQL);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
}
	public void borrarAlumnoAsignaturas(int alumno){
		try {
			Class.forName(Constantes.CONEXION_DRIVER);
			conn = DriverManager.getConnection(Constantes.CONEXION_URL, Constantes.CONEXION_USER, Constantes.CONEXION_PASS);
			String SQL = "DELETE FROM alumnos_has_asignaturas where alumno="+alumno;
			PreparedStatement preparedStmt = conn.prepareStatement(SQL);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error SQL: " + e.getMessage());
		}
}
}
