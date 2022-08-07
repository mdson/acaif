package com.projeto.padroes.acaif.models;

public class CondimentoCoberturaDeChocolate extends GenericCondiment{
	
	GenericProduto produto;
	
	public CondimentoCoberturaDeChocolate(GenericProduto produto) {
		// TODO Auto-generated constructor stub
		this.produto = produto;
	}
	
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return produto.getDescricao() + ", Cobertura de Chocolate";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 0.40 + produto.preco();
	}
	
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
