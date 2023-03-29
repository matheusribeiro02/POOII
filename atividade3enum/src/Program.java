import java.util.Date;

import entities.Contratacao;
import entities.Funcionario;
import entities.Projeto;
import entities.enums.Cargo;
import entities.enums.TipoDeDocumento;

public class Program {

	public static void main(String[] args) {
		Projeto p1 = new Projeto("Construcao Loja", new Date(), new Date());
		Funcionario f1 = new Funcionario("Matheus", 1, TipoDeDocumento.CPF);
		Funcionario f2 = new Funcionario("Gabriel", 2, TipoDeDocumento.CPF);
		
		Contratacao c1 = new Contratacao(new Date(), Cargo.ADMINISTRATIVO, f1, p1);
		Contratacao c2 = new Contratacao(new Date(), Cargo.ADMINISTRATIVO, f2, p1);
		
		p1.listarContratacoes();
		
		c1.contratar();
		c2.contratar();
		
		p1.listarContratacoes();

	}

}
