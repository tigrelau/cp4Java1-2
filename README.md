# Checkpoint 4 (Parte 1) - DAO, Factory e Singleton Integrados

**Autora:** Laura Tigre

## Sobre o Projeto
Esta é a implementação da Parte 1 do Checkpoint 4 da disciplina de Domain Driven Design with Java. O projeto consiste em uma aplicação backend em Java que demonstra o uso combinado e integrado de três padrões de projeto arquiteturais e criacionais: **DAO (Data Access Object)**, **Factory** e **Singleton**. O acesso aos dados foi construído utilizando uma conexão JDBC simples.

## Entidade Escolhida
A entidade que guia este domínio é **Livro**. Ela possui 4 colunas mapeadas para o banco de dados relacional: `id` (chave primária auto-incremental), `titulo`, `autor` e `ano_publicacao`. Esta entidade representa o núcleo de um sistema simplificado de biblioteca ou livraria.

## Estrutura de Pacotes
O projeto foi organizado utilizando a convenção de domínio reverso para estruturação dos pacotes:
- `br.com.fiap.model`: Contém a classe de entidade `Livro.java` com seus atributos privados e métodos de encapsulamento (getters/setters).
- `br.com.fiap.singleton`: Contém a classe `ConexaoBD.java`, responsável por garantir uma única instância de conexão compartilhada por toda a aplicação.
- `br.com.fiap.dao`: Contém a interface `LivroDAO.java` (contrato) e a classe `LivroDAOImpl.java`, que realizam as quatro operações do CRUD (Create, Read, Update, Delete) no banco de dados.
- `br.com.fiap.factory`: Contém a classe `LivroDAOFactory.java`, que centraliza a criação do objeto DAO e injeta a dependência da conexão.
- `br.com.fiap.main`: Contém a classe `Main.java`, responsável por demonstrar o funcionamento integrado dos três padrões, executando testes práticos de todas as operações do CRUD.

## Como Executar
1. Certifique-se de incluir o driver de banco de dados (`ojdbc8.jar`) no *Build Path* da sua IDE (ex: IntelliJ IDEA em *Project Structure > Modules > Dependencies*).
2. Execute o comando SQL contido no arquivo `script.sql` (enviado junto com o código-fonte) no seu banco de dados Oracle para criar a tabela `livros`.
3. Acesse a classe `br.com.fiap.singleton.ConexaoBD` e atualize os parâmetros de conexão (`url`, `usuario` e `senha`) de acordo com as credenciais do seu banco de dados.
4. Execute a classe `Main.java`. A saída no console demonstrará o passo a passo das inserções, listagens, atualizações e exclusões dos registros, comprovando o funcionamento integrado do sistema.
