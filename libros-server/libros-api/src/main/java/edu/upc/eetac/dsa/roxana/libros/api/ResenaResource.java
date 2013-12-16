package edu.upc.eetac.dsa.roxana.libros.api;

import java.sql.Connection;
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

import edu.upc.eetac.dsa.roxana.libros.model.*;

@Path("/libros/{idlibro}/resenas")
public class ResenaResource {

	private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Produces(MediaType.LIBROS_API_RESENA_COLLECTION)
	public ResenaCollection getReseñas(@PathParam("idlibro") String idlibro) {
		ResenaCollection resenas = new ResenaCollection();

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
			sql = "SELECT * FROM resenas where idlibro='" + idlibro + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Resena resena = new Resena();
				resena.setIdlibro(rs.getInt("idlibro"));
				resena.setIdresena(rs.getInt("idresena"));
				resena.setName(rs.getString("name"));
				resena.setUsername(rs.getString("username"));
				resena.setTexto(rs.getString("texto"));
				resena.setFecha_creacion(rs.getDate("fecha_creacion"));

				resenas.add(resena);
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

		return resenas;

	}

	@DELETE
	@Path("/{idresena}")
	public void deleteResena(@PathParam("idlibro") String idlibro,
			@PathParam("idresena") String idresena) {
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

			sql = "DELETE FROM resenas WHERE idlibro='" + idlibro
					+ "' AND idresena='" + idresena + "'";
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
	
	/*	@POST
	@Consumes(MediaType.LIBROS_API_RESENA)
	@Produces(MediaType.LIBROS_API_RESENA)
	public Libro createResena(@PathParam("idlibro") String idlibro, Resena resena) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {
			
		

			stmt = conn.createStatement();
			String update = null;
			update = "INSERT INTO resenas (idlibro, name, texto) VALUES ('"
					+ resena.getIdlibro()
					+ "','"
					+ resena.getName()
					+ "','"
					+ resena.getTexto()+"')";
			stmt.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();

			try {

				String sql = "SELECT * FROM libros WHERE titulo='"
						+ libro.getTitulo() + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {

					libro.setIdlibro(rs.getInt("idlibro"));
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
	*/


}