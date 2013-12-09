package edu.upc.eetac.dsa.roxana.libros.model;

import java.util.ArrayList;
import java.util.List;

public class ReseñaCollection {

	private List<Reseña> reseñas = new ArrayList<Reseña>();

	public void add(Reseña reseña) {
		reseñas.add(reseña);
	}

	public List<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(List<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

}
