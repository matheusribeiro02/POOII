package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Projeto {
	
	private String nome;
	private Date dt_inicio;
	private Date dt_termino;
	public List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	
	public Projeto(String nome, Date dt_inicio, Date dt_termino) {
		this.nome = nome;
		this.dt_inicio = dt_inicio;
		this.dt_termino = dt_termino;
	}
	
	public void listarContratacoes() {
		System.out.println(this.listaFuncionarios.toString());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_termino() {
		return dt_termino;
	}
	public void setDt_termino(Date dt_termino) {
		this.dt_termino = dt_termino;
	}
	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", dt_inicio=" + dt_inicio + ", dt_termino=" + dt_termino + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dt_inicio, dt_termino, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(dt_inicio, other.dt_inicio) && Objects.equals(dt_termino, other.dt_termino)
				&& Objects.equals(nome, other.nome);
	}

}
