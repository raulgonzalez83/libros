package edu.upc.eetac.dsa.roxana.libros.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.roxana.libros.api.links.LibrosAPILinkBuilder;
import edu.upc.eetac.dsa.roxana.libros.model.LibrosRootAPI;

@Path("/")
public class LibrosRootAPIResource {

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(MediaType.LIBROS_API_LINK_COLLECTION)
	public LibrosRootAPI getLinks() {
		LibrosRootAPI root = new LibrosRootAPI();

		root.add(LibrosAPILinkBuilder.buildURIRootAPI(uriInfo));

		root.add(LibrosAPILinkBuilder.buildTemplatedURIStings(uriInfo,
				"libros", true));

		root.add(LibrosAPILinkBuilder.buildTemplatedURIStings(uriInfo,
				"libros", false));

		root.add(LibrosAPILinkBuilder.buildURIUsers(uriInfo, "users"));

		root.add(LibrosAPILinkBuilder.buildTemplatedURIUsers(uriInfo, "users",
				true, true));

		root.add(LibrosAPILinkBuilder.buildTemplatedURIUsers(uriInfo, "users",
				true, false));

		root.add(LibrosAPILinkBuilder.buildTemplatedURIUsers(uriInfo, "users",
				false, true));

		root.add(LibrosAPILinkBuilder.buildURIStings(uriInfo, "create"));

		return root;
	}

}
