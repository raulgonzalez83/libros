package edu.upc.eetac.dsa.roxana.libros.model;

public class Reseña {
	private int idres;
	private String titulolibro;
	private String username;
	private String name;
	private String texto;
	private java.util.Date fecha_creacion;

	public java.util.Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(java.util.Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getIdres() {
		return idres;
	}

	public void setIdres(int idres) {
		this.idres = idres;
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

	public String getTitulolibro() {
		return titulolibro;
	}

	public void setTitulolibro(String titulolibro) {
		this.titulolibro = titulolibro;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
