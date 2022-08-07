package com.projeto.padroes.acaif.models;

public class ProdutoSorvete extends GenericProduto{
	
	public ProdutoSorvete() {
		descricao = "Pote de sorvete de 700ml de sorvete puro";
		nome = "Pote de sorvete";
	}
	
	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
