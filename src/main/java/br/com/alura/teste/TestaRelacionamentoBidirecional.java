package br.com.alura.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ClienteDAO;
import br.com.alura.dao.PedidoDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.model.Categoria;
import br.com.alura.model.Cliente;
import br.com.alura.model.ItemPedido;
import br.com.alura.model.Pedido;
import br.com.alura.model.Produto;
import br.com.alura.util.JPAUtil;

public class TestaRelacionamentoBidirecional {
	public static void main(String[] args) {
		inserirNovoProduto();
		EntityManager em = JPAUtil.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		PedidoDAO pedidoDao = new PedidoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		Cliente cliente = new Cliente("Igor", "123456");
		Pedido pedido = new Pedido(cliente);
		Categoria categoria = new Categoria("BEBIDA");
		Produto produto = new Produto("Refrigerante", "Coca-cola", new BigDecimal(15), categoria);

		
		em.getTransaction().begin();
		Produto produto2 = produtoDao .pegaProdutoPorId(1l);
		produtoDao.cadastrar(produto);
		clienteDao.cadastrar(cliente);
		pedidoDao.cadastrar(pedido);
		categoriaDao.cadastrar(categoria);
		
		pedido.adicionaItem(new ItemPedido(2, produto, pedido));
		pedido.adicionaItem(new ItemPedido(1, produto2 , pedido));
		
		em.getTransaction().commit();
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