package model.entities;

import java.util.Objects;

public class Aluno {
	
	private int idAluno;
	private String nomeAluno;

	public Aluno() {
		
	}

	public Aluno(int idAluno, String nomeAluno) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAluno, nomeAluno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return idAluno == other.idAluno && Objects.equals(nomeAluno, other.nomeAluno);
	}
	
	

}
