import dao.AlunoDAO;
import dao.LivroDAO;
import model.Aluno;
import model.Livro;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        LocalDate dataNasc = LocalDate.of(2010,11,21);
//        Date dataSQL = Date.valueOf(dataNasc);
//
//        AlunoDAO dao = new AlunoDAO();
//
//        //CREATE
////        Aluno aluno = new Aluno("João", "852123", dataSQL);
////        dao.create(aluno);
//
//        //testando Read
//        List<Aluno> alunoList = dao.read();
//        for(Aluno a : alunoList){
//            System.out.println("Nome: " + a.getNome() + " - matricula: " + a.getMatricula()
//            + " - data de nascimento: " + a.getData_nascimento());
//        }
//
//        System.out.println("-----------------------");
//
//        //UPDATE
////        Aluno aluno2 = new Aluno("Iranildo", "1234", dataSQL, 1);
////        dao.update(aluno2);
////
////        for(Aluno a : alunoList){
////            System.out.println("Nome: " + a.getNome() + " - matricula: " + a.getMatricula()
////                    + " - data de nascimento: " + a.getData_nascimento());
////        }
//
//        //DELETE teste
//        dao.delete(4);
//
//        for(Aluno a : alunoList){
//            System.out.println("Nome: " + a.getNome() + " - matricula: " + a.getMatricula()
//                    + " - data de nascimento: " + a.getData_nascimento());
//        }

        Livro livro = new Livro("Jurassic Park", "Michael Crichton", 1990, 20, 3);
        LivroDAO daoLivro = new LivroDAO();
        daoLivro.update(livro);

        List<Livro> livros = daoLivro.read();
        for(Livro l : livros){
            System.out.println("Título: " + l.getTitulo() + " \nAutor: "
                    + l.getAutor() + "\nano_publicação: " + l.getAno_publicacao() +
                    "\nQuantidade no estoque: " + l.getQuantidade_estoque());
            System.out.println("---------------------------------------------------");
        }

//        daoLivro.delete(2);

//        for(Livro l : livros){
//            System.out.println("Título: " + l.getTitulo() + " \nAutor: "
//                    + l.getAutor() + "\nano_publicação: " + l.getAno_publicacao() +
//                    "\nQuantidade no estoque: " + l.getQuantidade_estoque());
//            System.out.println("---------------------------------------------------");
//        }
    }
}
