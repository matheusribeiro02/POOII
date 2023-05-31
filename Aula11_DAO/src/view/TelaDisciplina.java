package view;

import java.util.List;
import java.util.Scanner;

import model.dao.DisciplinaDAO;
import model.entities.Disciplina;

public class TelaDisciplina {
    
    private DisciplinaDAO disciplinaDAO;
    private Scanner scanner;
    
    public TelaDisciplina(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
        this.scanner = new Scanner(System.in);
    }
    
    public void menuDisciplina() {
        int opcao = 0;
        
        do {
            System.out.println("\n\n##### DISCIPLINA #####");
            System.out.println("==================================");
            System.out.println("| 1 - Cadastrar Disciplina       |");
            System.out.println("| 2 - Atualizar Disciplina       |");
            System.out.println("| 3 - Remover Disciplina         |");
            System.out.println("| 4 - Buscar Disciplina por ID   |");
            System.out.println("| 5 - Listar Disciplinas         |");
            System.out.println("| 0 - Sair                       |");
            System.out.println("==================================");
            System.out.println("Opção -> ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    atualizarDisciplina();
                    break;
                case 3:
                    removerDisciplina();
                    break;
                case 4:
                    buscarDisciplinaPorId();
                    break;
                case 5:
                    listarDisciplinas();
                    break;
                case 0:
                    System.out.println("Saindo do menu da Disciplina...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (opcao != 0);
    }
    
    private void cadastrarDisciplina() {
        System.out.println("\n\n##### CADASTRAR DISCIPLINA #####");
        System.out.println("==================================");
        System.out.println("| Nome:                          |");
        String nome = scanner.nextLine();
        
        Disciplina disciplina = new Disciplina();
        disciplina.setNomeDisciplina(nome);
        
        disciplinaDAO.insert(disciplina);
        
        System.out.println("Disciplina cadastrada com sucesso!");
    }
    
    private void atualizarDisciplina() {
        System.out.println("\n\n##### ATUALIZAR DISCIPLINA #####");
        System.out.println("==================================");
        System.out.println("| ID da Disciplina:              |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Disciplina disciplina = disciplinaDAO.findById(id);
        
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }
        
        System.out.println("| Novo Nome:                     |");
        String novoNome = scanner.nextLine();
        
        disciplina.setNomeDisciplina(novoNome);
        
        disciplinaDAO.update(disciplina);
        
        System.out.println("Disciplina atualizada com sucesso!");
    }
    
    private void removerDisciplina() {
        System.out.println("\n\n##### REMOVER DISCIPLINA #####");
        System.out.println("==================================");
        System.out.println("| ID da Disciplina:              |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Disciplina disciplina = disciplinaDAO.findById(id);
        
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }
        
        disciplinaDAO.deleteById(id);
        
        System.out.println("Disciplina removida com sucesso!");
    }
    
    private void buscarDisciplinaPorId() {
        System.out.println("\n\n##### BUSCAR DISCIPLINA POR ID #####");
        System.out.println("==================================");
        System.out.println("| ID da Disciplina:              |");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Disciplina disciplina = disciplinaDAO.findById(id);
        
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }
        
        System.out.println("Disciplina encontrada:");
        System.out.println("ID: " + disciplina.getIdDisciplina());
        System.out.println("Nome: " + disciplina.getNomeDisciplina());
    }
    
    private void listarDisciplinas() {
        System.out.println("\n\n##### LISTAR DISCIPLINAS #####");
        System.out.println("==================================");
        
        List<Disciplina> disciplinas = disciplinaDAO.findAll();
        
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas!");
            return;
        }
        
        System.out.println("Disciplinas cadastradas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("ID: " + disciplina.getIdDisciplina());
            System.out.println("Nome: " + disciplina.getNomeDisciplina());
            System.out.println("-----------------------");
        }
    }
}

