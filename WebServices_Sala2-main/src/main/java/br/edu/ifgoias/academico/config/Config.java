package br.edu.ifgoias.academico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Curso c1 = new Curso(null,"Teste1");
		
		//Curso c2 = new Curso(null,"Teste2");
		
		//cursoRep.save(c1);
		
		//cursoRep.save(c2);
		
		//cursoRep.deleteById(7);
		
		//cursoRep.deleteById(8);
		
		System.out.println("Qtde Cursos: " + cursoRep.count()) ;
	}

}
