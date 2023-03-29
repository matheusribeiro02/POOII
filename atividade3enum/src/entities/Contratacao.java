package entities;

import java.util.Date;
import entities.enums.Cargo;
import entities.enums.Status;

public class Contratacao {
	
	public Date data;
	public Cargo cargo;
	public Status status;
	public Projeto projeto;

	public Contratacao(Date data, Cargo cargo, Funcionario funcionario, Projeto projeto) {
		this.data = data;
		this.cargo = cargo;
		this.status = Status.PENDENTE;
		this.projeto = projeto;
		if(!projeto.listaFuncionarios.contains(funcionario)) {
			projeto.listaFuncionarios.add(funcionario);
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void contratar() {
		if (this.status == Status.PENDENTE) {
			this.status = Status.CONTRATADO;
		}
	}
	
	public void demitir() {
		if (this.status == Status.CONTRATADO) {
			this.status = Status.DEMITIDO;
		}
	}
	
	public void pendente() {
		if (this.status == Status.DEMITIDO) {
			this.status = Status.PENDENTE;
		}
	}

	
}
