package br.unesp.trabalho;

import java.util.InputMismatchException;

import br.unesp.trabalho.models.Artista;
import br.unesp.trabalho.models.Banda;
import br.unesp.trabalho.models.CD;
import br.unesp.trabalho.models.Cantor;
import br.unesp.trabalho.models.DVD;
import br.unesp.trabalho.repository.ArtistaRepository;
import br.unesp.trabalho.utils.Utils;

public class Menu {
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
	private static final String[] opcoesSubmenuConsultar = {
			"1. Consultar por Nome de Artista",
			"2. Consultar por Nome de Mídia",
			"3. Voltar"
	};
	private static final String[] opcoesSubmenuDeletar = {
			"1. Deletar por Nome de Artista",
			"2. Deletar por Nome de Mídia",
			"3. Voltar"
	};
	private static final String[] opcoesSubmenuListar = {
			"1. Listar Artistas",
			"2. Listar Midias",
			"3. Voltar"
	};

	public static void inicializarMenu() {
		System.out.println("Menu inicializado");
		int opcao = 0;
		while (opcao != 5) {
			try {
				Utils.printHeader("menu");
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
							cadastrarBanda();
						if (opcaoCadastrar == 2)
							cadastrarCantor();
						if (opcaoCadastrar == 3)
							cadastrarDVD();
						if (opcaoCadastrar == 4)
							cadastrarCD();
					} catch (InputMismatchException e) {
						Utils.printErro("Opção inválida, tente novamente.");
					} catch (Exception err) {
						Utils.printErro("Erro inesperado, tente novamente.");
					}
				}
				break;
			}
			case 2:
				int opcaoConsultar = 0;
				while (opcaoConsultar != 3) {
					try {
						Utils.printHeader("Menu consultar");
						Utils.print(opcoesSubmenuConsultar);
						opcaoConsultar = Utils.lerInt("Escolha uma opção: ");
						if (opcaoConsultar == 1)
							consultarPorArtista();
						if (opcaoConsultar == 2) {
							consultaPorNomeMidia();
						}
					} catch (InputMismatchException e) {
						Utils.printErro("Opção inválida, tente novamente.");
					} catch (Exception err) {
						Utils.printErro("Erro inesperado, tente novamente.");
					}
				}
				break;
			case 3:
				int opcaoDeletar = 0;
				while (opcaoDeletar != 3) {
					try {
						Utils.printHeader("Menu deletar");
						Utils.print(opcoesSubmenuDeletar);
						opcaoDeletar = Utils.lerInt("Escolha uma opção: ");
						if (opcaoDeletar == 1)
							removerArtista();
						if (opcaoDeletar == 2) {
							removerMidia();
						}
					} catch (InputMismatchException e) {
						Utils.printErro("Opção inválida, tente novamente.");
					} catch (Exception err) {
						Utils.printErro("Erro inesperado, tente novamente.");
					}
				}
				break;
			case 4:
				int opcaoListar = 0;
				while (opcaoListar != 3) {
					try {
						Utils.printHeader("Menu listar");
						Utils.print(opcoesSubmenuListar);
						opcaoListar = Utils.lerInt("Escolha uma opção: ");
						if (opcaoListar == 1)
							listarTodosArtistas();
						if (opcaoListar == 2) {
							listarTodasMidias();
						}
					} catch (InputMismatchException e) {
						Utils.printErro("Opção inválida, tente novamente.");
					} catch (Exception err) {
						Utils.printErro("Erro inesperado, tente novamente.");
					}
				}
				break;
			case 5:
				Utils.printHeader("Finalizando programa");
				break;
		}
	}

	private static void cadastrarBanda() {
		Utils.printHeader("Cadastrar Banda");
		String nome = Utils.lerString("Nome da banda: ");
		Integer numeroIntegrantes = Utils.lerInt("Número de integrantes: ");
		Banda banda = new Banda(nome, numeroIntegrantes);
		CatalogoService.cadastrarArtista(banda);
	}

	private static void cadastrarCantor() {
		Utils.printHeader("Cadastrar Cantor");
		String nome = Utils.lerString("Nome cantor: ");
		Float tempoCarreira = Utils.lerFloat("Tempo de carreira (anos): ");
		Cantor cantor = new Cantor(nome, tempoCarreira);
		CatalogoService.cadastrarArtista(cantor);
	}

	private static void cadastrarCD() {
		if (ArtistaRepository.isEmpty()) {
			Utils.printErro("Não há artistas cadastrados");
			Utils.printErro("Voltando ao menu");
			return;
		}

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

		Utils.printHeader("artistas disponíveis");
		CatalogoService.listarArtistas();
		String nomeArtista = Utils.lerString("Nome do Artista: ");
		CatalogoService.adicionarMidia(cd, nomeArtista);
	}

	private static void cadastrarDVD() {
		if (ArtistaRepository.isEmpty()) {
			Utils.printErro("Não há artistas cadastrados");
			Utils.printErro("Voltando ao menu");
			return;
		}

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

		Utils.printHeader("artistas disponíveis");
		CatalogoService.listarArtistas();
		String nomeArtista = Utils.lerString("Nome do Artista: ");
		CatalogoService.adicionarMidia(dvd, nomeArtista);
	}

	private static void consultarPorArtista() {
		if (ArtistaRepository.isEmpty()) {
			Utils.printErro("Não há artistas cadastrados");
			Utils.printErro("Voltando ao menu");
			return;
		}
		Utils.printHeader("Consultar por artistas");
		String nomeArtista = Utils.lerString("Nome do artista: ");
		Artista artista = ArtistaRepository.get(nomeArtista);
		CatalogoService.listarTodos(artista);
	}

	private static void consultaPorNomeMidia() {
		Utils.printHeader("Consultar por nome de mídia");
		String nomeMidia = Utils.lerString("Nome da mídia desejada: ");
		CatalogoService.listarPorNomeMidia(nomeMidia);
	}

	private static void removerArtista() {
		Utils.printHeader("Remover artista");
		String nome = Utils.lerString("Nome do artista a ser removido: ");
		CatalogoService.removerArtista(nome);
	}

	private static void removerMidia() {
		Utils.printHeader("Remover mídia");
		String nome = Utils.lerString("Nome da mídia a ser removida: ");
		CatalogoService.removerMidia(nome);
	}

	private static void listarTodasMidias() {
		CatalogoService.listarTodos();
	}

	private static void listarTodosArtistas() {
		CatalogoService.listarArtistas();
	}
}
