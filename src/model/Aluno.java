package model;

import java.sql.Date;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private Date data_nascimento;

    public Aluno(){}

    public Aluno(String nome, String matricula, Date dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.data_nascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = this.data_nascimento;
    }
}
