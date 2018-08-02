package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FACTURA database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_FACTURA")
	private long numFactura;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_FACTURA")
	private Date fecFactura;

	@Column(name="VALOR_BASE")
	private BigDecimal valorBase;

	@Column(name="VALOR_IVA")
	private BigDecimal valorIva;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="factura")
	private List<Servicio> servicios;

	public Factura() {
	}

	public long getNumFactura() {
		return this.numFactura;
	}

	public void setNumFactura(long numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFecFactura() {
		return this.fecFactura;
	}

	public void setFecFactura(Date fecFactura) {
		this.fecFactura = fecFactura;
	}

	public BigDecimal getValorBase() {
		return this.valorBase;
	}

	public void setValorBase(BigDecimal valorBase) {
		this.valorBase = valorBase;
	}

	public BigDecimal getValorIva() {
		return this.valorIva;
	}

	public void setValorIva(BigDecimal valorIva) {
		this.valorIva = valorIva;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setFactura(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setFactura(null);

		return servicio;
	}

}