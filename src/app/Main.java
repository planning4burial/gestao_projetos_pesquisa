package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estrutura.Coordenador;
import estrutura.Gestor;
import estrutura.Grupo_de_estudo;
import estrutura.Orientador;
import estrutura.Pesquisador;
import util.GerenciadorArquivos;
import util.Menus;

public class Main {

	public static void main(String[] args) {
		List<Pesquisador> pesquisadores = new ArrayList<>();
		List<Coordenador> coordenadores = new ArrayList<>();
		List<Orientador> orientadores = new ArrayList<>();
		List<Gestor> gestores = new ArrayList<>();
		List<Grupo_de_estudo> gruposDeEstudo = new ArrayList<>();

		// carregando dados previamente salvos
		GerenciadorArquivos.carregarUsuarios(pesquisadores, coordenadores, orientadores, gestores);

		// Coordenador, Orientador e Gestor também SÃO Pesquisador (herança), por isso
		// tarefas podem ter sido atribuídas a qualquer um deles. Uma lista combinada
		// permite localizar o responsável correto pelo e-mail ao carregar o CSV.
		List<Pesquisador> todosPesquisadores = new ArrayList<>();
		todosPesquisadores.addAll(pesquisadores);
		todosPesquisadores.addAll(coordenadores);
		todosPesquisadores.addAll(orientadores);
		todosPesquisadores.addAll(gestores);
		GerenciadorArquivos.carregarTarefas(todosPesquisadores);

		// Da mesma forma, Gestor também É Orientador (herança), então eventos podem
		// ter sido criados por um Gestor.
		List<Orientador> todosOrientadores = new ArrayList<>();
		todosOrientadores.addAll(orientadores);
		todosOrientadores.addAll(gestores);
		GerenciadorArquivos.carregarEventos(todosOrientadores);

		Scanner s = new Scanner(System.in);
		Menus menus = new Menus();
		int opcaoPrincipal = -1;

		while (opcaoPrincipal != 0) {
			menus.menuPrincipal();
			opcaoPrincipal = s.nextInt();
			s.nextLine(); // limpando buffer

			switch (opcaoPrincipal) {
			case 1:
				menus.tratarPesquisador(s, pesquisadores);
				break;
			case 2:
				menus.tratarCoordenador(s, coordenadores, pesquisadores);
				break;
			case 3:
				menus.tratarOrientador(s, orientadores, pesquisadores, gruposDeEstudo);
				break;
			case 4:
				menus.tratarGestor(s, gestores, pesquisadores, gruposDeEstudo);
				break;
			case 0:
				System.out.println("\nSaindo do sistema...");
				break;
			default:
				System.out.println("\n[!] Opcao invalida. tente novamente.");
			}
		}

		s.close();
	}
}