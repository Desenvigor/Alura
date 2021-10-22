package br.com.alura.vo;

import java.time.LocalDate;

public class RelatoriaVendas {
	
	
	private String produtoNome;
	private Long valorTotal;
	private LocalDate dataUltimaVenda;
		
	public RelatoriaVendas(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.produtoNome = nomeProduto;
		this.valorTotal = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	public String getProdutoNome() {
		return produtoNome;
	}
	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}
	public Long getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}
	public void setDataUltimaVenda(LocalDate dataUltimaVenda) {
		this.dataUltimaVenda = dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatoriaVendas [produtoNome=" + produtoNome + ", valorTotal=" + valorTotal + ", dataUltimaVenda="
				+ dataUltimaVenda + "]";
	}
	
	
	
}
