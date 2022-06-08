package br.unesp.trabalho.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.unesp.trabalho.models.Artista;
import br.unesp.trabalho.utils.Utils;

public final class ArtistaRepository {
	private static Map<String, Artista> mapArtista = new HashMap<>();

	public static void adicionarArtista(Artista artista) {
		mapArtista.put(artista.getNome(), artista);
	}

	public static void listarArtistas() {
		Iterator<Artista> iterator = mapArtista.values().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			Utils.print(i + ". " + iterator.next().getNome());
		}
	}

	public static Artista buscarArtista(Artista artista) {
		if (mapArtista.containsKey(artista.getNome())) {
			return mapArtista.get(artista.getNome());
		}
		return null;
	}

	public static Artista buscarArtista(String nome) {
		if (mapArtista.containsKey(nome)) {
			return mapArtista.get(nome);
		}
		return null;
	}
}