CREATE DATABASE biblioteca;

USE biblioteca

CREATE TABLE Alunos(
id_aluno INT auto_increment primary key,
nome_aluno VARCHAR(100) NOT NULL, 
matricula VARCHAR(20) UNIQUE, 
data_nascimento DATE
);

CREATE TABLE Livros(
id_livro int auto_increment primary	key, 
titulo varchar(150) NOT NULL,
autor VARCHAR(100),
ano_publicacao INT, 
quantidade_estoque INT DEFAULT 0
);

CREATE TABLE Emprestimos(
id_emprestimos INT auto_increment primary key, 
id_aluno int,
id_livro int,
data_emprestimo DATE DEfault(current_date), 
data_devolucao DATE, 
foreign key (id_aluno) references Alunos(id_aluno), 
foreign key(id_livro) references Livros(id_livro)
)

SELECT * FROM emprestimos
SELECT * FROM alunos
SELECT * FROM livros