package br.unesp.trabalho.models;

import br.unesp.trabalho.models.Midia;

public class CD extends Midia {
	private Integer numeroFaixas;

	public CD(String nome, Float preco, String codigoBarras, Integer numeroFaixas) {
		super(nome, preco, codigoBarras);
		this.numeroFaixas = numeroFaixas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println(this.numeroFaixas);
		return super.toString();
	}

	public Integer getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(Integer numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}
}
