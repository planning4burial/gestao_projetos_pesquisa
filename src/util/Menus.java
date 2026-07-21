package util;

import java.util.List;
import java.util.Scanner;

import estrutura.Autenticavel;
import estrutura.Coordenador;
import estrutura.Gestor;
import estrutura.Orientador;
import estrutura.Pesquisador;

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

	// --- LÓGICA DE NAVEGAÇÃO DOS SUBMENUS ---

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
				realizarLogin(s, pesquisadores);
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarCoordenador(Scanner s, List<Coordenador> coordenadores) {
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
				realizarLogin(s, coordenadores);
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarOrientador(Scanner s, List<Orientador> orientadores) {
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
				realizarLogin(s, orientadores);
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	public void tratarGestor(Scanner s, List<Gestor> gestores) {
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
				realizarLogin(s, gestores);
			} else if (op != 0) {
				System.out.println("\n[!] Opção inválida!");
			}
		}
	}

	// Método auxiliar privado de Login
	private <T extends Autenticavel> void realizarLogin(Scanner s, List<T> listaUsuarios) {
		System.out.println("\n--- LOGIN ---");
		System.out.print("Digite seu email: ");
		String email = s.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = s.nextLine();

		boolean autenticado = false;
		for (T usuario : listaUsuarios) {
			if (usuario.realizarLogin(email, senha)) {
				autenticado = true;
				break;
			}
		}

		if (autenticado) {
			System.out.println("\n[✓] Login realizado com sucesso!");
		} else {
			System.out.println("\n[X] Falha no login! Email ou senha incorretos.");
		}
	}
}