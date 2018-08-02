package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FOTO database table.
 * 
 */
@Entity
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FOTO")
	private long idFoto;

	@Column(name="URL_FOTO")
	private String urlFoto;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="ID_CITA")
	private Cita cita;

	public Foto() {
	}

	public long getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}

	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}