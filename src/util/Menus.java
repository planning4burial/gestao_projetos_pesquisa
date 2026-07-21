package util;

import java.util.List;
import java.util.Scanner;

import estrutura.Autenticavel;
import estrutura.Coordenador;
import estrutura.Evento;
import estrutura.Gestor;
import estrutura.Grupo_de_estudo;
import estrutura.Orientador;
import estrutura.Pesquisador;
import estrutura.Reuniao;
import estrutura.Tarefas;

public class Menus {

	public void menuPrincipal() {
		System.out.println("\n==================================");
		System.out.println(" SISTEMA DE GESTÃO DE PESQUISA");
		System.out.println("==================================");
		System.out.println("1 - Pesquisador");
		System.out.println("2 - Coordenador");
		System.out.println("3 - Orientador");
		System.out.println("4 - Gestor");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
	}

	public void menuPesquisador() {
		System.out.println("\n===== MENU PESQUISADOR =====");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
	}

	public void menuCoordenador() {
		System.out.println("\n===== MENU COORDENADOR =====");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
	}

	public void menuOrientador() {
		System.out.println("\n===== MENU ORIENTADOR =====");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
	}

	public void menuGestor() {
		System.out.println("\n===== MENU GESTOR =====");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
	}

	// --- SUBMENUS DE AÇÕES (pós-login) ---
	// Cada perfil herda as ações de todos os perfis "menores" na hierarquia:
	// Pesquisador << Coordenador << Orientador << Gestor

	private void exibirMenuAcoesPesquisador() {
		System.out.println("\n===== PESQUISADOR - MENU DE AÇÕES =====");
		System.out.println("1 - Visualizar tarefas");
		System.out.println("2 - Fazer upload de material");
		System.out.println("3 - Atualizar status de uma tarefa");
		System.out.println("4 - Escrever relatório de uma tarefa");
		System.out.println("0 - Logout");
		System.out.print("Escolha uma opção: ");
	}

	private void exibirMenuAcoesCoordenador() {
		System.out.println("\n===== COORDENADOR - MENU DE AÇÕES =====");
		System.out.println("--- Ações de Pesquisador ---");
		System.out.println("1 - Visualizar tarefas");
		System.out.println("2 - Fazer upload de material");
		System.out.println("3 - Atualizar status de uma tarefa");
		System.out.println("4 - Escrever relatório de uma tarefa");
		System.out.println("--- Ações de Coordenador ---");
		System.out.println("5 - Criar tarefa");
		System.out.println("6 - Agendar reunião");
		System.out.println("0 - Logout");
		System.out.print("Escolha uma opção: ");
	}

	private void exibirMenuAcoesOrientador() {
		System.out.println("\n===== ORIENTADOR - MENU DE AÇÕES =====");
		System.out.println("--- Ações de Pesquisador ---");
		System.out.println("1 - Visualizar tarefas");
		System.out.println("2 - Fazer upload de material");
		System.out.println("3 - Atualizar status de uma tarefa");
		System.out.println("4 - Escrever relatório de uma tarefa");
		System.out.println("--- Ações de Coordenador ---");
		System.out.println("5 - Criar tarefa");
		System.out.println("6 - Agendar reunião");
		System.out.println("--- Ações de Orientador ---");
		System.out.println("7 - Criar grupo de estudo");
		System.out.println("8 - Adicionar pesquisador a grupo de estudo");
		System.out.println("9 - Criar evento");
		System.out.println("0 - Logout");
		System.out.print("Escolha uma opção: ");
	}

	private void exibirMenuAcoesGestor() {
		System.out.println("\n===== GESTOR - MENU DE AÇÕES =====");
		System.out.println("--- Ações de Pesquisador ---");
		System.out.println("1 - Visualizar tarefas");
		System.out.println("2 - Fazer upload de material");
		System.out.println("3 - Atualizar status de uma tarefa");
		System.out.println("4 - Escrever relatório de uma tarefa");
		System.out.println("--- Ações de Coordenador ---");
		System.out.println("5 - Criar tarefa");
		System.out.println("6 - Agendar reunião");
		System.out.println("--- Ações de Orientador ---");
		System.out.println("7 - Criar grupo de estudo");
		System.out.println("8 - Adicionar pesquisador a grupo de estudo");
		System.out.println("9 - Criar evento");
		System.out.println("--- Ações de Gestor ---");
		System.out.println("10 - Alocar bolsa");
		System.out.println("11 - Visualizar grupos");
		System.out.println("12 - Ver métricas institucionais");
		System.out.println("0 - Logout");
		System.out.print("Escolha uma opção: ");
	}

