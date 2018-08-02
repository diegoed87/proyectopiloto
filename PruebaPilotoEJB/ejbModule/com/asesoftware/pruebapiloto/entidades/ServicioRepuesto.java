package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SERVICIO_REPUESTO database table.
 * 
 */
@Entity
@Table(name="SERVICIO_REPUESTO")
@NamedQuery(name="ServicioRepuesto.findAll", query="SELECT s FROM ServicioRepuesto s")
public class ServicioRepuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SERV_REP")
	private long idServRep;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne
	@JoinColumn(name="SERIAL")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ID_SERVICIO")
	private Servicio servicio;

	public ServicioRepuesto() {
	}

	public long getIdServRep() {
		return this.idServRep;
	}

	public void setIdServRep(long idServRep) {
		this.idServRep = idServRep;
	}

	public Repuesto getRepuesto() {
		return this.repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}