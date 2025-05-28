import dao.EmprestimoDAO;
import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        LocalDate data = LocalDate.of(2025,05,29);
        Date dataDevolucao = Date.valueOf(data);

        Aluno aluno = new Aluno();

        Emprestimo emprestimo = new Emprestimo(1, 1, dataDevolucao);

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

//        emprestimoDAO.registrarEmprestimo(emprestimo);

        List<Emprestimo> emprestimos = emprestimoDAO.relatorioEmprestimos();

        for(Emprestimo e : emprestimos){
            System.out.println("Id emprestimo: " + e.getId() + "\nId aluno: " + emprestimo.getAluno() + " \nId livro: " + e.getId_livro()
            + "\ndata do emprestimo: " + e.getDataEmprestimo() + "\ndata da devolução: " + e.getDataDevolucao());
        }
    }
}
