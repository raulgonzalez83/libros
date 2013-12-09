package edu.upc.eetac.dsa.roxana.libros.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.roxana.libros.model.LibrosError;

public class ServiceUnavailableException extends WebApplicationException {
	public ServiceUnavailableException(String message) {
		super(Response
				.status(Response.Status.SERVICE_UNAVAILABLE)
				.entity(new LibrosError(Response.Status.SERVICE_UNAVAILABLE
						.getStatusCode(), message))
				.type(MediaType.LIBROS_API_ERROR).build());
	}
}