package com.projeto.padroes.acaif.models;

public class ProdutoAcai extends GenericProduto{

	private String novaDesc = this.descricao;
	private String nomeConcreto = this.nome;
	private Long id;
	private double valorProdutoSoma;
	private double valorAtualProduto = preco();

	public ProdutoAcai() {
		descricao = "Tigela de açaí com 500ml de puro açaí";
		nome = "Tigela de açaí";
	}
	
	@Override
	public double preco() {
		// TODO Auto-generated method stub
		return 7.5;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public double getValorProdutoSoma() {
		return valorProdutoSoma;
	}

	public String getNovaDesc() {
		return novaDesc;
	}

	public void setNovaDesc(String novaDesc) {
		this.novaDesc = novaDesc;
	}

	public String getNomeConcreto() {
		return nomeConcreto;
	}

	public void setNomeConcreto(String nomeConcreto) {
		this.nomeConcreto = nomeConcreto;
	}

	public double getValorAtualProduto() {
		return valorAtualProduto;
	}

	public void setValorAtualProduto(double valorAtualProduto) {
		this.valorAtualProduto = valorAtualProduto;
	}

	public void setValorProdutoSoma(double valorProdutoSoma) {
		this.valorProdutoSoma = valorProdutoSoma;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
	
	
	
}
