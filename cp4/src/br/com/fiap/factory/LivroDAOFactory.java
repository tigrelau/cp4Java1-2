package br.com.fiap.factory;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.LivroDAOImpl;
import br.com.fiap.singleton.ConexaoBD;
import java.sql.Connection;

public class LivroDAOFactory {
    public static LivroDAO criarDAO() {
        Connection conn = ConexaoBD.getInstancia().getConexao();
        return new LivroDAOImpl(conn);
    }
}