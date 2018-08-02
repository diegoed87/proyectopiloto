package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SERVICIO database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SERVICIO")
	private long idServicio;

	@Column(name="DESC_SERVICIO")
	private String descServicio;

	@Column(name="TIPO_SERVICIO")
	private String tipoServicio;

	@Column(name="VALOR_SERVICIO")
	private BigDecimal valorServicio;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="ID_CITA")
	private Cita cita;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="NUM_FACTURA")
	private Factura factura;

	//bi-directional many-to-one association to Mecanico
	@ManyToOne
	@JoinColumn(name="ID_MECANICO")
	private Mecanico mecanico;

	//bi-directional many-to-one association to ServicioRepuesto
	@OneToMany(mappedBy="servicio")
	private List<ServicioRepuesto> servicioRepuestos;

	public Servicio() {
	}

	public long getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescServicio() {
		return this.descServicio;
	}

	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public BigDecimal getValorServicio() {
		return this.valorServicio;
	}

	public void setValorServicio(BigDecimal valorServicio) {
		this.valorServicio = valorServicio;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Mecanico getMecanico() {
		return this.mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public List<ServicioRepuesto> getServicioRepuestos() {
		return this.servicioRepuestos;
	}

	public void setServicioRepuestos(List<ServicioRepuesto> servicioRepuestos) {
		this.servicioRepuestos = servicioRepuestos;
	}

	public ServicioRepuesto addServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().add(servicioRepuesto);
		servicioRepuesto.setServicio(this);

		return servicioRepuesto;
	}

	public ServicioRepuesto removeServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().remove(servicioRepuesto);
		servicioRepuesto.setServicio(null);

		return servicioRepuesto;
	}

}