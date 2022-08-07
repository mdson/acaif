package com.projeto.padroes.acaif.models;

public class CondimentoPorcaoDeMel extends GenericCondiment{
	
	GenericProduto produto;
	
	public CondimentoPorcaoDeMel(GenericProduto produto) {
		// TODO Auto-generated constructor stub
		this.produto = produto;
	}
	
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return produto.getDescricao() + ", Porção de Mel";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 0.75 + produto.preco();
	}
	
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
