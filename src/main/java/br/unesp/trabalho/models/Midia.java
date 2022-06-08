package br.unesp.trabalho.models;

public abstract class Midia {
	private String nome;
	private String codigoBarras;
	private Float preco;
	private Artista artista;

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Artista getArtista() {
		return artista;
	}

	public Midia(String nome, Float preco, String codigoBarras) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Nome mídia: " + this.nome + ", Codigo barras: " + this.codigoBarras + ", Preco: " + this.preco
				+ ", Artista: " + this.artista.getNome();
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

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public boolean equals(Midia obj) {
		return obj.getNome() == this.getNome();
	}
}
