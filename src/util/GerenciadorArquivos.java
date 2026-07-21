package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import estrutura.Coordenador;
import estrutura.Gestor;
import estrutura.Orientador;
import estrutura.Pesquisador;

public class GerenciadorArquivos {

	private static final String PASTA_DATA = "data";
	private static final String CAMINHO_CSV = "data/usuarios.csv";
	private static final String SEPARADOR = ";";

	private static void garantirEstrutura() {
		File pasta = new File(PASTA_DATA);
		if (!pasta.exists()) {
			pasta.mkdir();
		}
	}

	private static void escreverLinha(String linha) {
		garantirEstrutura();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_CSV, true))) {
			writer.write(linha);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("Erro ao salvar no arquivo CSV: " + e.getMessage());
		}
	}

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
}