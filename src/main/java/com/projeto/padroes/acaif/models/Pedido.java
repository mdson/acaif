package com.projeto.padroes.acaif.models;

public class Pedido {
	
	private Long id;
	private String descricao;
	private double preco;
	private ProdutoAcai acaiProduto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public ProdutoAcai getAcaiProduto() {
		return acaiProduto;
	}
	public void setAcaiProduto(ProdutoAcai acaiProduto) {
		this.acaiProduto = acaiProduto;
	}
	
}
