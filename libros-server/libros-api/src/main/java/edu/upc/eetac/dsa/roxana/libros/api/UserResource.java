package edu.upc.eetac.dsa.roxana.libros.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import edu.upc.eetac.dsa.roxana.libros.model.User;
import edu.upc.eetac.dsa.roxana.libros.model.UserCollection;

@Path("/users")
public class UserResource {
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Produces(MediaType.LIBROS_API_USER_COLLECTION)
	public UserCollection getUsers() {
		UserCollection users = new UserCollection();

		// TODO: Retrieve all stings stored in the database, instantiate one
		// Sting for each one and store them in the StingCollection.
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
			sql = "SELECT * FROM users";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));

				users.add(user);
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

		return users;
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.LIBROS_API_USER)
	public User getUser(@PathParam("username") String username) {
		User user = new User();

		// TODO: Retrieve all stings stored in the database, instantiate one
		// Sting for each one and store them in the StingCollection.
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
			sql = "SELECT * FROM users WHERE username= '" + username + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user.setUsername(rs.getString("username"));

				user.setEmail(rs.getString("email"));

			}

			else
				throw new UserNotFoundException();
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

		return user;
	}

}
