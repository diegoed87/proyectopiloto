package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CLIENTE_VEHICULO database table.
 * 
 */
@Entity
@Table(name="CLIENTE_VEHICULO")
@NamedQuery(name="ClienteVehiculo.findAll", query="SELECT c FROM ClienteVehiculo c")
public class ClienteVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLI_VEH")
	private long idCliVeh;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="PLACA")
	private Vehiculo vehiculo;

	public ClienteVehiculo() {
	}

	public long getIdCliVeh() {
		return this.idCliVeh;
	}

	public void setIdCliVeh(long idCliVeh) {
		this.idCliVeh = idCliVeh;
	}

	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}