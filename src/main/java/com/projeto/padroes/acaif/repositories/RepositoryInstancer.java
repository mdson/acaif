package com.projeto.padroes.acaif.repositories;

import java.util.List;

import com.projeto.padroes.acaif.models.Pedido;
import com.projeto.padroes.acaif.models.ProdutoAcai;

public class RepositoryInstancer {
	
	private static RepositoryInstancer myself = null;
	
	private GenericRepository<ProdutoAcai, Long> rProdutoAcai = null;
	private GenericRepository<Pedido, Long> rPedido = null;
	
	private RepositoryInstancer() {
		this.rProdutoAcai = new ProdutoAcaiRepository();
		this.rPedido = new PedidoRepository();
	}
	
	public static RepositoryInstancer getCurrentInstance() {
		
		if(myself == null){
            myself = new RepositoryInstancer();
        }
        
        return myself;
	}
	
	public void create(ProdutoAcai pA) {
		this.rProdutoAcai.create(pA);
	}
	
	public void update(ProdutoAcai pA) {
		this.rProdutoAcai.update(pA);
	}
	
	public ProdutoAcai readProdutoAcai(Long id) {
		return this.rProdutoAcai.read(id);
	}
	
	public void deleteProdutoAcai(Long id) {
		this.rProdutoAcai.delete(id);
	}
	
	public List<ProdutoAcai> readAllProdutoAcai(){
		return this.rProdutoAcai.readAll();
	}
	
	public void create(Pedido p) {
		this.rPedido.create(p);
	}
	
	public void update(Pedido p) {
		this.rPedido.update(p);
	}
	
	public Pedido readPedido(Long id) {
		return this.rPedido.read(id);
	}
	
	public void deletePedido(Long id) {
		this.rPedido.delete(id);
	}
	
	public List<Pedido> readAllPedido(){
		return this.rPedido.readAll();
	}
}
