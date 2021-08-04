package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoController {
	public ConexaoController() {}

	public Connection conectaBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/atividade7",
                "root",
                "");
            return con;

        } catch (Exception e) {
            System.err.println("Erro na conexão com o banco de dados");
            e.printStackTrace();
            return null;
        }
	}

    public void desconectaBD(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println("Erro ao desconectar banco de dados");
            e.printStackTrace();
        }
    }

    public Object executaSQL(String instrucao, Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            var primeiraPalavraInstrucao = instrucao.split(" ")[0].toLowerCase();
            ResultSet resultSet = null;
            var validarInstrucao = primeiraPalavraInstrucao.equals("insert")
                                || primeiraPalavraInstrucao.equals("update")
                                || primeiraPalavraInstrucao.equals("delete");

            if (validarInstrucao) {
                var executouComSucesso = stmt.execute(instrucao);
                stmt.closeOnCompletion();
                return executouComSucesso;
            }

            resultSet = stmt.executeQuery(instrucao);
            stmt.closeOnCompletion();
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
