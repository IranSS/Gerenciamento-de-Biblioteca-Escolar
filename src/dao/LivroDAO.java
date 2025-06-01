package dao;

import model.Livro;
import util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    DataBaseConnection dataBaseConnection;

    //CREATE
    public void create(Livro livro){

        //comando SQL para rodar
        String sql = "INSERT INTO Livros(titulo, autor, ano_publicacao, quantidade_estoque) VALUES (?,?,?,?)";

        //Fazer TryCatch para tratar o error do SQL
        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());
            preparedStatement.setInt(4, livro.getQuantidade_estoque());
            preparedStatement.executeUpdate();

            System.out.println("Livro inserido com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    //READ
    public List<Livro> read(){
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection connection = dataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                Livro livro = new Livro(
                        resultSet.getInt("id_livro"),
                        resultSet.getString("titulo"),
                        resultSet.getNString("autor"),
                        resultSet.getInt("ano_publicacao"),
                        resultSet.getInt("quantidade_estoque")
                );
                livros.add(livro);
            }
        } catch (SQLException error){
            error.printStackTrace();
        }
        return livros;
    }
    //READ somente 1
    public Livro pegarUmLivro(int id){
        Livro livro = null;
        String sql = "SELECT * FROM Livros where id_livro = ?";

        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                livro = new Livro(
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getInt("ano_publicacao"),
                        resultSet.getInt("quantidade_estoque")
                );
            }
        } catch (SQLException error){
            error.printStackTrace();
        }
        return livro;
    }
    //UPDATE
    public void update(Livro livro){
        String sql = "UPDATE Livros SET titulo = ?, autor = ?, ano_publicacao = ?, quantidade_estoque = ? WHERE id_livro = ?";

        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());
            preparedStatement.setInt(4, livro.getQuantidade_estoque());
            preparedStatement.setInt(5, livro.getId());
            preparedStatement.executeUpdate();

            System.out.println("Livro atualizado com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }
    public void atualizarQuantidade(Livro livro){
        String sql = "UPDATE Livros SET quantidade_estoque = ? WHERE id_livro = ?";

        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            //diminui uma quantidade de livro quando for retirado;
            preparedStatement.setInt(1, livro.getQuantidade_estoque());
            preparedStatement.setInt(2, livro.getId());
            preparedStatement.executeUpdate();

            System.out.println("Livro atualizado com sucesso!");
        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    //DELETE
    public void delete(int id){
        String sql = "DELETE FROM Livros where id_livro = ?";

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
