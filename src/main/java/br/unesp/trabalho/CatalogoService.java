package br.unesp.trabalho;

import br.unesp.trabalho.models.*;
import br.unesp.trabalho.repository.ArtistaRepository;
import br.unesp.trabalho.repository.MidiaRepository;
import br.unesp.trabalho.utils.Utils;

import java.util.Iterator;
import java.util.List;

public final class CatalogoService {

	/**
	 * Listar todos as mídias do artista
	 *
	 * @param artista
	 */
	public static void listarTodos(Artista artista) {
		List<Midia> midias = MidiaRepository.getAll();
		if (midias == null) {
			Utils.print("Não há midias cadastradas");
			return;
		}

		Iterator<Midia> iterator = midias.iterator();
		int i = 0;
		Utils.printHeader(String.format("Todas as mídias de artista %s", artista.getNome()));
		while (iterator.hasNext()) {
			i++;
			Midia item = iterator.next();
			if (item.getArtista().equals(artista))
				System.out.println(i + " - " + item);
		}
	}

	/**
	 * Listar todas as mídias do catálogo
	 */
	public static void listarTodos() {
		List<Midia> midias = MidiaRepository.getAll();
		if (midias.size() == 0) {
			Utils.printErro("Não há midias cadastradas");
			return;
		}

		Iterator<Midia> iterator = midias.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			Midia item = iterator.next();
			System.out.println(Integer.toString(i) + ". " + item);
		}
	}

	public static void listarArtistas() {
		List<Artista> artistas = ArtistaRepository.getAll();
		if (artistas.size() == 0) {
			Utils.printErro("Não há artistas cadastrados");
			return;
		}

		Iterator<Artista> iterator = artistas.iterator();
		while (iterator.hasNext()) {
			Artista item = iterator.next();
			Utils.print("- " + item.getNome());
		}
	}

	public static void cadastrarArtista(Artista artista) {
		if (ArtistaRepository.get(artista) != null) {
			Utils.printErro("Artista já existe com este nome");
			return;
		}
		ArtistaRepository.create(artista);
		Utils.print("Artista adicionado com sucesso!");
	}

	public static void removerArtista(String nomeArtista) {
		Artista artistaRemovido = ArtistaRepository.delete(nomeArtista);
		if (artistaRemovido == null) {
			Utils.printErro("Artista não encontrado");
			return;
		}

		MidiaRepository.delete(artistaRemovido);
		Utils.print("Artista e suas mídias removidas");
	}

	public static void removerMidia(String nomeMidia) {
		Midia midiaRemovida = MidiaRepository.delete(nomeMidia);
		if (midiaRemovida == null) {
			Utils.print("Mídia não encontrada");
			return;
		}
		boolean isRemoved = ArtistaRepository.delete(midiaRemovida) != null;
		if (isRemoved)
			Utils.print("Midia removida com sucesso!");
		else
			Utils.print("Houve um problema ao remover a mídia");
	}

	public static void adicionarMidia(Midia input, String nomeArtista) {
		Artista artista = ArtistaRepository.get(nomeArtista);
		if (artista == null) {
			Utils.printErro(String.format("Artista de nome %s não encontrado", nomeArtista));
			return;
		}
		boolean exists = MidiaRepository.get(input) != null;
		if (exists) {
			Utils.printErro(String.format("Mídia já existe com nome %s", input.getNome()));
			return;
		}
		input.setArtista(artista);
		MidiaRepository.create(input);
		artista.adicionarMidia(input);
		Utils.print("Mídia adicionada com sucesso!");
	}

	public static void listarPorNomeMidia(String nomeMidia) {
		Midia midia = MidiaRepository.get(nomeMidia);
		if (midia == null) {
			Utils.printErro("Não exise mídia com esse nome");
			return;
		}
		Utils.print(midia);
	}
}
