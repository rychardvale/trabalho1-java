package br.unesp.trabalho;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.rmi.CORBA.Util;

import br.unesp.trabalho.models.Artista;
import br.unesp.trabalho.models.Banda;
import br.unesp.trabalho.models.CD;
import br.unesp.trabalho.models.Cantor;
import br.unesp.trabalho.models.DVD;
import br.unesp.trabalho.repository.ArtistaRepository;
import br.unesp.trabalho.repository.CatalogoRepository;
import br.unesp.trabalho.utils.Utils;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String[] opcoesMenuPrincipal = {
			"1. Cadastrar",
			"2. Consultar",
			"3. Deletar",
			"4. Listar Todos",
			"5. Sair",
	};
	private static final String[] opcoesSubmenuCadastrar = {
			"1. Cadastrar Banda",
			"2. Cadastrar Cantor",
			"3. Cadastrar DVD",
			"4. Cadastrar CD",
			"5. Voltar"
	};

	public static void inicializarMenu() {
		System.out.println("Menu inicializado");
		int opcao = 0;
		while (opcao != 5) {
			try {
				Utils.printHeader("MENU");
				Utils.print(opcoesMenuPrincipal);
				opcao = Utils.lerInt("Escolha uma opção: ");
				handleOpcaoMenu(opcao);
			} catch (InputMismatchException e) {
				Utils.printErro("Número inválido, tente novamente");
			} catch (Exception generico) {
				Utils.printErro("Ocorreu um erro inesperado, tente novamente");
			}
		}
	}

	private static void handleOpcaoMenu(int opcao) {
		switch (opcao) {
			case 1: {
				int opcaoCadastrar = 0;
				while (opcaoCadastrar != 5) {
					try {
						Utils.printHeader("Menu cadastrar");
						Utils.print(opcoesSubmenuCadastrar);
						opcaoCadastrar = Utils.lerInt("Escolha uma opção: ");
						if (opcaoCadastrar == 1)
							CadastrarBanda();
						if (opcaoCadastrar == 2)
							CadastrarCantor();
						if (opcaoCadastrar == 3)
							CadastrarDVD();
						if (opcaoCadastrar == 4)
							CadastrarCD();
					} catch (InputMismatchException e) {
						Utils.printErro("Opção inválida, tente novamente.");
					} catch (Exception err) {
						Utils.printErro("Erro inesperado, tente novamente.");
					}
				}
				break;
			}
			case 2:
				break;
			case 3:
				break;
			case 4:
				CatalogoRepository.listarTodos();
				break;
			case 5:
				break;
		}
	}

	private static void CadastrarBanda() {
		Utils.printHeader("Cadastrar Banda");
		String nome = Utils.lerString("Nome da banda: ");
		Integer numeroIntegrantes = Utils.lerInt("Número de integrantes: ");
		Banda banda = new Banda(nome, numeroIntegrantes);

		if (ArtistaRepository.buscarArtista(banda) != null) {
			Utils.printErro("Artista já existe com este nome");
			return;
		}

		ArtistaRepository.adicionarArtista(banda);
	}

	private static void CadastrarCantor() {
		Utils.printHeader("Cadastrar Cantor");
		String nome = Utils.lerString("Nome cantor: ");
		Float tempoCarreira = Utils.lerFloat("Tempo de carreira (anos): ");
		Cantor cantor = new Cantor(nome, tempoCarreira);

		if (ArtistaRepository.buscarArtista(cantor) != null) {
			Utils.printErro("Artista já existe com este nome");
			return;
		}

		ArtistaRepository.adicionarArtista(cantor);
	}

	private static void CadastrarCD() {
		Utils.printHeader("Cadastrar CD");
		String nome = Utils.lerString("Nome: ");
		Float preco = Utils.lerFloat("Preço: ");
		String codigoBarras = Utils.lerString("Código de barras: ");
		while (codigoBarras.length() != 6) {
			Utils.printErro("Tamanho código de barras inválido. Deve conter 6 caracteres.");
			codigoBarras = Utils.lerString("Código de barras: ");
		}
		Integer numeroFaixas = Utils.lerInt("Número de faixas: ");

		CD cd = new CD(nome, preco, codigoBarras, numeroFaixas);
		if (CatalogoRepository.buscarMidia(cd) != null) {
			Utils.printErro("Midia já pertence à outro artista");
			Utils.printErro("Retornando ao menu...");
			return;
		}

		String artistaNome = Utils.lerString("Nome da Banda/Cantor: ");
		Artista artista = ArtistaRepository.buscarArtista(artistaNome);
		if (artista == null) {
			Utils.printErro("Artista não existe");
			return;
		}

		cd.setArtista(artista);
		artista.adicionarMidia(cd);
		CatalogoRepository.adicionarMidia(cd);
	}

	private static void CadastrarDVD() {
		Utils.printHeader("Cadastrar DVD");
		String nome = Utils.lerString("Nome: ");
		Float preco = Utils.lerFloat("Preço: ");
		String codigoBarras = Utils.lerString("Código de barras: ");
		while (codigoBarras.length() != 6) {
			Utils.printErro("Tamanho código de barras inválido. Deve conter 6 caracteres.");
			codigoBarras = Utils.lerString("Código de barras: ");
		}
		Float tempoDuracao = Utils.lerFloat("Tempo de duração (minutos): ");
		DVD dvd = new DVD(nome, preco, codigoBarras, tempoDuracao);

		if (CatalogoRepository.buscarMidia(dvd) != null) {
			Utils.printErro("Midia já pertence à outro artista");
			Utils.print("Voltando ao menu");
			return;
		}

		Utils.printHeader("artistas disponíveis");
		ArtistaRepository.listarArtistas();
		String artistaNome = Utils.lerString("Nome do Artista: ");
		Artista artista = ArtistaRepository.buscarArtista(artistaNome);
		if (artista == null) {
			Utils.printErro("Artista não existe");
			return;
		}

		dvd.setArtista(artista);
		artista.adicionarMidia(dvd);
		CatalogoRepository.adicionarMidia(dvd);
	}
}
