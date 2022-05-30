package br.unesp.trabalho.models;

public class Cantor extends Artista {
	private Float tempoCarreira;

	public Cantor(String nome, Float tempoCarreira) {
		super(nome);
		this.tempoCarreira = tempoCarreira;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tempo carreira: " + this.tempoCarreira;
	}
}
