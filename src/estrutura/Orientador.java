package estrutura;

import java.util.ArrayList;
import java.util.List;
public class Orientador extends Coordenador{
	protected String siape;
	protected String institutoVinculado;
	protected List<Grupo_de_estudo> gruposDeEstudo;

	public Orientador(String nome, int idade, String email, String senha, String idInstitucional, String titulacao,
			String areaAtuacao, int limiteOrientados, String siape, String institutoVinculado) {
		super(nome, email, idade, senha, idInstitucional, titulacao, areaAtuacao, limiteOrientados);
		this.siape = siape;
		this.institutoVinculado = institutoVinculado;
		this.gruposDeEstudo = new ArrayList<>();
	}
	
	public void criarGrupoDeEstudo(String nomeGrupo) {
		
	}
	
	public void editarGrupoDeEstudo() {
		
	}
	
	public void adicionarDiscenteGrupo() {
		
	}

	public Evento criarEvento(int idEvento, String descricao, String prazoTexto) {
		Evento novoEvento = new Evento(idEvento, descricao, prazoTexto);
		return novoEvento;
	}
	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getInstitutoVinculado() {
		return institutoVinculado;
	}

	public void setInstitutoVinculado(String institutoVinculado) {
		this.institutoVinculado = institutoVinculado;
	}

	public List<Grupo_de_estudo> getGruposDeEstudo() {
		return gruposDeEstudo;
	}

	public void setGruposDeEstudo(List<Grupo_de_estudo> gruposDeEstudo) {
		this.gruposDeEstudo = gruposDeEstudo;
	}
	
	

}
