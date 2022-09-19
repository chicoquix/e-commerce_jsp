package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.repository.CategoriaDAO;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection connetion = new ConnectionFactory().conectar();
	}
	
	public void listarTodos() {
		this.categoriaDAO.listarTodos();
	}
	
	public void listarComProduto() {
		this.categoriaDAO.listarComProduto();
	}
	
}
