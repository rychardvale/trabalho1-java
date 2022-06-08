package br.unesp.trabalho.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.unesp.trabalho.models.Artista;
import br.unesp.trabalho.models.Midia;

public final class ArtistaRepository {
	private static Map<String, Artista> mapArtista = new HashMap<>();

	public static Artista create(Artista artista) {
		return mapArtista.put(artista.getNome(), artista);
	}

	public static Artista get(String nome) {
		return mapArtista.get(nome);
	}

	public static Artista get(Artista artista) {
		return mapArtista.get(artista.getNome());
	}

	public static Artista delete(String nome) {
		return mapArtista.remove(nome);
	}

	public static Artista delete(Artista artista) {
		return mapArtista.remove(artista.getNome());
	}

	/**
	 * Procura o artista que pertence a midia e remove de sua lista de midias
	 * 
	 * @param midia
	 * @return
	 */
	public static Midia delete(Midia midia) {
		Artista artista = mapArtista.get(midia.getArtista().getNome());
		boolean isDeleted = artista.getMidias().remove(midia);
		return isDeleted ? midia : null;
	}

	public static boolean isEmpty() {
		return mapArtista.isEmpty();
	}

	public static List<Artista> getAll() {
		Iterator<Artista> iterator = mapArtista.values().iterator();
		List<Artista> artistas = new ArrayList<>();
		while (iterator.hasNext()) {
			artistas.add(iterator.next());
		}
		return artistas.isEmpty() ? null : artistas;
	}
}