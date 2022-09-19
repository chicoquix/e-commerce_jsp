package br.com.fiap.model;

import java.util.ArrayList;

public class Categoria {
	
	private long idCategoria;
	private String nome;
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void adicionar(Produto produto) {
		this.listaProdutos.add(produto);

	}
}
