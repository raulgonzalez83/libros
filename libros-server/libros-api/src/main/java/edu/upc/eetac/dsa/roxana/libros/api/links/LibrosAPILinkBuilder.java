package edu.upc.eetac.dsa.roxana.libros.api.links;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.roxana.libros.api.LibroResource;
import edu.upc.eetac.dsa.roxana.libros.api.LibrosRootAPIResource;
import edu.upc.eetac.dsa.roxana.libros.api.MediaType;
import edu.upc.eetac.dsa.roxana.libros.api.UserResource;
import edu.upc.eetac.dsa.roxana.libros.model.Libro;

public class LibrosAPILinkBuilder {

	public final static Link buildURIRootAPI(UriInfo uriInfo) {

		URI uriRoot = uriInfo.getBaseUriBuilder()
				.path(LibrosRootAPIResource.class).build();
		Link link = new Link();
		link.setUri(uriRoot.toString());
		link.setRel("self bookmark");
		link.setTitle("Libros API");
		link.setType(MediaType.LIBROS_API_LINK_COLLECTION);

		return link;
	}

	public static final Link buildURILibros(UriInfo uriInfo, String rel) {
		return buildURILibros(uriInfo, null, null, rel);

	}

	public static final Link buildURILibros(UriInfo uriInfo, String titulo,
			String autor, String rel) {
		URI uriLibros = null;
		if (autor == null && titulo == null)
			uriLibros = uriInfo.getBaseUriBuilder().path(LibroResource.class)
					.build();
		else {
			if (autor == null && titulo != null)
				uriLibros = uriInfo.getBaseUriBuilder()
						.path(LibroResource.class).path("/search")
						.queryParam("titulo", titulo).build();

			else if (titulo == null && autor != null)
				uriLibros = uriInfo.getBaseUriBuilder()
						.path(LibroResource.class).path("/search")
						.queryParam("autor", autor).build();

			else if (titulo != null && autor != null)
				uriLibros = uriInfo.getBaseUriBuilder()
						.path(LibroResource.class).path("/search")
						.queryParam("titulo", titulo)
						.queryParam("autor", autor).build();
		}

		Link self = new Link();
		self.setUri(uriLibros.toString());
		self.setRel("libros");
		self.setTitle("Libros collection");
		self.setType(MediaType.LIBROS_API_LIBRO_COLLECTION);

		return self;
	}

	public static final Link buildTemplatedURILibros(UriInfo uriInfo,
			boolean titulo, boolean autor, String rel) {
		URI uriLibros = null;

		if (titulo == true && autor == false) {
			uriLibros = uriInfo.getBaseUriBuilder().path(LibroResource.class)
					.path("/search").queryParam("titulo", "{titulo}").build();

		} else if (titulo == false && autor == true) {
			uriLibros = uriInfo.getBaseUriBuilder().path(LibroResource.class)
					.path("/search").queryParam("autor", "{autor}").build();

		} else if (autor == true && titulo == true) {
			uriLibros = uriInfo.getBaseUriBuilder().path(LibroResource.class)
					.path("/search").queryParam("titulo", "{titulo}")
					.queryParam("autor", "{autor}").build();

		}

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriLibros));
		link.setRel(rel);
		link.setTitle("Stings collection resource");
		link.setType(MediaType.LIBROS_API_LIBRO_COLLECTION);

		return link;
	}

	public final static Link buildURILibro(UriInfo uriInfo, Libro libro) {
		URI stingURI = uriInfo.getBaseUriBuilder().path(LibroResource.class)
				.build();
		Link link = new Link();
		link.setUri(stingURI.toString());
		link.setRel("self");
		link.setTitle("Sting " + libro.getIdlibro());
		link.setType(MediaType.LIBROS_API_LIBRO);

		return link;
	}

	public final static Link buildURILibroId(UriInfo uriInfo, String idlibro,
			String rel) {
		URI libroURI = uriInfo.getBaseUriBuilder().path(LibroResource.class)
				.path(LibroResource.class, "getLibro").build(idlibro);
		Link link = new Link();
		link.setUri(libroURI.toString());
		link.setRel("self");
		link.setTitle("Libro " + idlibro);
		link.setType(MediaType.LIBROS_API_LIBRO);

		return link;
	}

	public static final Link buildURIUsers(UriInfo uriInfo, String rel) {
		URI uriUsers;

		uriUsers = uriInfo.getBaseUriBuilder().path(UserResource.class).build();

		Link self = new Link();
		self.setUri(uriUsers.toString());
		self.setRel(rel);
		self.setTitle("Users collection");
		self.setType(MediaType.LIBROS_API_USER_COLLECTION);

		return self;
	}

	public final static Link buildURIUserName(UriInfo uriInfo, String username,
			String rel) {
		URI userURI = uriInfo.getBaseUriBuilder().path(UserResource.class)
				.path(UserResource.class, "getUser").build(username);
		Link link = new Link();
		link.setUri(userURI.toString());
		link.setRel("self");
		link.setTitle("User " + username);
		link.setType(MediaType.LIBROS_API_USER);

		return link;
	}

}
