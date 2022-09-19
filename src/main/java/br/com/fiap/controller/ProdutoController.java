package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;
import br.com.fiap.repository.ProdutoDAO;

public class ProdutoController {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoController() {
		Connection connection = new ConnectionFactory().conectar();
	}
		
	public void excluir(long idProduto){
		this.produtoDAO.deletar(idProduto);
	}

	public void inserir(Produto produto) {
		this.produtoDAO.inserir(produto);
	}
	
	public void inserirComCategoria(Produto produto) {
		this.produtoDAO.inserirComCategoria(produto);
	}
	
	public void alterar(String nome, String desc, long idProduto) {
		this.produtoDAO.alterar(nome, desc, idProduto);
	}
	
	public void buscarTodos() {
		this.produtoDAO.buscarTodos();
	}
	
	public void buscarComCategoria(Categoria ct) {
		this.produtoDAO.buscarComCategoria(ct);
	}
	

}
