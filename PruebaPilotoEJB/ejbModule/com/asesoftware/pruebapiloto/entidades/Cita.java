package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CITA database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CITA")
	private long idCita;

	@Column(name="DESC_CITA")
	private String descCita;

	@Column(name="FEC_CITA")
	private Timestamp fecCita;

	private BigDecimal presupuesto;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="PLACA")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="cita")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="cita")
	private List<Servicio> servicios;

	public Cita() {
	}

	public long getIdCita() {
		return this.idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public String getDescCita() {
		return this.descCita;
	}

	public void setDescCita(String descCita) {
		this.descCita = descCita;
	}

	public Timestamp getFecCita() {
		return this.fecCita;
	}

	public void setFecCita(Timestamp fecCita) {
		this.fecCita = fecCita;
	}

	public BigDecimal getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setCita(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setCita(null);

		return foto;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setCita(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setCita(null);

		return servicio;
	}

}