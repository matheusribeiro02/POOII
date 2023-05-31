package view;

import java.util.List;
import java.util.Scanner;

import model.dao.AlunoDAO;
import model.entities.Aluno;

public class TelaAluno {
    
    private AlunoDAO alunoDAO;
    private Scanner scanner;
    
    public TelaAluno(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
        this.scanner = new Scanner(System.in);
    }
    
    public void menuAluno() {
        int opcao = 0;
        
        do {
            System.out.println("\n\n##### ALUNO #####");
            System.out.println("==================================");
            System.out.println("| 1 - Cadastrar Aluno             |");
            System.out.println("| 2 - Atualizar Aluno             |");
            System.out.println("| 3 - Remover Aluno               |");
            System.out.println("| 4 - Buscar Aluno por ID         |");
            System.out.println("| 5 - Listar Alunos               |");
            System.out.println("| 0 - Sair                        |");
            System.out.println("==================================");
            System.out.println("Opção -> ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    atualizarAluno();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    buscarAlunoPorId();
                    break;
                case 5:
                    listarAlunos();
                    break;
                case 0:
                    System.out.println("Saindo do menu do Aluno...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (opcao != 0);
    }
    
    private void cadastrarAluno() {
        System.out.println("\n\n##### CADASTRAR ALUNO #####");
        System.out.println("==================================");
        System.out.println("| Nome:                         |");
        String nome = scanner.nextLine();
        
        Aluno aluno = new Aluno();
        aluno.setNomeAluno(nome);
        
        alunoDAO.insert(aluno);
        
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    private void atualizarAluno() {
        System.out.println("\n\n##### ATUALIZAR ALUNO #####");
        System.out.println("==================================");
        System.out.println("| ID do Aluno:                  |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Aluno aluno = alunoDAO.findById(id);
        
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        System.out.println("| Novo Nome:                    |");
        String novoNome = scanner.nextLine();
        
        aluno.setNomeAluno(novoNome);
        
        alunoDAO.update(aluno);
        
        System.out.println("Aluno atualizado com sucesso!");
    }
    
    private void removerAluno() {
        System.out.println("\n\n##### REMOVER ALUNO #####");
        System.out.println("==================================");
        System.out.println("| ID do Aluno:                  |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Aluno aluno = alunoDAO.findById(id);
        
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        alunoDAO.deleteById(id);
        
        System.out.println("Aluno removido com sucesso!");
    }
    
    private void buscarAlunoPorId() {
        System.out.println("\n\n##### BUSCAR ALUNO POR ID #####");
        System.out.println("==================================");
        System.out.println("| ID do Aluno:                  |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Aluno aluno = alunoDAO.findById(id);
        
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        System.out.println("Aluno encontrado:");
        System.out.println("ID: " + aluno.getIdAluno());
        System.out.println("Nome: " + aluno.getNomeAluno());
    }
    
    private void listarAlunos() {
        System.out.println("\n\n##### LISTAR ALUNOS #####");
        System.out.println("==================================");
        
        List<Aluno> alunos = alunoDAO.findAll();
        
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
            return;
        }
        
        System.out.println("Alunos cadastrados:");
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getIdAluno());
            System.out.println("Nome: " + aluno.getNomeAluno());
            System.out.println("-----------------------");
        }
    }
}

