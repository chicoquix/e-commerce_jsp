package br.com.fiap.model;

public class Produto {

	private long idProduto;
	private String nome;
	private String descricao;
	private long idCategoria;

	public Produto(long idProduto, String nome, String descricao) {

		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
