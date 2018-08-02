package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Cliente;
import com.asesoftware.pruebapiloto.integracion.GestionClienteBD;

/**
 * Session Bean implementation class GestionClienteEJB
 */
@Stateless
@LocalBean
public class GestionClienteEJB {
	
	@EJB
	private GestionClienteBD gestionClienteBD;

    /**
     * Default constructor. 
     */
    public GestionClienteEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Cliente> consultarClientes(){
    	return gestionClienteBD.consultarClientes();
    }

}
