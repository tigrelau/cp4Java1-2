package br.com.fiap.dao;

import br.com.fiap.model.Livro;
import java.util.List;

public interface LivroDAO {
    void salvar(Livro livro);
    Livro buscarPorId(int id);
    void atualizar(Livro livro);
    void deletar(int id);
    List<Livro> listarTodos();
}