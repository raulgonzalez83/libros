package edu.upc.eetac.dsa.roxana.libros.api;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

import edu.upc.eetac.dsa.roxana.libros.model.Libro;
import edu.upc.eetac.dsa.roxana.libros.model.LibroCollection;

@Path("/libros")
public class LibroResource {

	private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Produces(MediaType.LIBROS_API_LIBRO_COLLECTION)
	public LibroCollection getLibros() {
		LibroCollection libros = new LibroCollection();

		Connection conn = null;
		Statement stmt = null;
		String sql;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM libros";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Libro libro = new Libro();

				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setLengua(rs.getString("lengua"));
				libro.setEdicion(rs.getInt("edicion"));
				libro.setFecha_edicion(rs.getDate("fecha_edicion"));
				libro.setFecha_impresion(rs.getDate("fecha_impresion"));

				libros.add(libro);
			}
		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			}

			catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return libros;

	}

	@GET
	@Path("/{titulo}")
	@Produces(MediaType.LIBROS_API_LIBRO)
	public Libro getLibro(@PathParam("titulo") String titulo,
			@Context Request req) {

		Libro libro = new Libro();

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM libros WHERE titulo='" + titulo + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setLengua(rs.getString("lengua"));
				libro.setEdicion(rs.getInt("edicion"));
				libro.setFecha_edicion(rs.getDate("fecha_edicion"));
				libro.setFecha_impresion(rs.getDate("fecha_impresion"));

			}

			else
				throw new LibroNotFoundException();

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return libro;
	}

	@POST
	@Consumes(MediaType.LIBROS_API_LIBRO)
	@Produces(MediaType.LIBROS_API_LIBRO)
	public Libro createLibro(Libro libro) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {
			java.sql.Date fecha_edicion = new java.sql.Date(
					(libro.getFecha_edicion()).getTime());

			java.sql.Date fecha_impresion = new java.sql.Date(
					(libro.getFecha_edicion()).getTime());

			stmt = conn.createStatement();
			String update = null;
			update = "INSERT INTO libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) VALUES ('"
					+ libro.getTitulo()
					+ "','"
					+ libro.getAutor()
					+ "','"
					+ libro.getLengua()
					+ "', '"
					+ libro.getEdicion()
					+ "', '"
					+ fecha_edicion
					+ "','"
					+ fecha_impresion
					+ "', '"
					+ libro.getEditorial() + "')";
			stmt.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();

			try {
				String sql = "SELECT * FROM libros WHERE titulo='"
						+ libro.getTitulo() + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {

					libro.setTitulo(rs.getString("titulo"));
					libro.setAutor(rs.getString("autor"));
					libro.setEditorial(rs.getString("editorial"));
					libro.setLengua(rs.getString("lengua"));
					libro.setEdicion(rs.getInt("edicion"));
					libro.setFecha_edicion(rs.getDate("fecha_edicion"));
					libro.setFecha_impresion(rs.getDate("fecha_impresion"));

				}

				else
					throw new LibroNotFoundException();

			} catch (SQLException e) {
				throw new InternalServerException(e.getMessage());
			}

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return libro;
	}

	@DELETE
	@Path("/{titulo}")
	public void deleteLibro(@PathParam("titulo") String titulo) {
		// TODO Delete record in database stings identified by stingid.

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			String sql;

			sql = "DELETE FROM resenas WHERE titulolibro='" + titulo + "'";
			stmt.executeUpdate(sql);

			sql = "DELETE FROM libros WHERE titulo='" + titulo + "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
