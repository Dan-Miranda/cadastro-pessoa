package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.PessoaJuridica;
import controllers.ConexaoController;

public class PessoaJuridicaRepository {
    public void inserir(PessoaJuridica pessoaJuridica) {
        var sql = "INSERT INTO pessoajuridica (nomeSocial, razaoSocial, email, telefone, rua, numero, " +
                        "complemento, bairro, cep, cidadeId, estadoId, cnpj, inscricaoEstadual, inscricaoMunicipal, fax, website) " +
                    "VALUES ("+
                        "'" + pessoaJuridica.getNomeSocial() + "', " +
                        "'" + pessoaJuridica.getRazaoSocial() + "', " +
                        "'" + pessoaJuridica.getEmail() + "', " +
                        "'" + pessoaJuridica.getTelefone() + "', " +
                        "'" + pessoaJuridica.getRua() + "', " +
                        "'" + pessoaJuridica.getNumero() + "', " +
                        "'" + pessoaJuridica.getComplemento() + "', " +
                        "'" + pessoaJuridica.getBairro() + "', " +
                        "'" + pessoaJuridica.getCep() + "', "+
                        "'" + pessoaJuridica.getCidadeId() + "', " +
                        "'" + pessoaJuridica.getEstadoId() + "', " +
                        "'" + pessoaJuridica.getCnpj() + "', " +
                        "'" + pessoaJuridica.getInscricaoEstadual() + "', " +
                        "'" + pessoaJuridica.getInscricaoMunicipal() + "', " +
                        "'" + pessoaJuridica.getFax() + "', " +
                        "'" + pessoaJuridica.getWebSite() + "'"
                    + ")";
        
        var conexaoController = new ConexaoController();
        var connection = conexaoController.conectaBD();

        conexaoController.executaSQL(sql, connection);
        conexaoController.desconectaBD(connection);
    }

    public List<PessoaJuridica> listar() {
        var sql = "SELECT * FROM pessoajuridica";

		try {
			var conexaoController = new ConexaoController();
            var connection = conexaoController.conectaBD();
			var resultSet = (ResultSet) conexaoController.executaSQL(sql, connection);
			var pessoasJuridicas = new ArrayList<PessoaJuridica>();

			while (resultSet.next()) {
				var pessoaJuridica = new PessoaJuridica();

				pessoaJuridica.setId(resultSet.getLong("id"));
				pessoaJuridica.setNomeSocial(resultSet.getString("nomeSocial"));
                pessoaJuridica.setRazaoSocial(resultSet.getString("razaoSocial"));
                pessoaJuridica.setEmail(resultSet.getString("email"));
                pessoaJuridica.setTelefone(resultSet.getString("telefone"));
                pessoaJuridica.setRua(resultSet.getString("rua"));
                pessoaJuridica.setNumero(resultSet.getString("numero"));
                pessoaJuridica.setComplemento(resultSet.getString("complemento"));
                pessoaJuridica.setBairro(resultSet.getString("bairro"));
                pessoaJuridica.setCep(resultSet.getString("cep"));
                pessoaJuridica.setCidadeId(resultSet.getLong("cidadeId"));
                pessoaJuridica.setEstadoId(resultSet.getLong("estadoId"));
                pessoaJuridica.setCnpj(resultSet.getCnpj("cnpj"));
                pessoaJuridica.setInscricaoEstadual(resultSet.getInscricaoEstadual("inscricaoEstadual"));
                pessoaJuridica.setInscricaoMunicipal(resultSet.getInscricaoMunicipal("inscricaoMunicipal"));
                pessoaJuridica.setFax(resultSet.getFax("fax"));
                pessoaJuridica.setWebSite(resultSet.getWebSite("website"));

				pessoasJuridicas.add(pessoaJuridica);
			}

			conexaoController.desconectaBD(connection);
			
            return pessoasFisicas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
