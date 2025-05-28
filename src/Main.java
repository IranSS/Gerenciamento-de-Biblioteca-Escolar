import dao.AlunoDAO;
import model.Aluno;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate dataNasc = LocalDate.of(2000,5,8);
        Date dataSQL = Date.valueOf(dataNasc);

        AlunoDAO dao = new AlunoDAO();
//        Aluno aluno = new Aluno("Jorgi", "123458", dataSQL);
//        dao.create(aluno);

        //testando Read
        List<Aluno> alunoList = dao.read();
        for(Aluno a : alunoList){
            System.out.println("Nome: " + a.getNome() + " - matricula: " + a.getMatricula()
            + " - data de nascimento: " + a.getData_nascimento());
        }
    }
}
