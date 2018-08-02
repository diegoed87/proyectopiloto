package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.Cliente;

/**
 * Session Bean implementation class GestionCliente
 */
@Stateless
@LocalBean
public class GestionClienteBD {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public GestionClienteBD() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Cliente> consultarClientes(){
    	Query queryConsultaClientes = em.createQuery("select c from Cliente c");
    	return queryConsultaClientes.getResultList();
    }

}
