package edu.upc.eetac.dsa.roxana.libros.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.roxana.libros.api.links.Link;

public class Resena {
	private int idresena;
	private int idlibro;
	private String username;
	private String name;
	private String texto;
	private Date fecha_creacion;

	private List<Link> links = new ArrayList<Link>();

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getIdresena() {
		return idresena;
	}

	public void setIdresena(int idres) {
		this.idresena = idres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public void add(Link link) {
		links.add(link);
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
