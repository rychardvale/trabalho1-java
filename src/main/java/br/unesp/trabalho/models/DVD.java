package br.unesp.trabalho.models;

public class DVD extends Midia {
	private Float tempoDuracao;

	public DVD(String nome, Float preco, String codigoBarras, Float tempoDuracao) {
		super(nome, preco, codigoBarras);
		this.tempoDuracao = tempoDuracao;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tempo duracao: " + this.tempoDuracao;
	}

	public Float getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(Float tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}
}
