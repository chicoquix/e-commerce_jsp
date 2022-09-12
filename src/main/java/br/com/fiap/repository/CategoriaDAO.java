package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {

		this.connection = connection;

	}

	public List<Categoria> listarTodos() {
		List<Categoria> listaCate = new ArrayList<Categoria>();

		try {
			String sql = "SELECT * from categoria";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(rs.getLong(1));
					categoria.setNome(rs.getString(2));
					listaCate.add(categoria);

				}

			}
			return listaCate;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	public List<Categoria> listarComProduto() {

		Categoria ultima = null;
		List<Categoria> listaCate = new ArrayList<Categoria>();

		try {

			String sql = "SELECT C.idCategoria,C.NOME,P.idProduto,P.NOME,P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.idCategoria = P.idCategoria";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				ResultSet rs = pstm.executeQuery();

				while (rs.next()) {

					if (ultima == null || !ultima.getNome().equals(rs.getString(2))) {

						Categoria categoria = new Categoria();
						categoria.setIdCategoria(rs.getLong(1));
						categoria.setNome(rs.getString(2));
						listaCate.add(categoria);

						ultima = categoria;

					}
					Produto produto = new Produto(rs.getLong(3), rs.getString(4), rs.getString(5));
					ultima.adicionar(produto);

				}

			}
			return listaCate;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}
