package app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;
import jdbc.db;

public class Program {

	public static void main(String[] args) throws IOException, SQLException {
		
		try {
			int opcao = 0;
			Scanner console = new Scanner(System.in);
			
			do {
				System.out.println("##### MENU #####"
									+ "\n1 - Cadastrar"
									+ "\n2 - Listar"
									+ "\n3 - Alterar"
									+ "\n4 - Excluir"
									+ "\n5 - Sair");
				
				System.out.println("\n\tOp��o:");
				opcao = Integer.parseInt(console.nextLine());
				AlunoJDBC acao = new AlunoJDBC();
				
				switch (opcao) {
				  case 1:
					  Aluno a = new Aluno();		
						System.out.println("##### CADASTRAR ALUNO #####");
						System.out.print("Nome: ");
						a.setNome(console.nextLine());
						System.out.print("Sexo: ");
						a.setSexo(console.nextLine());
						System.out.print("Data de nascimento (dd//mm/AAAA): ");
						a.setDt_nasc(new Date(console.nextLine()));
						
						acao.salvar(a);
				    break;
				    
				  case 2:
						System.out.println("##### LISTA DE ALUNOS #####");
						System.out.print(acao.listarAlunos());
				    break;
				    
				  case 3:
					  Aluno b = new Aluno();		
						System.out.println("##### ALTERAR ALUNO #####");
						System.out.print("Nome: ");
						b.setNome(console.nextLine());
						System.out.print("Sexo: ");
						b.setSexo(console.nextLine());
						System.out.print("Data de nascimento (dd//mm/AAAA): ");
						b.setDt_nasc(new Date(console.nextLine()));
						
						acao.alterar(b);
				    break;
				    
				  case 4:		
						System.out.println("##### EXCLUIR ALUNO #####");
						System.out.print("ID: ");
						int id = console.nextInt();
						acao.apagar(id);
				    break;
				    
				}
				
//				if (opcao == 1) {
//					
//					Aluno a = new Aluno();
//					AlunoJDBC acao = new AlunoJDBC();
//					
//					System.out.println("##### CADASTRAR ALUNO #####");
//					System.out.print("Nome: ");
//					a.setNome(console.nextLine());
//					System.out.print("Sexo: ");
//					a.setSexo(console.nextLine());
//					System.out.print("Data de nascimento (dd//mm/AAAA): ");
//					a.setDt_nasc(new Date(console.nextLine()));
//					
//					acao.salvar(a);
//				}
				
			} while (opcao != 5);
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		
//		Connection con = db.getConexao();
//		System.out.println("***Conexao realizada com sucesso!*** \n");
//		
//		Statement st = con.createStatement();
//		
//		String sql = "SELECT * FROM aluno";
//		
//		ResultSet rs = st.executeQuery(sql);
//		
//		while (rs.next()) {
//			System.out.println("Id: " + rs.getInt(1) + " | " + "Nome: " + rs.getString(2));
//		}
//		
//		rs.close();
//		st.close();
		
		db.closeConexao();
		System.out.println("\n***Conexao finalizada com sucesso!***");

	}

}
