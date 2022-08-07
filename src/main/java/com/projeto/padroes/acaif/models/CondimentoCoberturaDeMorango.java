package com.projeto.padroes.acaif.models;

public class CondimentoCoberturaDeMorango extends GenericCondiment{
	
	GenericProduto produto;
	
	public CondimentoCoberturaDeMorango(GenericProduto produto) {
		// TODO Auto-generated constructor stub
		this.produto = produto;
	}
	
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return produto.getDescricao() + ", Cobertura de Morango";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 0.35 + produto.preco();
	}
	
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
