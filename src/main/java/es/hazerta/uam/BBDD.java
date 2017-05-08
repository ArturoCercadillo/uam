package es.hazerta.uam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Notification;

public class BBDD {
	Connection conn;

	public BBDD() {
		// TODO Auto-generated constructor stub
	}

	public List<Alumno> obtenerAlumnos(Alumno alumno) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.3.10:3306/universidad", "alumno", "alumno");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
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
}
