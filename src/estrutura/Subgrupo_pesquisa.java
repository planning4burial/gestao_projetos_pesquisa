package estrutura;
import java.util.List;
import java.util.ArrayList;
public class Subgrupo_pesquisa {
	private int id;
	private String nome;
	private String objetoDeEstudo;
	private List<Pesquisador> membros;
	private Grupo_de_estudo grupo;

	public Subgrupo_pesquisa(int id, String nome, String objetoDeEstudo, List<Pesquisador> membros) {
		this.id = id;
		this.nome = nome;
		this.objetoDeEstudo = objetoDeEstudo;
		this.membros = (membros != null)
				? membros
				: new ArrayList<>();
	}
	
	public void adicionarMembro(Pesquisador p) {
		this.membros.add(p);	
	}
	
	public void removerMembro(Pesquisador p) {
		this.membros.remove(p);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetoDeEstudo() {
		return objetoDeEstudo;
	}

	public void setObjetoDeEstudo(String objetoDeEstudo) {
		this.objetoDeEstudo = objetoDeEstudo;
	}

	public List<Pesquisador> getMembros() {
		return membros;
	}

	public void setMembros(List<Pesquisador> membros) {
		this.membros = membros;
	}

	public Grupo_de_estudo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo_de_estudo grupo) {
		this.grupo = grupo;
	}
}
