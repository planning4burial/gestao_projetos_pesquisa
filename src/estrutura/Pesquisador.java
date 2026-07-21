package estrutura;
import java.util.ArrayList;
import java.util.List;

public class Pesquisador extends Usuario {
	
	protected List <Tarefas> tarefas = new ArrayList <> ();
	protected List <Material> materiais = new ArrayList <> ();
	
	public Pesquisador(String nome, String email, int idade, String senha, String idInstitucional) {
		super(nome, email, idade, senha, idInstitucional);
		
	}
	
	public void visualizarTarefa () {
		System.out.println("\n== TAREFAS DE " + nome.toUpperCase() + " ==");
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa alocada.");
			return;
		}
		for (Tarefas t : tarefas) {
			System.out.println(t);
		}
	}
	
	public void atualizarStatusTarefa (Tarefas tarefa, String novoStatus) {
		if (!tarefas.contains(tarefa)) {
			System.out.println("Essa tarefa não pertence a " +  nome );
		}
		tarefa.setStatus(novoStatus);
		System.out.println("Status da tarefa \"" + tarefa.getTitulo() + "\" atualizado para: " + novoStatus);
		
	}
	
	public void fazerUploadMaterial(String nomeArquivo, String tipoArquivo, String dataUpload) {
		Material m = new Material(nomeArquivo,tipoArquivo, dataUpload);
		m.setAutorUpload(this);
		materiais.add(m);
		System.out.println(nome + " enviou o material: " + nomeArquivo);
		
		}
	public Relatorio escreverRelatorioTarefa(Tarefas tarefa, String tituloRelatorio, String conteudo) {
		if (!tarefas.contains(tarefa)) {
			System.out.println("Essa tarefa não pertence a " + nome + ". Relatório não pode ser criado.");
			return null;
		}
		Relatorio relatorio = new Relatorio(tituloRelatorio, conteudo, new java.util.Date(), nome, false);
		tarefa.adicionarRelatorio(relatorio);
		System.out.println(nome + " escreveu o relatório \"" + tituloRelatorio + "\" para a tarefa \"" + tarefa.getTitulo() + "\".");
		return relatorio;
	}
	
	public void receberTarefa (Tarefas tarefa) {
		this.tarefas.add(tarefa);
	}
	
	public List<Tarefas> getTarefas() {
		return tarefas;
		
	}
	
	public List<Material> getMateriais() {
		return materiais ;
	}

	@Override
	public void exibirPainel() {
		// TODO Auto-generated method stub
		System.out.println("\n===== PAINEL DO PESQUISADOR =====");
		System.out.println("Nome: " + nome + " | Email: " + email);
		visualizarTarefa();
	}
}