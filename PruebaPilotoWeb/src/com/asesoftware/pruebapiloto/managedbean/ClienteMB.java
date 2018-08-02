package com.asesoftware.pruebapiloto.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.asesoftware.pruebapiloto.entidades.Cliente;
import com.asesoftware.pruebapiloto.negocio.GestionClienteEJB;

@ViewScoped
@ManagedBean
public class ClienteMB {
	
	private Cliente cliente;
	
	private List<Cliente> listaClientes;
	
	@EJB
	private GestionClienteEJB gestionClienteEJB;
	
	@PostConstruct
	public void inicializar() {
		this.cliente = new Cliente();
		this.consultarClientes();
	}
	
	public void consultarClientes() {
		this.listaClientes = gestionClienteEJB.consultarClientes();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	

}
