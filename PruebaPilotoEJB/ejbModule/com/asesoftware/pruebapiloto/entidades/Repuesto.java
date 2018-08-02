package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the REPUESTO database table.
 * 
 */
@Entity
@NamedQuery(name="Repuesto.findAll", query="SELECT r FROM Repuesto r")
public class Repuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long serial;

	@Column(name="NOM_REPUESTO")
	private String nomRepuesto;

	@Column(name="VALOR_REPUESTO")
	private BigDecimal valorRepuesto;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne
	@JoinColumn(name="SERIAL_PADRE")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Repuesto
	@OneToMany(mappedBy="repuesto")
	private List<Repuesto> repuestos;

	//bi-directional many-to-one association to ServicioRepuesto
	@OneToMany(mappedBy="repuesto")
	private List<ServicioRepuesto> servicioRepuestos;

	public Repuesto() {
	}

	public long getSerial() {
		return this.serial;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}

	public String getNomRepuesto() {
		return this.nomRepuesto;
	}

	public void setNomRepuesto(String nomRepuesto) {
		this.nomRepuesto = nomRepuesto;
	}

	public BigDecimal getValorRepuesto() {
		return this.valorRepuesto;
	}

	public void setValorRepuesto(BigDecimal valorRepuesto) {
		this.valorRepuesto = valorRepuesto;
	}

	public Repuesto getRepuesto() {
		return this.repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public List<Repuesto> getRepuestos() {
		return this.repuestos;
	}

	public void setRepuestos(List<Repuesto> repuestos) {
		this.repuestos = repuestos;
	}

	public Repuesto addRepuesto(Repuesto repuesto) {
		getRepuestos().add(repuesto);
		repuesto.setRepuesto(this);

		return repuesto;
	}

	public Repuesto removeRepuesto(Repuesto repuesto) {
		getRepuestos().remove(repuesto);
		repuesto.setRepuesto(null);

		return repuesto;
	}

	public List<ServicioRepuesto> getServicioRepuestos() {
		return this.servicioRepuestos;
	}

	public void setServicioRepuestos(List<ServicioRepuesto> servicioRepuestos) {
		this.servicioRepuestos = servicioRepuestos;
	}

	public ServicioRepuesto addServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().add(servicioRepuesto);
		servicioRepuesto.setRepuesto(this);

		return servicioRepuesto;
	}

	public ServicioRepuesto removeServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().remove(servicioRepuesto);
		servicioRepuesto.setRepuesto(null);

		return servicioRepuesto;
	}

}