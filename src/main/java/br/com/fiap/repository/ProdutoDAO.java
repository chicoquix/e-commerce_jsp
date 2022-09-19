package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {

		this.connection = connection;

	}

	public void inserir(Produto produto) {

		try {

			String sql = "INSERT INTO PRODUTO(NOME,DESCRICAO) VALUES(?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());

				pstm.execute();
				pstm.close();

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void inserirComCategoria(Produto produto) {
		try {

			String sql = "INSERT INTO PRODUTO(NOME,DESCRICAO,idCategoria) VALUES(?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());
				pstm.setLong(3, produto.getIdCategoria());

				pstm.execute();
				pstm.close();

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Produto> buscarTodos() {

		List<Produto> listaProd = new ArrayList<Produto>();

		try {
			String sql = "SELECT idProduto,NOME,DESCRICAO,idCategoria";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.execute();
				transformarEmProduto(listaProd, pstm);

			}
			return listaProd;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

	public List<Produto> buscarComCategoria(Categoria ct) {

		List<Produto> listaProd = new ArrayList<Produto>();

		try {

			String sql = "SELECT idProduto,NOME,DESCRICAO FROM PRODUTO WHERE idCategoria = ?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setLong(1, ct.getIdCategoria());
				pstm.execute();

				transformarEmProduto(listaProd, pstm);

			}
			return listaProd;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

	public void alterar(String nome, String desc, long idProduto) {
		try (PreparedStatement pstm = connection
				.prepareStatement("UPDATE PRODUTO P SET P.NOME = ?,P.DESCRICAO = ?, WHERE idProduto = ?")) {

			pstm.setString(1, nome);
			pstm.setString(2, desc);
			pstm.setLong(3, idProduto);
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deletar(long idProduto) {
		try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE idProduto ?")) {

			pstm.setLong(1, idProduto);
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void transformarEmProduto(List<Produto> produtos, PreparedStatement pstm) {

		try (ResultSet rs = pstm.getResultSet()) {

			while (rs.next()) {

				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
				produtos.add(produto);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
