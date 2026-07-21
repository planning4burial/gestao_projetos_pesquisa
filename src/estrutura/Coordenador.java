package estrutura;

public class Coordenador extends Pesquisador {
	protected String titulacao;
	protected String areaAtuacao;
	protected int limiteOrientados;
	protected Subgrupo_pesquisa subgrupo;

	public Coordenador(String nome, String email, int idade, String senha, String idInstitucional, String titulacao,
			String areaAtuacao, int limiteOrientados) {

		super(nome, email, idade, senha, idInstitucional);
		this.titulacao = titulacao;
		this.areaAtuacao = areaAtuacao;
		this.limiteOrientados = limiteOrientados;

	}

	public Tarefas criarTarefa(String titulo, String descricao, String prazo, Pesquisador responsavel) {
		Tarefas tarefa = new Tarefas(titulo, descricao, prazo);
		System.out.println(nome + "criou a tarefa \"" + titulo + "\".");
		if (responsavel != null) {
			responsavel.receberTarefa(tarefa);
			System.out.println("Tarefa alocada para " + responsavel.getNome() + ".");

		}
		return tarefa;

	}

	public Reuniao agendarReuniao(String dataHora, String local, String pauta) {
		Reuniao reuniao = new Reuniao(dataHora, local, pauta);
		System.out.println(nome + " agendou uma reunião: " + reuniao);
		return reuniao;

	}

	public void adicionarMembroSubgrupo(Pesquisador p) {
		if (subgrupo == null) {
			System.out.println(nome + " não coordena nenhum subgrupo ");
			return;
		}
		subgrupo.adicionarMembro(p);
		System.out.println(p.getNome() + " adicionado ao subgrupo " + subgrupo.getNome() + ".");
	}

	public void removerMembroSubgrupo(Pesquisador p) {
		if (subgrupo == null) {
			System.out.println(nome + " não coordena nenhum subgrupo ");
			return;
		}
		subgrupo.removerMembro(p);
		System.out.println(p.getNome() + " removido do subgrupo " + subgrupo.getNome() + ".");

	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public int getLimiteOrientados() {
		return limiteOrientados;
	}

	public void setLimiteOrientados(int limiteOrientados) {
		this.limiteOrientados = limiteOrientados;
	}

	@Override
	public void exibirPainel() {
		// TODO Auto-generated method stub
		System.out.println("\n===== PAINEL DO COORDENADOR =====");
		System.out.println("Nome: " + nome + " | Área: " + areaAtuacao + " | Titulação: " + titulacao);
		System.out.println("Subgrupo: " + (subgrupo == null ? "nenhum" : subgrupo.getNome()));
		visualizarTarefa();
	}

}
