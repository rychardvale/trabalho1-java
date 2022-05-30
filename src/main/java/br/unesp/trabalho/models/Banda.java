package br.unesp.trabalho.models;

public class Banda extends Artista {
	private Integer numeroIntegrantes;

	public Banda(String nome, Integer numeroIntegrantes) {
		super(nome);
		this.numeroIntegrantes = numeroIntegrantes;
	}

	@Override
	public String toString() {
		return super.toString() + ", Numero integrantes: " + this.numeroIntegrantes;
	}
}
