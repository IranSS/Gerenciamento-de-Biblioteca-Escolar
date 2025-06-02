
# Sistema de Gerenciamento de Biblioteca em Java

Este projeto é um sistema simples de gerenciamento de biblioteca desenvolvido em Java, utilizando JDBC para interação com um banco de dados MySQL. A aplicação oferece funcionalidades básicas para gerenciar alunos, livros e empréstimos, tudo através de uma interface em console.

## Funcionalidades

O sistema permite realizar as seguintes operações:

* **Gerenciamento de Alunos:**
    * Cadastrar novos alunos.
    * Listar todos os alunos cadastrados com suas informações.
    * Atualizar dados de alunos existentes.
    * Deletar registros de alunos.

* **Gerenciamento de Livros:**
    * Adicionar novos livros ao acervo.
    * Listar todos os livros disponíveis com seus detalhes e quantidade em estoque.
    * Atualizar a quantidade em estoque de um livro.
    * Deletar livros do acervo.

* **Gerenciamento de Empréstimos:**
    * Registrar novos empréstimos de livros para alunos, com atualização automática do estoque de livros.
    * Gerar um relatório de todos os empréstimos registrados.
    * Atualizar informações de um registro de empréstimo (ex: data de devolução).
    * Deletar registros de empréstimos.

## Estrutura do Projeto

O projeto é organizado em pacotes para melhor modularidade e separação de responsabilidades:

* **`util`**: Contém a classe `DataBaseConnection`, responsável por gerenciar a conexão com o banco de dados.
* **`model`**: Contém as classes que representam as entidades do sistema (Aluno, Livro, Emprestimo), atuando como modelos de dados.
* **`dao`**: Contém as classes Data Access Object (DAO) para cada entidade (`AlunoDAO`, `LivroDAO`, `EmprestimoDAO`), que encapsulam a lógica de acesso e manipulação dos dados no banco de dados.
* **`Main`**: A classe principal que serve como ponto de entrada da aplicação, gerenciando a interface de usuário e orquestrando as chamadas aos DAOs.

## Tecnologias Utilizadas

* **Java**: Linguagem de programação principal.
* **JDBC (Java Database Connectivity)**: API para conexão e execução de comandos SQL em bancos de dados.
* **MySQL**: Sistema de gerenciamento de banco de dados relacional.

## Como Rodar o Projeto

1.  **Configurar o Banco de Dados:**
    * Crie um banco de dados MySQL com o nome `biblioteca`.
    * Crie as tabelas necessárias (`alunos`, `livros`, `emprestimos`) com as colunas correspondentes aos atributos das classes `Aluno`, `Livro` e `Emprestimo`. Já existe um script que pode ser utlizado na criação na pasta `sql`.
    * Atualize as credenciais de conexão no arquivo `util/DataBaseConnection.java` (`URL`, `USER`, `PASSWORD`) para corresponder às suas configurações do MySQL.

2.  **Adicionar o Driver JDBC do MySQL:**
    * Ative o conector na pasta `util`JDBC para MySQL (MySQL Connector/J).
    * Adicione o arquivo `.jar` do conector ao `classpath` do seu projeto. Se estiver usando um IDE (IntelliJ IDEA, Eclipse), você pode adicioná-lo como uma dependência de biblioteca.

3.  **Compilar e Executar:***
    * Garanta que sua máquina esteja utilizando o Java 17.
    * Compile o projeto Java.
    * Execute a classe `Main`. O sistema será iniciado no terminal e você poderá interagir com o menu de opções.

---
## Integrantes do trabalho
Nome: Francisco Iranildo de Sousa Avelino - 2415577

Nome: 