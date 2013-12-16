package edu.upc.eetac.dsa.roxana.libros.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.roxana.libros.model.LibrosError;

public class LibroNotFoundException extends WebApplicationException {
	private final static String MESSAGE = "Book not found";

	public LibroNotFoundException() {
		super(Response
				.status(Response.Status.NOT_FOUND)
				.entity(new LibrosError(Response.Status.NOT_FOUND
						.getStatusCode(), MESSAGE))
				.type(MediaType.LIBROS_API_ERROR).build());
	}

}