package br.unesp.trabalho.models;

public class CD extends Midia {
	private Integer numeroFaixas;

	public CD(String nome, Float preco, String codigoBarras, Integer numeroFaixas) {
		super(nome, preco, codigoBarras);
		this.numeroFaixas = numeroFaixas;
	}

	@Override
	public String toString() {
		return super.toString() + ", Número de faixas: " + this.numeroFaixas;
	}

	public Integer getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(Integer numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}
}
