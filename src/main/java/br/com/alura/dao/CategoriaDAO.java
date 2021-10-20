package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.model.Categoria;

public class CategoriaDAO {

	EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}

	public Categoria findByName(String nome) {
		String jpql = "select c from Categoria c where c.nome = ?1";
		return em.createQuery(jpql, Categoria.class).setParameter(1, nome).getSingleResult();
	}
}