	// --- LÓGICA DE NAVEGAÇÃO DOS SUBMENUS DE CADASTRO/LOGIN ---

	public void tratarPesquisador(Scanner s, List<Pesquisador> pesquisadores) {
		int op = -1;
		while (op != 0) {
			menuPesquisador();
			op = s.nextInt();
			s.nextLine(); // limpando buffer

			if (op == 1) {
				Pesquisador p = Cadastro.CadastrarPesquisador(s);
				pesquisadores.add(p);
				GerenciadorArquivos.salvarPesquisador(p);
				System.out.println("\n[✓] Pesquisador cadastrado e salvo com sucesso!");
			} else if (op == 2) {
				Pesquisador logado = autenticarUsuario(s, pesquisadores);
				if (logado != null) {
					menuAcoesPesquisador(s, logado);
				}
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarCoordenador(Scanner s, List<Coordenador> coordenadores, List<Pesquisador> pesquisadores) {
		int op = -1;
		while (op != 0) {
			menuCoordenador();
			op = s.nextInt();
			s.nextLine();

			if (op == 1) {
				Coordenador c = Cadastro.CadastrarCoordenador(s);
				coordenadores.add(c);
				GerenciadorArquivos.salvarCoordenador(c);
				System.out.println("\n[✓] Coordenador cadastrado e salvo com sucesso!");
			} else if (op == 2) {
				Coordenador logado = autenticarUsuario(s, coordenadores);
				if (logado != null) {
					menuAcoesCoordenador(s, logado, pesquisadores);
				}
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarOrientador(Scanner s, List<Orientador> orientadores, List<Pesquisador> pesquisadores,
			List<Grupo_de_estudo> gruposDeEstudo) {
		int op = -1;
		while (op != 0) {
			menuOrientador();
			op = s.nextInt();
			s.nextLine();

			if (op == 1) {
				Orientador o = Cadastro.CadastrarOrientador(s);
				orientadores.add(o);
				GerenciadorArquivos.salvarOrientador(o);
				System.out.println("\n[✓] Orientador cadastrado e salvo com sucesso!");
			} else if (op == 2) {
				Orientador logado = autenticarUsuario(s, orientadores);
				if (logado != null) {
					menuAcoesOrientador(s, logado, pesquisadores, gruposDeEstudo);
				}
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarGestor(Scanner s, List<Gestor> gestores, List<Pesquisador> pesquisadores,
			List<Grupo_de_estudo> gruposDeEstudo) {
		int op = -1;
		while (op != 0) {
			menuGestor();
			op = s.nextInt();
			s.nextLine();

			if (op == 1) {
				Gestor g = Cadastro.CadastrarGestor(s);
				gestores.add(g);
				GerenciadorArquivos.salvarGestor(g);
				System.out.println("\n[✓] Gestor cadastrado e salvo com sucesso!");
			} else if (op == 2) {
				Gestor logado = autenticarUsuario(s, gestores);
				if (logado != null) {
					menuAcoesGestor(s, logado, pesquisadores, gruposDeEstudo);
				}
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	private <T extends Autenticavel> T autenticarUsuario(Scanner s, List<T> listaUsuarios) {
		System.out.println("\n--- LOGIN ---");
		System.out.print("Digite seu email: ");
		String email = s.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = s.nextLine();

		for (T usuario : listaUsuarios) {
			if (usuario.realizarLogin(email, senha)) {
				return usuario;
			}
		}
		System.out.println("\n[X] Falha no login! Email ou senha incorretos.");
		return null;
	}

	// =========================================================================
	// MENUS DE AÇÕES EM CASCATA (cada perfil reaproveita as ações do anterior)
	// =========================================================================

	// --- NÍVEL 1: PESQUISADOR ---
	// Usado tanto para quem loga como Pesquisador puro, quanto reaproveitado
	// pelos níveis superiores (Coordenador, Orientador, Gestor), já que todos
	// SÃO Pesquisador por herança.

	private void menuAcoesPesquisador(Scanner s, Pesquisador p) {
		int op = -1;
		while (op != 0) {
			exibirMenuAcoesPesquisador();
			op = s.nextInt();
			s.nextLine();

			switch (op) {
			case 1:
				handleVisualizarTarefas(p);
				break;
			case 2:
				handleUploadMaterial(s, p);
				break;
			case 3:
				handleAtualizarStatus(s, p);
				break;
			case 4:
				handleEscreverRelatorio(s, p);
				break;
			case 0:
				System.out.println("\nLogout realizado. Voltando ao menu anterior...");
				break;
			default:
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	private void handleVisualizarTarefas(Pesquisador p) {
		p.visualizarTarefa();
	}

	private void handleUploadMaterial(Scanner s, Pesquisador p) {
		System.out.print("Nome do arquivo: ");
		String nomeArquivo = s.nextLine();
		System.out.print("Tipo do arquivo (ex: PDF, DOCX): ");
		String tipoArquivo = s.nextLine();
		System.out.print("Data do upload (ex: 21/07/2026): ");
		String dataUpload = s.nextLine();
		p.fazerUploadMaterial(nomeArquivo, tipoArquivo, dataUpload);
	}

	private void handleAtualizarStatus(Scanner s, Pesquisador p) {
		Tarefas tarefa = selecionarTarefa(s, p);
		if (tarefa != null) {
			System.out.print("Novo status (ex: Em andamento, Concluída): ");
			String novoStatus = s.nextLine();
			p.atualizarStatusTarefa(tarefa, novoStatus);
			GerenciadorArquivos.salvarAtualizacaoStatusTarefa(tarefa, p);
		}
	}

	private void handleEscreverRelatorio(Scanner s, Pesquisador p) {
		Tarefas tarefa = selecionarTarefa(s, p);
		if (tarefa != null) {
			System.out.print("Título do relatório: ");
			String tituloRelatorio = s.nextLine();
			System.out.print("Conteúdo do relatório: ");
			String conteudo = s.nextLine();
			p.escreverRelatorioTarefa(tarefa, tituloRelatorio, conteudo);
		}
	}

	private Tarefas selecionarTarefa(Scanner s, Pesquisador p) {
		List<Tarefas> tarefas = p.getTarefas();
		if (tarefas.isEmpty()) {
			System.out.println("\n[!] Você não possui tarefas alocadas.");
			return null;
		}
		System.out.println("\n== SUAS TAREFAS ==");
		for (int i = 0; i < tarefas.size(); i++) {
			System.out.println(i + " - " + tarefas.get(i));
		}
		System.out.print("Escolha o número da tarefa: ");
		int indice = s.nextInt();
		s.nextLine();

		if (indice < 0 || indice >= tarefas.size()) {
			System.out.println("\n[!] Tarefa inválida!");
			return null;
		}
		return tarefas.get(indice);
	}

	// --- NÍVEL 2: COORDENADOR (Pesquisador + ações próprias) ---

	private void menuAcoesCoordenador(Scanner s, Coordenador c, List<Pesquisador> pesquisadores) {
		int op = -1;
		while (op != 0) {
			exibirMenuAcoesCoordenador();
			op = s.nextInt();
			s.nextLine();

			switch (op) {
			case 1:
				handleVisualizarTarefas(c);
				break;
			case 2:
				handleUploadMaterial(s, c);
				break;
			case 3:
				handleAtualizarStatus(s, c);
				break;
			case 4:
				handleEscreverRelatorio(s, c);
				break;
			case 5:
				handleCriarTarefa(s, c, pesquisadores);
				break;
			case 6:
				handleAgendarReuniao(s, c);
				break;
			case 0:
				System.out.println("\nLogout realizado. Voltando ao menu anterior...");
				break;
			default:
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	private void handleCriarTarefa(Scanner s, Coordenador c, List<Pesquisador> pesquisadores) {
		System.out.print("Título da tarefa: ");
		String titulo = s.nextLine();
		System.out.print("Descrição da tarefa: ");
		String descricao = s.nextLine();
		System.out.print("Prazo (ex: 30/08/2026): ");
		String prazo = s.nextLine();

		Pesquisador responsavel = selecionarPesquisador(s, pesquisadores);
		Tarefas tarefa = c.criarTarefa(titulo, descricao, prazo, responsavel);

		if (responsavel != null) {
			GerenciadorArquivos.salvarTarefa(tarefa, responsavel);
			System.out.println("[✓] Tarefa salva em data/tarefas.csv");
		}
	}

	private void handleAgendarReuniao(Scanner s, Coordenador c) {
		System.out.print("Data e hora (ex: 25/07/2026 14:00): ");
		String dataHora = s.nextLine();
		System.out.print("Local: ");
		String local = s.nextLine();
		System.out.print("Pauta: ");
		String pauta = s.nextLine();
		Reuniao reuniao = c.agendarReuniao(dataHora, local, pauta);
		System.out.println("Reunião registrada: " + reuniao);
	}

	private Pesquisador selecionarPesquisador(Scanner s, List<Pesquisador> pesquisadores) {
		if (pesquisadores.isEmpty()) {
			System.out.println("\n[!] Nenhum pesquisador cadastrado. A tarefa ficará sem responsável.");
			return null;
		}
		System.out.println("\nDeseja atribuir a tarefa a um pesquisador?");
		System.out.println("0 - Não atribuir agora");
		for (int i = 0; i < pesquisadores.size(); i++) {
			System.out.println((i + 1) + " - " + pesquisadores.get(i).getNome());
		}
		System.out.print("Escolha uma opção: ");
		int escolha = s.nextInt();
		s.nextLine();

		if (escolha <= 0 || escolha > pesquisadores.size()) {
			return null;
		}
		return pesquisadores.get(escolha - 1);
	}

	// --- NÍVEL 3: ORIENTADOR (Coordenador + Pesquisador + ações próprias) ---

	private void menuAcoesOrientador(Scanner s, Orientador o, List<Pesquisador> pesquisadores,
			List<Grupo_de_estudo> gruposDeEstudo) {
		int op = -1;
		while (op != 0) {
			exibirMenuAcoesOrientador();
			op = s.nextInt();
			s.nextLine();

			switch (op) {
			case 1:
				handleVisualizarTarefas(o);
				break;
			case 2:
				handleUploadMaterial(s, o);
				break;
			case 3:
				handleAtualizarStatus(s, o);
				break;
			case 4:
				handleEscreverRelatorio(s, o);
				break;
			case 5:
				handleCriarTarefa(s, o, pesquisadores);
				break;
			case 6:
				handleAgendarReuniao(s, o);
				break;
			case 7:
				handleCriarGrupoEstudo(s, o, gruposDeEstudo);
				break;
			case 8:
				handleAdicionarPesquisadorGrupo(s, o, pesquisadores);
				break;
			case 9:
				handleCriarEvento(s, o);
				break;
			case 0:
				System.out.println("\nLogout realizado. Voltando ao menu anterior...");
				break;
			default:
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	private void handleCriarGrupoEstudo(Scanner s, Orientador o, List<Grupo_de_estudo> gruposDeEstudo) {
		System.out.print("ID do grupo: ");
		int idGrupo = s.nextInt();
		s.nextLine();
		System.out.print("Nome do grupo: ");
		String nomeGrupo = s.nextLine();
		System.out.print("Pesquisador responsável (discente): ");
		String responsavelDiscente = s.nextLine();
		System.out.print("Área de estudo: ");
		String areaDeEstudo = s.nextLine();

		Grupo_de_estudo grupo = o.criarGrupoDeEstudo(idGrupo, nomeGrupo, responsavelDiscente, areaDeEstudo,
				new java.util.ArrayList<>());
		gruposDeEstudo.add(grupo);
		System.out.println("\n[✓] Grupo de estudo \"" + nomeGrupo + "\" criado com sucesso!");
	}

	private void handleAdicionarPesquisadorGrupo(Scanner s, Orientador o, List<Pesquisador> pesquisadores) {
		Grupo_de_estudo grupo = selecionarGrupo(s, o.getGruposDeEstudo());
		if (grupo == null) {
			System.out.println("\n[!] Nenhum grupo disponível. Crie um grupo primeiro.");
			return;
		}
		Pesquisador pesquisador = selecionarPesquisador(s, pesquisadores);
		if (pesquisador == null) {
			System.out.println("\n[!] Nenhum pesquisador selecionado.");
			return;
		}
		o.adicionarPesquisadorGrupo(grupo, pesquisador);
	}

	private void handleCriarEvento(Scanner s, Orientador o) {
		System.out.print("ID do evento: ");
		int idEvento = s.nextInt();
		s.nextLine();
		System.out.print("Descrição do evento: ");
		String descricao = s.nextLine();
		System.out.print("Prazo final (formato AAAA-MM-DD): ");
		String prazoTexto = s.nextLine();
		try {
			Evento evento = o.criarEvento(idEvento, descricao, prazoTexto);
			GerenciadorArquivos.salvarEvento(evento, o);
			System.out.println("\n[✓] Evento criado e salvo em data/eventos.csv: " + evento);
		} catch (java.time.format.DateTimeParseException e) {
			System.out.println("\n[!] Data inválida. Utilize o formato AAAA-MM-DD.");
		}
	}

	private Grupo_de_estudo selecionarGrupo(Scanner s, List<Grupo_de_estudo> grupos) {
		if (grupos == null || grupos.isEmpty()) {
			return null;
		}
		System.out.println("\n== GRUPOS DISPONÍVEIS ==");
		for (int i = 0; i < grupos.size(); i++) {
			System.out.println(i + " - " + grupos.get(i).getNomeGrupo() + " (Área: " + grupos.get(i).getAreaDeEstudo() + ")");
		}
		System.out.print("Escolha o número do grupo: ");
		int indice = s.nextInt();
		s.nextLine();

		if (indice < 0 || indice >= grupos.size()) {
			System.out.println("\n[!] Grupo inválido!");
			return null;
		}
		return grupos.get(indice);
	}

	// --- NÍVEL 4: GESTOR (Orientador + Coordenador + Pesquisador + ações próprias) ---

	private void menuAcoesGestor(Scanner s, Gestor g, List<Pesquisador> pesquisadores,
			List<Grupo_de_estudo> gruposDeEstudo) {
		int op = -1;
		while (op != 0) {
			exibirMenuAcoesGestor();
			op = s.nextInt();
			s.nextLine();

			switch (op) {
			case 1:
				handleVisualizarTarefas(g);
				break;
			case 2:
				handleUploadMaterial(s, g);
				break;
			case 3:
				handleAtualizarStatus(s, g);
				break;
			case 4:
				handleEscreverRelatorio(s, g);
				break;
			case 5:
				handleCriarTarefa(s, g, pesquisadores);
				break;
			case 6:
				handleAgendarReuniao(s, g);
				break;
			case 7:
				handleCriarGrupoEstudo(s, g, gruposDeEstudo);
				break;
			case 8:
				handleAdicionarPesquisadorGrupo(s, g, pesquisadores);
				break;
			case 9:
				handleCriarEvento(s, g);
				break;
			case 10:
				handleAlocarBolsa(s, g, gruposDeEstudo);
				break;
			case 11:
				g.consultarGrupos(gruposDeEstudo);
				break;
			case 12:
				g.acessarMetricas(gruposDeEstudo);
				break;
			case 0:
				System.out.println("\nLogout realizado. Voltando ao menu anterior...");
				break;
			default:
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	private void handleAlocarBolsa(Scanner s, Gestor g, List<Grupo_de_estudo> gruposDeEstudo) {
		Grupo_de_estudo grupo = selecionarGrupo(s, gruposDeEstudo);
		if (grupo == null) {
			System.out.println("\n[!] Nenhum grupo disponível para alocação de bolsa.");
			return;
		}
		System.out.print("Valor do recurso financeiro (ex: 5000.00): ");
		double valorRecurso = s.nextDouble();
		System.out.print("Quantidade de bolsas: ");
		int quantidadeBolsas = s.nextInt();
		s.nextLine();
		g.alocacaoBolsa(grupo, valorRecurso, quantidadeBolsas);
	}
}