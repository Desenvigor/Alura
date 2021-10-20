package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.model.Cliente;

public class ClienteDAO {
	private EntityManager em;
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		em.persist(cliente);
	}
	
}
