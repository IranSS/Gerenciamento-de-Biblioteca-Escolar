package dao;

import model.Emprestimo;
import model.Livro;
import util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    DataBaseConnection dataBaseConnection;

    //CREATE
    public void registrarEmprestimo(Emprestimo emprestimo){

        //comando SQL para rodar
        String sql = "INSERT INTO emprestimos(id_aluno, id_livro, data_devolucao) VALUES (?,?,?)";

        //Fazer TryCatch para tratar o error do SQL
        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, emprestimo.getAluno());
            preparedStatement.setInt(2, emprestimo.getId_livro());
            preparedStatement.setDate(3, emprestimo.getDataDevolucao());
            preparedStatement.executeUpdate();

            System.out.println("Emprestimo realizado com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }
    //READ
    public List<Emprestimo> relatorioEmprestimos(){
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos";

        try (Connection connection = dataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                Emprestimo emprestimo = new Emprestimo(
                        resultSet.getInt("id_emprestimos"),
                        resultSet.getInt("id_aluno"),
                        resultSet.getInt("id_livro"),
                        resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_devolucao")
                );
                emprestimos.add(emprestimo);
            }
        } catch (SQLException error){
            error.printStackTrace();
        }
        return emprestimos;
    }

    //UPDATE
    public void atualizarRegistroEmprestimo(Emprestimo emprestimo){
        String sql = "UPDATE emprestimos SET id_aluno = ?, id_livro = ?, data_devolucao = ? WHERE id_emprestimo = ?";

        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, emprestimo.getAluno());
            preparedStatement.setInt(2, emprestimo.getId_livro());
            preparedStatement.setDate(3, emprestimo.getDataDevolucao());
            preparedStatement.setInt(4, emprestimo.getId());
            preparedStatement.executeUpdate();

            System.out.println("Registro de emprestimo atualizado com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    //DELETE
    public void deletarRegistroDeEmprestimo(int id){
        String sql = "DELETE FROM emprestimos where id_emprestimos = ?";

        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Livro deletado com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }
}
