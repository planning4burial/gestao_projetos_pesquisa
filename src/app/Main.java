package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estrutura.Coordenador;
import estrutura.Gestor;
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

		// carregando dados previamente salvos
		GerenciadorArquivos.carregarUsuarios(pesquisadores, coordenadores, orientadores, gestores);

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
				menus.tratarCoordenador(s, coordenadores);
				break;
			case 3:
				menus.tratarOrientador(s, orientadores);
				break;
			case 4:
				menus.tratarGestor(s, gestores);
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