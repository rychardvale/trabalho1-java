package br.unesp.trabalho.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.unesp.trabalho.models.Artista;
import br.unesp.trabalho.models.Midia;

public class MidiaRepository {
	private static Map<String, Midia> midias = new HashMap<>();

	public static Midia create(Midia midia) {
		return midias.put(midia.getNome(), midia);
	}

	public static Midia delete(Midia obj) {
		return midias.remove(obj.getNome());
	}

	public static Midia delete(String nome) {
		return midias.remove(nome);
	}

	/**
	 * Remove todas as mídias que pertencem ao artista
	 * 
	 * @param artista Artista
	 * @return Lista com artistas removidos
	 */
	public static List<Midia> delete(Artista artista) {
		Iterator<Midia> iterator = midias.values().iterator();
		List<Midia> removedMidias = new ArrayList<>();
		while (iterator.hasNext()) {
			Midia item = iterator.next();
			if (item.getArtista().equals(artista)) {
				midias.remove(item.getNome());
				removedMidias.add(item);
			}
		}
		return removedMidias;
	}

	public static Midia get(String nome) {
		return midias.get(nome);
	}

	public static Midia get(Midia midia) {
		return midias.get(midia.getNome());
	}

	public static List<Midia> getAll() {
		Iterator<Midia> iterator = midias.values().iterator();
		List<Midia> midiasArray = new ArrayList<>();
		while (iterator.hasNext()) {
			midiasArray.add(iterator.next());
		}
		return midiasArray;
	}

	public static Midia getByCodigoBarras(String codigoBarras) {
		Iterator<Midia> iterator = midias.values().iterator();
		while (iterator.hasNext()) {
			Midia item = iterator.next();
			if (item.getCodigoBarras() == codigoBarras)
				return item;
		}
		return null;
	}
}
