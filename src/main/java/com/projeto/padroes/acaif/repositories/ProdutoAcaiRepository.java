package com.projeto.padroes.acaif.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projeto.padroes.acaif.models.ProdutoAcai;

public class ProdutoAcaiRepository implements GenericRepository<ProdutoAcai, Long>{

	public ProdutoAcaiRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(ProdutoAcai e) {
		// TODO Auto-generated method stub
		String sql = "insert into acaiProduto(nome, descricao, valorAtualProduto) values(?, ?, ?)";
		
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			pstm.setString(1, e.getNome());
			pstm.setString(2, e.getDescricao());
			pstm.setDouble(3, e.getValorAtualProduto());
			
			pstm.execute();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void update(ProdutoAcai e) {
		// TODO Auto-generated method stub
	}

	@Override
	public ProdutoAcai read(Long t) {
		// TODO Auto-generated method stub
		String sql = "select * from acaiProduto where id=?";
		
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			pstm.setLong(1, t);
			ResultSet result = pstm.executeQuery();
			
			if(result.next()) {
				ProdutoAcai acaizin = new ProdutoAcai();
				acaizin.setId(t);
				acaizin.setNomeConcreto(result.getString("nome"));
				acaizin.setValorAtualProduto(result.getDouble("valorAtualProduto"));
				return acaizin;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public void delete(Long t) {
		// TODO Auto-generated method stub
		String sql = "delete from acaiProduto where id = ?";
		
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setLong(1, t);
			pstm.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<ProdutoAcai> readAll() {
		// TODO Auto-generated method stub
        String sql = "select * from acaiProduto";
        List<ProdutoAcai> acaizin = new ArrayList<>();
        
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			ResultSet result = pstm.executeQuery();
			
			while(result.next()) {
				ProdutoAcai acai = new ProdutoAcai();
				acai.setId(result.getLong("id"));
				acai.setNomeConcreto(result.getString("nome"));
				acai.setValorAtualProduto(result.getDouble("valorAtualProduto"));
				acaizin.add(acai);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acaizin;

	}
	
}
