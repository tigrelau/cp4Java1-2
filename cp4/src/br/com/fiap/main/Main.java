package br.com.fiap.main;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.factory.LivroDAOFactory;
import br.com.fiap.model.Livro;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gerenciamento de Livros ===");

        // Obtendo a instância do DAO através da Factory
        LivroDAO livroDAO = LivroDAOFactory.criarDAO();

        // 1. Testando CREATE
        System.out.println("\n[+] Salvando um novo livro...");
        Livro novoLivro = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        livroDAO.salvar(novoLivro);

        // 2. Testando READ (Listar Todos)
        System.out.println("\n[+] Listando todos os livros:");
        List<Livro> livros = livroDAO.listarTodos();
        for (Livro l : livros) {
            System.out.println(l);
        }

        if (!livros.isEmpty()) {
            int idParaTestar = livros.get(livros.size() - 1).getId(); // Pegando o último inserido

            // 3. Testando READ (Buscar por ID)
            System.out.println("\n[+] Buscando livro pelo ID " + idParaTestar + ":");
            Livro livroEncontrado = livroDAO.buscarPorId(idParaTestar);
            System.out.println(livroEncontrado);

            // 4. Testando UPDATE
            if (livroEncontrado != null) {
                System.out.println("\n[+] Atualizando ano de publicação do livro...");
                livroEncontrado.setAnoPublicacao(1938);
                livroDAO.atualizar(livroEncontrado);
                System.out.println("Livro atualizado: " + livroDAO.buscarPorId(idParaTestar));
            }

            // 5. Testando DELETE
            System.out.println("\n[+] Deletando livro com ID " + idParaTestar + "...");
            livroDAO.deletar(idParaTestar);
            System.out.println("Total de livros após exclusão: " + livroDAO.listarTodos().size());
        }
    }
}