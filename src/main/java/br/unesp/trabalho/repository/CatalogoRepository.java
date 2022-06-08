package br.unesp.trabalho.repository;

import br.unesp.trabalho.models.*;
import br.unesp.trabalho.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class CatalogoRepository {
	private static List<Midia> midias = new ArrayList<>();

	public static Midia buscarMidia(Midia midia) {
		Iterator<Midia> iterator = midias.iterator();
		while (iterator.hasNext()) {
			Midia item = iterator.next();
			if (item.equals(midia)) {
				return item;
			}
		}
		return null;
	}

	public static void adicionarMidia(Midia midia) {
		midias.add(midia);
	}

	public static void listarTodos() {
		ListIterator<Midia> iterator = midias.listIterator();
		Utils.printHeader("Todas as mídias");
		while (iterator.hasNext()) {
			Midia item = iterator.next();
			System.out.println(iterator.nextIndex() + " - " + item);
		}
	}
}
