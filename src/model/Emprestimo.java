package model;

import java.sql.Date;

public class Emprestimo {
    private int id;
    private int id_aluno;
    private int id_livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(){}

    public Emprestimo(int id, int id_aluno, int id_livro, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.id_aluno = id_aluno;
        this.id_livro = id_livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(int id_aluno, int id_livro,Date dataEmprestimo, Date dataDevolucao) {
        this.id_aluno = id_aluno;
        this.id_livro = id_livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
    public Emprestimo(int id_aluno, int id_livro, Date dataDevolucao) {
        this.id_aluno = id_aluno;
        this.id_livro = id_livro;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAluno() {
        return id_aluno;
    }

    public void setAluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
