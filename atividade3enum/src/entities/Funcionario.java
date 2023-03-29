package entities;

import entities.enums.TipoDeDocumento;

public class Funcionario {
	private float numeroDocumento;
	private String nome;
	private TipoDeDocumento doc;
	
	public Funcionario(String nome, float numeroDocumento, TipoDeDocumento doc) {
		this.numeroDocumento = numeroDocumento;
		this.nome = nome;
		this.doc = doc;
	}
	public float getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(float numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoDeDocumento getDoc() {
		return doc;
	}
	public void setDoc(TipoDeDocumento doc) {
		this.doc = doc;
	}
	@Override
	public String toString() {
		return "Funcionario [numeroDocumento=" + numeroDocumento + ", nome=" + nome + ", doc=" + doc + "]";
	}
	
	
	
}
