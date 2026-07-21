package estrutura;

import java.util.ArrayList;
import java.util.List;
public class Orientador extends Coordenador{
	protected String siape;
	protected String institutoVinculado;
	protected List<Grupo_de_estudo> gruposDeEstudo;
	protected List<Evento> eventos;

	public Orientador(String nome, int idade, String email, String senha, String idInstitucional, String titulacao,
			String areaAtuacao, int limiteOrientados, String siape, String institutoVinculado) {
		super(nome, email, idade, senha, idInstitucional, titulacao, areaAtuacao, limiteOrientados);
		this.siape = siape;
		this.institutoVinculado = institutoVinculado;
		this.gruposDeEstudo = new ArrayList<>();
		this.eventos = new ArrayList<>();
	}

	public Grupo_de_estudo criarGrupoDeEstudo(int idGrupo, String nomeGrupo, String pesquisadorResponsavelDiscente, String areaDeEstudo, List<Pesquisador> pesquisadores) {
		Grupo_de_estudo grupo = new Grupo_de_estudo(idGrupo, nomeGrupo, pesquisadorResponsavelDiscente, areaDeEstudo, pesquisadores);
		gruposDeEstudo.add(grupo); //
		return grupo;
	}
	
	public void adicionarPesquisadorGrupo(Grupo_de_estudo grupo, Pesquisador pesquisador) {
		grupo.adicionarPesquisador(pesquisador);
		System.out.println(pesquisador.getNome() + " foi adicionado ao grupo " + grupo.getNomeGrupo());
	}
	
	public Evento criarEvento(int idEvento, String descricao, String prazoTexto) {
		Evento novoEvento = new Evento(idEvento, descricao, prazoTexto);
		eventos.add(novoEvento);
		return novoEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void adicionarEventoCarregado(Evento evento) {
		this.eventos.add(evento);
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
	
	public void setRelatorioValido(Relatorio r) {
		r.setValido(true);
	}
}