package view;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TelaPrincipal {

	public static Scanner menuPrincipal(Scanner console) throws InterruptedException {
		
		int opcao = 0;
		
		do {
			
			System.out.println("\n\n##### Sistema de Controle Escolar #####");
			System.out.println("==================================");
			System.out.println("| 1 - Aluno                      |");
			System.out.println("| 2 - Curso                      |");
			System.out.println("| 3 - Disciplina                 |");
			System.out.println("| 0 - Aluno                      |");
			System.out.println("===================================");
			System.out.println("Opção -> ");
			opcao = console.nextInt();
			console.nextLine();
			
			switch(opcao) {
			case 1:
			case 2: return TelaCurso.menuCurso(console);
			case 3:
			case 0: System.out.println("Saindo ...");
			default: System.out.println("Opcao invalida!");
					 TimeUnit.SECONDS.sleep(2);
			}
			
		} while (opcao != 0);
		return console;
	}
	
}
