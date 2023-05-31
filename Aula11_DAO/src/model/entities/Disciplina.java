package model.entities;

import java.util.Objects;

public class Disciplina {
	
	private int idDisciplina;
	private String nomeDisciplina;

	public Disciplina() {
		
	}

	public Disciplina(int idDisciplina, String nomeDisciplina) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDisciplina, nomeDisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return idDisciplina == other.idDisciplina && Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}
	
	

}
