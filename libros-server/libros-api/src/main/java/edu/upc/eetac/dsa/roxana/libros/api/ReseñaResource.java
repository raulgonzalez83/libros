package edu.upc.eetac.dsa.roxana.libros.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.upc.eetac.dsa.roxana.libros.model.ReseñaCollection;

@Path("/reseñas")
public class ReseñaResource {

	private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Produces(MediaType.LIBROS_API_RESEÑA_COLLECTION)
	public ReseñaCollection getLibros() {
		ReseñaCollection reseñas = new ReseñaCollection();

		Connection conn = null;
		Statement stmt = null;
		String sql;

		return reseñas;

	}

}
