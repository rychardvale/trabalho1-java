package br.unesp.trabalho.models;

import java.util.HashSet;
import java.util.Set;

public abstract class Artista {
	private String nome;
	private Set<Midia> midias = new HashSet<>();

	public Artista(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Set<Midia> getMidias() {
		return midias;
	}

	@Override
	public String toString() {
		return String.format("Nome artista: %s", this.nome);
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public boolean equals(Artista artista) {
		return this.getNome() == artista.getNome();
	}

	public void adicionarMidia(Midia midia) {
		this.midias.add(midia);
	}
}
