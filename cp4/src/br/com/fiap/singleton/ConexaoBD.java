package br.com.fiap.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instancia;
    private Connection conexao;

    private ConexaoBD() {
        try {
            // Força o Java a carregar o driver do Oracle na memória (Essencial para contornar o bug do classpath)
            Class.forName("oracle.jdbc.OracleDriver");

            // URL padronizada para o banco da FIAP
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            String usuario = "";
            String senha = "";
            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado pelo Java: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar no banco FIAP: " + e.getMessage());
        }
    }

    public static ConexaoBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}