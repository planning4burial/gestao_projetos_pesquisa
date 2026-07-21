package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Tarefas {
	private String titulo;
	private String descricao;
	private String prazo; 
	private String status;
	private List<Relatorio> relatorios = new ArrayList<>();
	
	public Tarefas (String titulo, String descricao, String prazo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.status = "A Fazer";
	}

	public void adicionarRelatorio(Relatorio relatorio) {
		this.relatorios.add(relatorio);
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}
 
	public String getTitulo() {
		return titulo;
	}
 
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
 
	public String getDescricao() {
		return descricao;
	}
 
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
 
	public String getPrazo() {
		return prazo;
	}
 
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	@Override
	public String toString() {
		return "- " + titulo + " (" + descricao + ") | Prazo: " + prazo + " | Status: " + status;
	}
}