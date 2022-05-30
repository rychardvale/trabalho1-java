package br.unesp.trabalho.repository;

import br.unesp.trabalho.models.*;

import java.util.HashMap;
import java.util.Map;

public final class CatalogoRepository {
	private static Map<String, Artista> catalogo = new HashMap<>();
	private Map<String, Midia> midias = new HashMap<>();

	public static void adicionarAoCatalogo(Midia midia, Artista cantor) {
		catalogo.put(midia.getNome(), cantor);
	}
}
