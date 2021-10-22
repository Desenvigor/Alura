package br.com.alura.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;
import br.com.alura.util.JPAUtil;

public class TesteInsercao {
	public static void main(String[] args) {	
		inserirNovoProduto();
		EntityManager em = JPAUtil.createEntityManager();
		CategoriaDAO dao = new CategoriaDAO(em);
		System.out.println(dao.findByName("CELULAR"));
		
	}

	private static void inserirNovoProduto() {
		Categoria categoria = new Categoria("CELULAR");
		Produto produto = new Produto("Xiaomi Redmi 2008", "Celular do ano passado", new BigDecimal(200), categoria);
		
		EntityManager em = JPAUtil.createEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		CategoriaDAO daoCategoria = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		daoCategoria.cadastrar(categoria);
		dao.cadastrar(produto);
		em.getTransaction().commit();
		
		em.close();
	}
}
