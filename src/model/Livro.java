package model;

import java.sql.Date;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano_publicacao;
    private int quantidade_estoque;

    public Livro(int idAluno, int idLivro, Date dataEmprestimo, Date quantidadeEstoque){}

    public Livro(String titulo, String autor, int ano_publicacao, int quantidade_estoque){
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_estoque = quantidade_estoque;
    }
    public Livro(String titulo, String autor, int ano_publicacao, int quantidade_estoque, int id) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}
