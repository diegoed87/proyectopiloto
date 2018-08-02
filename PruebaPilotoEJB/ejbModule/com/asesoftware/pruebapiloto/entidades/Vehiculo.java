package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the VEHICULO database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String placa;

	private BigDecimal cilindraje;

	private String color;

	private String marca;

	private String modelo;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="vehiculo")
	private List<Cita> citas;

	//bi-directional many-to-one association to ClienteVehiculo
	@OneToMany(mappedBy="vehiculo")
	private List<ClienteVehiculo> clienteVehiculos;

	public Vehiculo() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(BigDecimal cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setVehiculo(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setVehiculo(null);

		return cita;
	}

	public List<ClienteVehiculo> getClienteVehiculos() {
		return this.clienteVehiculos;
	}

	public void setClienteVehiculos(List<ClienteVehiculo> clienteVehiculos) {
		this.clienteVehiculos = clienteVehiculos;
	}

	public ClienteVehiculo addClienteVehiculo(ClienteVehiculo clienteVehiculo) {
		getClienteVehiculos().add(clienteVehiculo);
		clienteVehiculo.setVehiculo(this);

		return clienteVehiculo;
	}

	public ClienteVehiculo removeClienteVehiculo(ClienteVehiculo clienteVehiculo) {
		getClienteVehiculos().remove(clienteVehiculo);
		clienteVehiculo.setVehiculo(null);

		return clienteVehiculo;
	}

}