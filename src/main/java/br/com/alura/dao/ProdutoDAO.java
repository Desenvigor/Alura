package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.model.Produto;

public class ProdutoDAO {
		
	EntityManager em;
	
	public ProdutoDAO(EntityManager em){
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		em.persist(produto);
	}
}
