package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.model.Pedido;

public class PedidoDAO {
	
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		em.persist(pedido);
	}
}
