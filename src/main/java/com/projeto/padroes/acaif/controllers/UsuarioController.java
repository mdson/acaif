package com.projeto.padroes.acaif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.padroes.acaif.models.CondimentoCoberturaDeChocolate;
import com.projeto.padroes.acaif.models.CondimentoCoberturaDeMorango;
import com.projeto.padroes.acaif.models.CondimentoPorcaoDeBananas;
import com.projeto.padroes.acaif.models.CondimentoPorcaoDeLeiteEmPo;
import com.projeto.padroes.acaif.models.CondimentoPorcaoDeMel;
import com.projeto.padroes.acaif.models.GenericProduto;
import com.projeto.padroes.acaif.models.Pedido;
import com.projeto.padroes.acaif.models.ProdutoAcai;
import com.projeto.padroes.acaif.repositories.ProdutoAcaiRepository;
import com.projeto.padroes.acaif.repositories.RepositoryInstancer;

@Controller
@RequestMapping("/cliente")
public class UsuarioController {
	
	
	@RequestMapping(value="/realizarPedido/{id}", method=RequestMethod.GET)
	public String realizarPedidoGET(Model m, @PathVariable("id") Long id) {
		
		m.addAttribute("pedido", new Pedido());
		m.addAttribute("produtoAcai", RepositoryInstancer.getCurrentInstance().readProdutoAcai(id));
		
		boolean booleanCoberturaChocolate = false;
		m.addAttribute("booleanCoberturaChocolate", booleanCoberturaChocolate);
		
		boolean booleanCoberturaMorango = false;
		m.addAttribute("booleanCoberturaMorango", booleanCoberturaMorango);
		
		boolean booleanPorcaoBanana = false;
		m.addAttribute("booleanPorcaoBanana", booleanPorcaoBanana);
		
		boolean booleanPorcaoLeiteEmPo = false;
		m.addAttribute("booleanPorcaoLeiteEmPo", booleanPorcaoLeiteEmPo);
		
		boolean booleanPorcaoDeMel = false;
		m.addAttribute("booleanPorcaoDeMel", booleanPorcaoDeMel);
		
		return "realizarPedido";
	}
	
	@PostMapping(value="/realizarPedido/{id}")
	public String realizarPedidoPOST(Model m, Pedido p, @RequestParam(value = "checkboxCoberturaChocolate", required = false) String checkboxCoberturaChocolate,
			@RequestParam(value = "checkboxCoberturaMorango", required = false) String checkboxCoberturaMorango, @RequestParam(value = "checkboxPorcaoBananas", required = false) String checkboxPorcaoBananas,
			@RequestParam(value = "checkboxPorcaoLeiteEmPo", required = false) String checkboxPorcaoLeiteEmPo, @RequestParam(value = "checkboxPorcaoDeMel", required = false) String checkboxPorcaoDeMel, @PathVariable("id") Long id,
			ProdutoAcai produtoAcai) {
		
		Pedido pedido = new Pedido();
		GenericProduto produto = new ProdutoAcai();
		produtoAcai = RepositoryInstancer.getCurrentInstance().readProdutoAcai(id);
		produto = produtoAcai;
		
		if(checkboxCoberturaChocolate != null) {
			produto = new CondimentoCoberturaDeChocolate(produto);
		}
		if(checkboxCoberturaMorango != null) {
			produto = new CondimentoCoberturaDeMorango(produto);
		}
		if(checkboxPorcaoBananas != null) {
			produto = new CondimentoPorcaoDeBananas(produto);
		}
		if(checkboxPorcaoDeMel != null) {
			produto = new CondimentoPorcaoDeMel(produto);
		}
		if(checkboxPorcaoLeiteEmPo != null) {
			produto = new CondimentoPorcaoDeLeiteEmPo(produto);
		}
		
		pedido.setDescricao(produto.getDescricao());
		pedido.setPreco(produto.preco());
		RepositoryInstancer.getCurrentInstance().create(pedido);
		
		return "redirect:/cliente/listaDePedidos";
	}
	
	@RequestMapping("/listaDePedidos")
	public String ListaDePedidosGET(Model m) {
		
		m.addAttribute("listaDePedidos", RepositoryInstancer.getCurrentInstance().readAllPedido());
		return "listaDePedidos";
	}
	
	@RequestMapping("/cadastroAcai")
	public String cadastroAcaiGET(Model m) {
		
		m.addAttribute("produtoAcai", new ProdutoAcai());
		return "cadastroAcai";
	}
	
	@PostMapping("/cadastroAcai")
	public String cadastroAcaiPOST(Model m, ProdutoAcai produtoAcai) {
		
		RepositoryInstancer.getCurrentInstance().create(produtoAcai);
		return "redirect:/cliente/listaDeProdutos";
	}
	
	@RequestMapping("/listaDeProdutos")
	public String listaDeProdutos(Model m) {
		
		m.addAttribute("listaDeProdutos", RepositoryInstancer.getCurrentInstance().readAllProdutoAcai());
		return "produtos";
	}
	
}
