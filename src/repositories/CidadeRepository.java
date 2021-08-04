package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Cidade;
import controllers.ConexaoController;

public class CidadeRepository {

	public CidadeRepository() {
	}

	public void inserir(Cidade cidade) {
		var sql = "INSERT INTO cidade (nome) " +
				"VALUES ('" + cidade.getNome() + "')";

        var conexaoController = new ConexaoController();
        var connection = conexaoController.conectaBD();
        conexaoController.executaSQL(sql, connection);
        conexaoController.desconectaBD(connection);
	}

	public List<Cidade> listar() {
		var sql = "SELECT * FROM cidade";
		try {
			var conexaoController = new ConexaoController();
            var connection = conexaoController.conectaBD();
			var resultSet = (ResultSet) conexaoController.executaSQL(sql, connection);
			var cidades = new ArrayList<Cidade>();

			while (resultSet.next()) {
				var cidade = new Cidade();
				cidade.setId(resultSet.getLong("id"));
				cidade.setNome(resultSet.getString("nome"));
				cidades.add(cidade);
			}
			conexaoController.desconectaBD(connection);
			return cidades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
