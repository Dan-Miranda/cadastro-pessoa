package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.PessoaFisica;
import controllers.ConexaoController;

public class PessoaFisicaRepository {
    public void inserir(PessoaFisica pessoaFisica) {
        var sql = "INSERT INTO pessoafisica (nomeSocial, razaoSocial, email, telefone, rua, numero, " +
                        "complemento, bairro, cep, cidadeId, estadoId, cpf, rg, dataNascimento) " +
                    "VALUES ("+
                        "'" + pessoaFisica.getNomeSocial() + "', " +
                        "'" + pessoaFisica.getRazaoSocial() + "', " +
                        "'" + pessoaFisica.getEmail() + "', " +
                        "'" + pessoaFisica.getTelefone() + "', " +
                        "'" + pessoaFisica.getRua() + "', " +
                        "'" + pessoaFisica.getNumero() + "', " +
                        "'" + pessoaFisica.getComplemento() + "', " +
                        "'" + pessoaFisica.getBairro() + "', " +
                        "'" + pessoaFisica.getCep() + "', "+
                        "'" + pessoaFisica.getCidadeId() + "', " +
                        "'" + pessoaFisica.getEstadoId() + "', " +
                        "'" + pessoaFisica.getCpf() + "', " +
                        "'" + pessoaFisica.getRg() + "', " +
                        "'" + pessoaFisica.getDataNascimento() + "'"
                    + ")";
        var conexaoController = new ConexaoController();
        var connection = conexaoController.conectaBD();
        conexaoController.executaSQL(sql, connection);
        conexaoController.desconectaBD(connection);
    }

    public List<PessoaFisica> listar() {
        var sql = "SELECT * FROM pessoafisica";
		try {
			var conexaoController = new ConexaoController();
            var connection = conexaoController.conectaBD();
			var resultSet = (ResultSet) conexaoController.executaSQL(sql, connection);
			var pessoasFisicas = new ArrayList<PessoaFisica>();

			while (resultSet.next()) {
				var pessoaFisica = new PessoaFisica();

				pessoaFisica.setId(resultSet.getLong("id"));
				pessoaFisica.setNomeSocial(resultSet.getString("nomeSocial"));
                pessoaFisica.setRazaoSocial(resultSet.getString("razaoSocial"));
                pessoaFisica.setEmail(resultSet.getString("email"));
                pessoaFisica.setTelefone(resultSet.getString("telefone"));
                pessoaFisica.setRua(resultSet.getString("rua"));
                pessoaFisica.setNumero(resultSet.getString("numero"));
                pessoaFisica.setComplemento(resultSet.getString("complemento"));
                pessoaFisica.setBairro(resultSet.getString("bairro"));
                pessoaFisica.setCep(resultSet.getString("cep"));
                pessoaFisica.setCidadeId(resultSet.getLong("cidadeId"));
                pessoaFisica.setEstadoId(resultSet.getLong("estadoId"));
                pessoaFisica.setCpf(resultSet.getString("cpf"));
                pessoaFisica.setRg(resultSet.getString("rg"));
                pessoaFisica.setDataNascimento(resultSet.getString("dataNascimento"));

				pessoasFisicas.add(pessoaFisica);
			}

			conexaoController.desconectaBD(connection);
            
			return pessoasFisicas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
