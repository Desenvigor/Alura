package br.com.alura.teste;

import java.math.BigDecimal;
import java.util.List;

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
import br.com.alura.vo.RelatoriaVendas;

public class TestaRelacionamentoBidirecional {
	public static void main(String[] args) {
//		inserirNovoProduto();
		EntityManager em = JPAUtil.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		PedidoDAO pedidoDao = new PedidoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		Cliente cliente = new Cliente("Elayne", "6542231");
		Pedido pedido = new Pedido(cliente);
//		Categoria categoria = new Categoria("ELETRONICO");
		Produto produto = new Produto("Video Game", "Playstation 5", new BigDecimal(15), categoriaDao.findByName("CELULAR"));

		
		em.getTransaction().begin();
		Produto produto2 = produtoDao .pegaProdutoPorId(1l);
		produtoDao.cadastrar(produto);
		clienteDao.cadastrar(cliente);
		pedidoDao.cadastrar(pedido);
//		categoriaDao.cadastrar(categoria);
		
		pedido.adicionaItem(new ItemPedido(25, produto, pedido));
		pedido.adicionaItem(new ItemPedido(12, produto2 , pedido));
		
		em.getTransaction().commit();
		
		List<RelatoriaVendas> relatorio = pedidoDao.relatorioVendas();
		relatorio.forEach(System.out::println);
		
	}
	
	private static void inserirNovoProduto() {
		Categoria categoria = new Categoria("ROUPA");
		Produto produto = new Produto("Camiseta polo", "Calvin Klein", new BigDecimal(20), categoria);
		
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
