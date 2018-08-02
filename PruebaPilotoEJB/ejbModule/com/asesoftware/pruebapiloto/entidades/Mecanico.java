package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MECANICO database table.
 * 
 */
@Entity
@NamedQuery(name="Mecanico.findAll", query="SELECT m FROM Mecanico m")
public class Mecanico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MECANICO")
	private long idMecanico;

	@Column(name="ESTADO_MECANICO")
	private String estadoMecanico;

	@Column(name="NOM_MECANICO")
	private String nomMecanico;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="mecanico")
	private List<Servicio> servicios;

	public Mecanico() {
	}

	public long getIdMecanico() {
		return this.idMecanico;
	}

	public void setIdMecanico(long idMecanico) {
		this.idMecanico = idMecanico;
	}

	public String getEstadoMecanico() {
		return this.estadoMecanico;
	}

	public void setEstadoMecanico(String estadoMecanico) {
		this.estadoMecanico = estadoMecanico;
	}

	public String getNomMecanico() {
		return this.nomMecanico;
	}

	public void setNomMecanico(String nomMecanico) {
		this.nomMecanico = nomMecanico;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setMecanico(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setMecanico(null);

		return servicio;
	}

}