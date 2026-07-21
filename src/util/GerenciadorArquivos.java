package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import estrutura.Coordenador;
import estrutura.Evento;
import estrutura.Gestor;
import estrutura.Orientador;
import estrutura.Pesquisador;
import estrutura.Tarefas;

public class GerenciadorArquivos {

	private static final String PASTA_DATA = "data";
	private static final String CAMINHO_CSV = "data/usuarios.csv";
	private static final String CAMINHO_TAREFAS_CSV = "data/tarefas.csv";
	private static final String CAMINHO_EVENTOS_CSV = "data/eventos.csv";
	private static final String SEPARADOR = ";";

	private static void garantirEstrutura() {
		File pasta = new File(PASTA_DATA);
		if (!pasta.exists()) {
			pasta.mkdir();
		}
	}

	private static void escreverLinhaEm(String caminho, String linha) {
		garantirEstrutura();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
			writer.write(linha);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("Erro ao salvar no arquivo CSV: " + e.getMessage());
		}
	}

	private static void escreverLinha(String linha) {
		escreverLinhaEm(CAMINHO_CSV, linha);
	}

	// ================== USUÁRIOS ==================

	public static void salvarPesquisador(Pesquisador p) {
		// Formato: PESQUISADOR;nome;email;idade;senha;idInstitucional
		String linha = String.join(SEPARADOR, "PESQUISADOR", p.getNome(), p.getEmail(), String.valueOf(p.getIdade()),
				p.getSenha(), p.getIdInstitucional());
		escreverLinha(linha);
	}

	public static void salvarCoordenador(Coordenador c) {
		// Formato:
		// COORDENADOR;nome;email;idade;senha;idInstitucional;titulacao;areaAtuacao;limiteOrientados
		String linha = String.join(SEPARADOR, "COORDENADOR", c.getNome(), c.getEmail(), String.valueOf(c.getIdade()),
				c.getSenha(), c.getIdInstitucional(), c.getTitulacao(), c.getAreaAtuacao(),
				String.valueOf(c.getLimiteOrientados()));
		escreverLinha(linha);
	}

	public static void salvarOrientador(Orientador o) {
		// Formato:
		// ORIENTADOR;nome;email;idade;senha;idInstitucional;titulacao;areaAtuacao;limiteOrientados;siape;institutoVinculado
		String linha = String.join(SEPARADOR, "ORIENTADOR", o.getNome(), o.getEmail(), String.valueOf(o.getIdade()),
				o.getSenha(), o.getIdInstitucional(), o.getTitulacao(), o.getAreaAtuacao(),
				String.valueOf(o.getLimiteOrientados()), o.getSiape(), o.getInstitutoVinculado());
		escreverLinha(linha);
	}

	public static void salvarGestor(Gestor g) {
		// Formato:
		// GESTOR;nome;email;idade;senha;idInstitucional;titulacao;areaAtuacao;limiteOrientados;siape;institutoVinculado
		String linha = String.join(SEPARADOR, "GESTOR", g.getNome(), g.getEmail(), String.valueOf(g.getIdade()),
				g.getSenha(), g.getIdInstitucional(), g.getTitulacao(), g.getAreaAtuacao(),
				String.valueOf(g.getLimiteOrientados()), g.getSiape(), g.getInstitutoVinculado());
		escreverLinha(linha);
	}

	// leitura inicia automaticamente ao abrir o software
	public static void carregarUsuarios(List<Pesquisador> pesquisadores, List<Coordenador> coordenadores,
			List<Orientador> orientadores, List<Gestor> gestores) {

		File arquivo = new File(CAMINHO_CSV);
		if (!arquivo.exists()) {
			return; // Caso arquivo nao exista, sera criado
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.trim().isEmpty())
					continue;

				String[] campos = linha.split(SEPARADOR);
				String tipo = campos[0];

				switch (tipo) {
				case "PESQUISADOR":
					Pesquisador p = new Pesquisador(campos[1], // nome
							campos[2], // email
							Integer.parseInt(campos[3]), // idade
							campos[4], // senha
							campos[5] // idInstitucional
					);
					pesquisadores.add(p);
					break;

				case "COORDENADOR":
					Coordenador c = new Coordenador(campos[1], // nome
							campos[2], // email
							Integer.parseInt(campos[3]), // idade
							campos[4], // senha
							campos[5], // idInstitucional
							campos[6], // titulacao
							campos[7], // areaAtuacao
							Integer.parseInt(campos[8]) // limiteOrientados
					);
					coordenadores.add(c);
					break;

				case "ORIENTADOR":
					Orientador o = new Orientador(campos[1], // nome
							Integer.parseInt(campos[3]), // idade
							campos[2], // email
							campos[4], // senha
							campos[5], // idInstitucional
							campos[6], // titulacao
							campos[7], // areaAtuacao
							Integer.parseInt(campos[8]), // limiteOrientados
							campos[9], // siape
							campos[10] // institutoVinculado
					);
					orientadores.add(o);
					break;

				case "GESTOR":
					Gestor g = new Gestor(campos[1], // nome
							Integer.parseInt(campos[3]), // idade
							campos[2], // email
							campos[4], // senha
							campos[5], // idInstitucional
							campos[6], // titulacao
							campos[7], // areaAtuacao
							Integer.parseInt(campos[8]), // limiteOrientados
							campos[9], // siape
							campos[10] // institutoVinculado
					);
					gestores.add(g);
					break;
				}
			}
			System.out.println("Dados de usuarios carregados com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao ler os dados do arquivo CSV: " + e.getMessage());
		}
	}

	// ================== TAREFAS ==================

	/**
	 * Salva o registro de CRIAÇÃO de uma tarefa vinculada ao pesquisador responsável.
	 * Formato: TAREFA;titulo;descricao;prazo;status;emailResponsavel
	 */
	public static void salvarTarefa(Tarefas tarefa, Pesquisador responsavel) {
		if (responsavel == null) {
			System.out.println("[!] Tarefa não persistida: nenhum responsável foi atribuído.");
			return;
		}
		String linha = String.join(SEPARADOR, "TAREFA", tarefa.getTitulo(), tarefa.getDescricao(),
				tarefa.getPrazo(), tarefa.getStatus(), responsavel.getEmail());
		escreverLinhaEm(CAMINHO_TAREFAS_CSV, linha);
	}

	/**
	 * Salva um registro de ATUALIZAÇÃO DE STATUS de uma tarefa já existente.
	 * Formato: TAREFA_STATUS;titulo;emailResponsavel;novoStatus
	 * Esse formato de "log" evita ter que reescrever o arquivo inteiro a cada
	 * mudança de status.
	 */
	public static void salvarAtualizacaoStatusTarefa(Tarefas tarefa, Pesquisador responsavel) {
		if (responsavel == null) {
			return;
		}
		String linha = String.join(SEPARADOR, "TAREFA_STATUS", tarefa.getTitulo(), responsavel.getEmail(),
				tarefa.getStatus());
		escreverLinhaEm(CAMINHO_TAREFAS_CSV, linha);
	}

	/**
	 * Carrega as tarefas persistidas (registros TAREFA) e aplica, em sequência,
	 * as atualizações de status (registros TAREFA_STATUS), reconstruindo o
	 * estado final de cada tarefa. O responsável é localizado pelo e-mail entre
	 * pesquisadores, coordenadores, orientadores e gestores (todos são subtipos
	 * de Pesquisador, por herança).
	 */
	public static void carregarTarefas(List<Pesquisador> todosPesquisadores) {
		File arquivo = new File(CAMINHO_TAREFAS_CSV);
		if (!arquivo.exists()) {
			return;
		}

		java.util.Map<String, Tarefas> indice = new java.util.HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.trim().isEmpty())
					continue;

				String[] campos = linha.split(SEPARADOR, -1);
				String tipo = campos[0];

				if ("TAREFA".equals(tipo) && campos.length >= 6) {
					String titulo = campos[1];
					String descricao = campos[2];
					String prazo = campos[3];
					String status = campos[4];
					String emailResponsavel = campos[5];

					Pesquisador responsavel = buscarPorEmail(todosPesquisadores, emailResponsavel);
					if (responsavel == null) {
						continue; // responsável não encontrado (ex: usuário removido)
					}

					Tarefas tarefa = new Tarefas(titulo, descricao, prazo);
					tarefa.setStatus(status);
					responsavel.receberTarefa(tarefa);
					indice.put(emailResponsavel + "::" + titulo, tarefa);

				} else if ("TAREFA_STATUS".equals(tipo) && campos.length >= 4) {
					String titulo = campos[1];
					String emailResponsavel = campos[2];
					String novoStatus = campos[3];

					Tarefas tarefa = indice.get(emailResponsavel + "::" + titulo);
					if (tarefa != null) {
						tarefa.setStatus(novoStatus);
					}
				}
			}
			System.out.println("Dados de tarefas carregados com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao ler as tarefas do arquivo CSV: " + e.getMessage());
		}
	}

	private static Pesquisador buscarPorEmail(List<Pesquisador> pesquisadores, String email) {
		for (Pesquisador p : pesquisadores) {
			if (p.getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}

	// ================== EVENTOS ==================

	/**
	 * Salva um evento vinculado ao orientador que o criou.
	 * Formato: EVENTO;idEvento;descricao;prazoFinal(AAAA-MM-DD);emailCriador
	 */
	public static void salvarEvento(Evento evento, Orientador criador) {
		String linha = String.join(SEPARADOR, "EVENTO", String.valueOf(evento.getIdEvento()), evento.getDescricao(),
				evento.getPrazoFinal().toString(), criador.getEmail());
		escreverLinhaEm(CAMINHO_EVENTOS_CSV, linha);
	}

	/**
	 * Carrega os eventos persistidos e os vincula ao orientador que os criou,
	 * localizado pelo e-mail.
	 */
	public static void carregarEventos(List<Orientador> orientadores) {
		File arquivo = new File(CAMINHO_EVENTOS_CSV);
		if (!arquivo.exists()) {
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.trim().isEmpty())
					continue;

				String[] campos = linha.split(SEPARADOR, -1);
				if (!"EVENTO".equals(campos[0]) || campos.length < 5) {
					continue;
				}

				int idEvento = Integer.parseInt(campos[1]);
				String descricao = campos[2];
				String prazoFinal = campos[3];
				String emailCriador = campos[4];

				Orientador criador = null;
				for (Orientador o : orientadores) {
					if (o.getEmail().equals(emailCriador)) {
						criador = o;
						break;
					}
				}
				if (criador == null) {
					continue; // criador não encontrado
				}

				Evento evento = new Evento(idEvento, descricao, prazoFinal);
				criador.adicionarEventoCarregado(evento);
			}
			System.out.println("Dados de eventos carregados com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao ler os eventos do arquivo CSV: " + e.getMessage());
		}
	}
}