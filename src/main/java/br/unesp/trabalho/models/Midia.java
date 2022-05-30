package br.unesp.trabalho.models;

public class Midia {
	private String nome;
	private String codigoBarras;
	private Float preco;

	public Midia(String nome, Float preco, String codigoBarras) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", Codigo barras: " + this.codigoBarras + ", Preco: " + this.preco;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
