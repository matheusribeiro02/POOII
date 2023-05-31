package view;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.dao.CursoDAO;
import model.dao.CursoDAOImp;
import model.db.db;
import model.entities.Curso;

public class TelaCurso {

	public static Scanner menuCurso(Scanner console) throws InterruptedException {
		int opcao = 0;

		do {

			System.out.println("\n\n##### CURSO #####");
			System.out.println("==================================");
			System.out.println("| 1 - CADASTRAR                    |");
			System.out.println("| 2 - ALTERAR                      |");
			System.out.println("| 3 - EXCLUIR                      |");
			System.out.println("| 4 - LISTAR                       |");
			System.out.println("| 0 - SAIR                         |");
			System.out.println("===================================");
			System.out.println("Op��o -> ");
			opcao = console.nextInt();
			console.nextLine();

			switch (opcao) {
			case 1:
				console = cadastrar(console);
			case 2:
			case 3:
			case 4:
			case 0:
				console = TelaPrincipal.menuPrincipal(console);
			default:
				System.out.println("Opcao invalida!");
				TimeUnit.SECONDS.sleep(2);
			}

		} while (opcao != 0);
		return console;
	}

	private static Scanner cadastrar(Scanner console) {
		Curso c = new Curso();

		System.out.println("\n\n##### CURSO - cadastra #####");
		System.out.println("==================================");
		System.out.println("| Nome:                    |");
		c.setNomeCurso(console.nextLine());
		System.out.println("==================================");
		CursoDAO cursoDao = new CursoDAOImp(db.getConexao());
		cursoDao.insert(c);
		console.nextLine();

		return console;
	}
}
