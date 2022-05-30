package br.unesp.trabalho.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.unesp.trabalho.models.Artista;

public final class ArtistaRepository {
	private static Set<Artista> artistas = new HashSet<>();

	public void adicionarArtista(Artista artista) {
		if (artistas.contains(artista)) {
			System.out.println("Artista já cadastrado");
			return;
		}

		artistas.add(artista);
	}

	public void listarArtistas() {
		Iterator<Artista> iterator = artistas.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
}
