package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENTE")
	private long idCliente;

	@Column(name="CEL_CLIENTE")
	private BigDecimal celCliente;

	@Column(name="NOM_CLIENTE")
	private String nomCliente;

	//bi-directional many-to-one association to ClienteVehiculo
	@OneToMany(mappedBy="cliente")
	private List<ClienteVehiculo> clienteVehiculos;

	public Cliente() {
	}

	public long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getCelCliente() {
		return this.celCliente;
	}

	public void setCelCliente(BigDecimal celCliente) {
		this.celCliente = celCliente;
	}

	public String getNomCliente() {
		return this.nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public List<ClienteVehiculo> getClienteVehiculos() {
		return this.clienteVehiculos;
	}

	public void setClienteVehiculos(List<ClienteVehiculo> clienteVehiculos) {
		this.clienteVehiculos = clienteVehiculos;
	}

	public ClienteVehiculo addClienteVehiculo(ClienteVehiculo clienteVehiculo) {
		getClienteVehiculos().add(clienteVehiculo);
		clienteVehiculo.setCliente(this);

		return clienteVehiculo;
	}

	public ClienteVehiculo removeClienteVehiculo(ClienteVehiculo clienteVehiculo) {
		getClienteVehiculos().remove(clienteVehiculo);
		clienteVehiculo.setCliente(null);

		return clienteVehiculo;
	}

}