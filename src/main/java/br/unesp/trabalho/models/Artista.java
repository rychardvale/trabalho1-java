package br.unesp.trabalho.models;

import java.util.HashSet;
import java.util.Iterator;
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

	private String midiasToString() {
		Iterator<Midia> iterator = this.midias.iterator();
		String midiasStr = null;
		while (iterator.hasNext()) {
			Midia midia = iterator.next();
			midiasStr = String.format("%s%n%s", midiasStr, midia);
		}
		return midiasStr;
	}

	public void adicionarMidia(Midia midia) {
		this.midias.add(midia);
	}
}
