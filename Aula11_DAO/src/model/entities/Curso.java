package model.entities;

import java.util.Objects;

public class Curso {
	
	private int idCurso;
	private String nomeCurso;
	
	public Curso(int idCurso, String nomeCurso) {
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}
	
	public Curso() {
	
	}

	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCurso, nomeCurso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return idCurso == other.idCurso && Objects.equals(nomeCurso, other.nomeCurso);
	}
	
}
