package br.unesp.trabalho.models;

import java.util.HashSet;
import java.util.Set;

public class Artista {
	private String nome;
	private Set<Midia> midias = new HashSet<>();

	public Artista(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}

	public void addMidia(Midia midia) {
		this.midias.add(midia);
	}
}
