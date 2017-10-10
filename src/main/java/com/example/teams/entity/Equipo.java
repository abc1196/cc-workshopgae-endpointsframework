package com.example.teams.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Equipo.getAll", query = "SELECT e FROM Equipo e"),
		@NamedQuery(name = "Equipo.findById", query = "SELECT t FROM Team t WHERE t.id = :id") })
public class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "idEquipo")
	private String idEquipo;

	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;

	@Basic(optional = false)
	@Column(name = "anoFundacion")
	private int anoFundacion;

	@Basic(optional = false)
	@Column(name = "estrellas")
	private int estrellas;

	public Equipo(String idEquipo, String nombre, int anoFundacion, int estrellas) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.anoFundacion = anoFundacion;
		this.estrellas = estrellas;
	}

	public Equipo(String idEquipo) {
		super();
		this.idEquipo = idEquipo;
	}

	public Equipo(String nombre, int anoFundacion, int estrellas) {
		super();
		this.nombre = nombre;
		this.anoFundacion = anoFundacion;
		this.estrellas = estrellas;
	}

	public String getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Equipo() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnoFundacion() {
		return anoFundacion;
	}

	public void setAnoFundacion(int anoFundacion) {
		this.anoFundacion = anoFundacion;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEquipo == null) ? 0 : idEquipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (idEquipo == null) {
			if (other.idEquipo != null)
				return false;
		} else if (!idEquipo.equals(other.idEquipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", anoFundacion=" + anoFundacion + ", estrellas="
				+ estrellas + "]";
	}

}
