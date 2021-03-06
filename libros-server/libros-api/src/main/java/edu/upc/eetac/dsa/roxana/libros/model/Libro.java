package edu.upc.eetac.dsa.roxana.libros.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.roxana.libros.api.links.Link;

public class Libro {

	private String titulo;
	private String autor;
	private String lengua;
	private int edicion;
	private Date fecha_edicion;
	private Date fecha_impresion;
	private String editorial;
	private int idlibro;
	private List<Link> links = new ArrayList<Link>();

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEdicion() {
		return edicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLengua() {
		return lengua;
	}

	public void setLengua(String lengua) {
		this.lengua = lengua;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFecha_edicion() {
		return fecha_edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}

	public Date getFecha_impresion() {
		return fecha_impresion;
	}

	public void setFecha_impresion(Date fecha_impresion) {
		this.fecha_impresion = fecha_impresion;

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
