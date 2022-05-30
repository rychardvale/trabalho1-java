package br.unesp.trabalho.repository;

import java.util.HashMap;
import java.util.Map;

import br.unesp.trabalho.models.Midia;

public class MidiaRepository {
	private static Map<String, Midia> midias = new HashMap<>();

	public static Midia consultarPorNome(String nome) {
		if (midias.containsKey(nome)) {
			return midias.get(nome);
		}

		return null;
	}
}
