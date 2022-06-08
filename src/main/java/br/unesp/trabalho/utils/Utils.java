package br.unesp.trabalho.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	/**
	 * Lê input do usuário até que seja provido de um valor válido
	 */
	public static String lerString(String helperText) {
		String input = null;
		Scanner scanner = new Scanner(System.in);
		while (input == null) {
			try {
				System.out.print(helperText);
				input = scanner.nextLine();
			} catch (InputMismatchException e) {
				Utils.printErro("Input inválido, tente novamente");
				scanner.nextLine();
			} catch (Exception err) {
				Utils.printErro("Ocorreu um erro desconhecido, tente novamnete");
				scanner.nextLine();
			}
		}
		return input;
	}

	public static int lerInt(String helperText) {
		Integer input = null;
		Scanner scanner = new Scanner(System.in);
		while (input == null) {
			try {
				System.out.print(helperText);
				input = scanner.nextInt();
			} catch (InputMismatchException e) {
				Utils.printErro("Input inválido, tente novamente");
				scanner.nextLine();
			} catch (Exception err) {
				Utils.printErro("Ocorreu um erro desconhecido, tente novamnete");
				scanner.nextLine();
			}
		}
		return input.intValue();
	}

	public static Float lerFloat(String helperText) {
		Float input = null;
		Scanner scanner = new Scanner(System.in);
		while (input == null) {
			try {
				System.out.print(helperText);
				input = scanner.nextFloat();
			} catch (InputMismatchException e) {
				Utils.printErro("Input inválido, tente novamente");
				scanner.nextLine();
			} catch (Exception err) {
				Utils.printErro("Ocorreu um erro desconhecido, tente novamente");
				scanner.nextLine();
			}
		}
		return input;
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void print(String[] strArray) {
		for (String str : strArray) {
			System.out.println(str);
		}
	}

	public static void printErro(String str) {
		System.out.println("[ERRO]: " + str);
	}

	public static void printHeader(String str) {
		System.out.println("\n----- " + str.toUpperCase() + " -----");
	}
}