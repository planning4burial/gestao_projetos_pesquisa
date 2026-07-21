package estrutura;

import java.util.Date;

public class Relatorio {
	private String titulo;
	private String conteudo;
	private Date dataGeracao;
	private String criador;
	private Boolean valido;

	public Relatorio(String titulo, String conteudo, Date dataGeracao, String criador, Boolean valido) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataGeracao = dataGeracao;
		this.criador = criador;
		this.valido = valido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public void exibirRelatorio() {
		System.out.println("=== " + titulo.toUpperCase() + " ===");
		System.out.println("Gerado por: " + criador);
		System.out.println("Data: " + dataGeracao);
		System.out.println("Conteúdo: \n" + conteudo);
		System.out.println("===============================");
	}
	
	public Boolean getValido() {
		return valido;
	}
	
	public void setValido(Boolean valido) {
		this.valido = valido;
	}

}
