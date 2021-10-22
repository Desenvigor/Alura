package br.com.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.model.Pedido;
import br.com.alura.vo.RelatoriaVendas;

public class PedidoDAO {
	
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		em.persist(pedido);
	}
	
	public List<RelatoriaVendas> relatorioVendas(){
		String jpql = "select new br.com.alura.vo.RelatoriaVendas(p.nome, SUM(item.qtd), MAX(pedido.data)) "
				+ "from Pedido pedido "
				+ "join pedido.itens item "
				+ "join item.produto p "
				+ "group by p.nome";
		
		return em.createQuery(jpql, RelatoriaVendas.class).getResultList();
	}
}
