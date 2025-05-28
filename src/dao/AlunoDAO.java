package dao;

import model.Aluno;
import util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    DataBaseConnection dataBaseConnection;

    //CREATE
    public void create(Aluno aluno){

        //comando SQL para rodar
        String sql = "INSERT INTO alunos(nome_aluno, matricula, data_nascimento) VALUES (?,?,?)";

        //Fazer TryCatch para tratar o error do SQL
        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getMatricula());
            preparedStatement.setDate(3, aluno.getData_nascimento());
            preparedStatement.executeUpdate();

            System.out.println("Aluno inserido com sucesso");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    //READ
    public List<Aluno> read(){
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try(Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                Aluno aluno = new Aluno(
                        resultSet.getString("nome_aluno"),
                        resultSet.getNString("matricula"),
                        resultSet.getDate("data_nascimento")
                );
                alunos.add(aluno);
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
        return alunos;
    }

    //UPDATE

    //DELETE
}
