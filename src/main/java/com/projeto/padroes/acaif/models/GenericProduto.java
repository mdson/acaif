package com.projeto.padroes.acaif.models;

public abstract class GenericProduto {
	
	String nome = "produto desconhecido";
	String descricao = "descricao desconhecida";
	
	public abstract double preco();

	public abstract String getNome();

	public String getDescricao() {
		return descricao;
	}
	
}
