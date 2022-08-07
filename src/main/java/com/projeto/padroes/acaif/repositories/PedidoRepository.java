package com.projeto.padroes.acaif.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projeto.padroes.acaif.models.Pedido;

public class PedidoRepository implements GenericRepository<Pedido, Long>{

	public PedidoRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Pedido e) {
		// TODO Auto-generated method stub
		String sql = "insert into pedido(descricao, preco) values(?, ?)";
		
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, e.getDescricao());
			pstm.setDouble(2, e.getPreco());
			
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
	public void update(Pedido e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido read(Long t) {
		// TODO Auto-generated method stub
		String sql = "select * from pedido where id=?";
		
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setLong(1, t);
			ResultSet result = pstm.executeQuery();

			if(result.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(t);
				pedido.setDescricao(result.getString("descricao"));
				pedido.setPreco(result.getDouble("preco"));
				return pedido;
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
		String sql = "delete from pedido where id = ?";
		
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
	public List<Pedido> readAll() {
		// TODO Auto-generated method stub
        String sql = "select * from pedido";
        List<Pedido> pedidos = new ArrayList<>();
        
		try {
			PreparedStatement pstm = com.projeto.padroes.acaif.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			ResultSet result = pstm.executeQuery();
			
			while(result.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(result.getLong("id"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setPreco(result.getDouble("preco"));
				pedidos.add(pedido);
			}
			return pedidos;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		return null;
	}
	
}
