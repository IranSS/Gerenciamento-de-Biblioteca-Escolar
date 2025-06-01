import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int EncerrarPrograma = 0;

        do{
            System.out.println("--------Seja bem vindo ao gerenciador da biblioteca--------");
            System.out.println("O que você deseja gerenciar?");
            System.out.println("1-Alunos | 2-Livros | " +
                    "3-Emprestimos | 4-Sair");
            int resposta = scanner.nextInt();

            if(resposta == 1){
                resposta = 0;
                System.out.println("1-Cadastrar | 2-Listar Alunos + informações | 3-Atualizar | 4-Deletar ");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                AlunoDAO alunoDAO = new AlunoDAO();
                switch (escolha){
                    case 1:
                        //Criar
                        System.out.println("---Iniciando cadastro---");
                        Aluno aluno = formularioAluno();
                        alunoDAO.create(aluno);
                        mensagemFinalizacao();
                        break;
                    case 2:
                        //Listar
                        System.out.println("---Listando todos os alunos---");
                        List<Aluno> alunos = alunoDAO.read();
                        for(Aluno a : alunos){
                            System.out.println("ID do aluno: " + a.getId() +
                                    " - Nome do Aluno: " + a.getNome() +
                                    " - Matricula do aluno: " + a.getMatricula() +
                                    " - Data de nascimento: " + a.getData_nascimento());
                        }
                        mensagemFinalizacao();
                        break;
                    case 3:
                        //atualizar
                        System.out.println("---Iniciando Atualização do aluno---");

                        System.out.println("Digite o id do aluno que você quer atualizar as informações: ");
                        int id_update = scanner.nextInt();

                        aluno = formularioAluno();
                        aluno.setId(id_update);

                        alunoDAO.update(aluno);
                        mensagemFinalizacao();
                        break;
                    case 4:
                        //Deletar
                        System.out.println("---Adicione o id do usuário que você quer deletar---");
                        System.out.print("id: " );
                        int id = scanner.nextInt();
                        alunoDAO.delete(id);
                        mensagemFinalizacao();
                        break;
                    default:
                        break;
                }
            } else if(resposta == 2){
                //Faz mais sentido autuaizar somente o estoque, porém foi implementado o Update de todos os elementos
                System.out.println("1-Adicionar livro | 2-Listar livros + informações " +
                        "| 3-Atualizar Estoque | 4-Deletar Livro");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                LivroDAO livroDAO = new LivroDAO();
                Livro livro = null;
                switch (escolha){
                    case 1:
                        System.out.println("---Adionando novo livro---");
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Data da publicação do livro (yyyy): ");
                        int ano = scanner.nextInt();
                        System.out.print("Quantidade disponivel no estoque: ");
                        int quantidade = scanner.nextInt();

                        livro = new Livro(titulo, autor, ano, quantidade);
                        livroDAO.create(livro);
                        mensagemFinalizacao();
                        break;
                    case 2:
                        //Listar
                        System.out.println("---Listando todos os livros---");
                        List<Livro> livros = livroDAO.read();
                        for(Livro l : livros){
                            System.out.println("ID: " + l.getId() + " - Título: " + l.getTitulo() +
                                    " - Autor: " + l.getAutor() + " - Ano de publicação: " + l.getAno_publicacao()
                            + " - Quantidade: " + l.getQuantidade_estoque());
                        }
                        mensagemFinalizacao();
                        break;
                    case 3:
                        System.out.println("---Digite o ID do item para atualizar o estoque---");
                        System.out.print("ID: ");
                        int id_item = scanner.nextInt();
                        System.out.print("Quantidade: ");
                        int quantidadeAtualizada = scanner.nextInt();

                        livro = new Livro();
                        livro.setId(id_item);
                        livro.setQuantidade_estoque(quantidadeAtualizada);

                        livroDAO.atualizarQuantidade(livro);
                        mensagemFinalizacao();
                        break;
                    case 4:
                        System.out.println("---Adicione o ID do livro que você quer deletar---");
                        System.out.print("id: " );
                        int id = scanner.nextInt();
                        livroDAO.delete(id);
                        mensagemFinalizacao();
                        break;
                    default:
                        break;
                }

            } else if( resposta == 3){
                System.out.println("1-Criar emprestimo | 2-Relatorio de todos os emprestimos " +
                        "| 3-Atualizar Devolução | 4-Deletar registros");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
                Emprestimo emprestimo = null;

                switch (escolha){
                    case 1:
                        System.out.println("---Digite as informações para o emprestimo ser registrado---");

                        emprestimo = formularioEmprestimo();
                        emprestimoDAO.registrarEmprestimo(emprestimo);
                        mensagemFinalizacao();
                        break;
                    case 2:
                        System.out.println("---Listando todos os livros---");
                        List<Emprestimo> registros = emprestimoDAO.relatorioEmprestimos();
                        for(Emprestimo r : registros){
                            System.out.println("ID do Registro: " + r.getId() + " - ID do aluno: " +
                                    r.getAluno() + " - ID do Livro: " + r.getId_livro() +
                                    " - Data do emprestimo: " + r.getDataEmprestimo() +
                                    " - Data da devolução: " + r.getDataDevolucao());
                        }
                        mensagemFinalizacao();
                        break;
                    case 3:
                        System.out.println("---Atualizar registro---");
                        System.out.print("Digite o id do registro: ");
                        int id_registro = scanner.nextInt();

                        emprestimo = formularioEmprestimo();
                        emprestimo.setId(id_registro);

                        emprestimoDAO.atualizarRegistroEmprestimo(emprestimo);
                        mensagemFinalizacao();
                        break;
                    case 4:
                        System.out.println("---Adicione o ID do registro que você quer deletar---");
                        System.out.print("id: " );
                        int id = scanner.nextInt();
                        emprestimoDAO.deletarRegistroDeEmprestimo(id);
                        mensagemFinalizacao();
                        break;
                    default:
                        break;
                }
            }
            else{
                EncerrarPrograma = 4;
            }
        }while (EncerrarPrograma != 4);

        scanner.close();

        System.out.println("---Programa encerrado---");
    }
    public static Aluno formularioAluno(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Mátricula do aluno: " );
        String matricula = scanner.nextLine();
        System.out.println("Data de nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();

        //alterar formato da data
        Aluno aluno = new Aluno(nome,matricula, dataFormatada(dataNascimento));

        return aluno;
    }
    public static Emprestimo formularioEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do aluno: " );
        int id_aluno = scanner.nextInt();
        System.out.print("ID do livro: " );
        int id_livro = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Data da devolução (dd/mm//yyyy): ");
        String dataDevolucao = scanner.nextLine();

        Emprestimo emprestimo = new Emprestimo(id_aluno, id_livro, dataFormatada(dataDevolucao));

        return emprestimo;
    }
    public static Date dataFormatada(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localData = LocalDate.parse(data, formatter);
        Date data_final = Date.valueOf(localData);
        return data_final;
    }
    public static void mensagemFinalizacao(){
        System.out.println("---Voltando para o menu---");
    }
}
