package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Estado;
import controllers.ConexaoController;

public class EstadoRepository {

	public EstadoRepository() {
	}

	public void inserir(Estado estado) {
		var sql = "INSERT INTO estado (nome, sigla)"+
				"VALUES ('" + estado.getNome() +"', '"+ estado.getSigla().toUpperCase() +"')";
        var conexaoController = new ConexaoController();
        var connection = conexaoController.conectaBD();
        conexaoController.executaSQL(sql, connection);
        conexaoController.desconectaBD(connection);
	}

	public List<Estado> listar() {
		var sql = "SELECT * FROM estado";
		try {
			var conexaoController = new ConexaoController();
            var connection = conexaoController.conectaBD();
			var resultSet = (ResultSet) conexaoController.executaSQL(sql, connection);
			var estados = new ArrayList<Estado>();

			while (resultSet.next()) {
				var estado = new Estado();
				estado.setId(resultSet.getLong("id"));
				estado.setNome(resultSet.getString("nome"));
				estado.setSigla(resultSet.getString("sigla"));
				estados.add(estado);
			}

			conexaoController.desconectaBD(connection);

			return estados;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
